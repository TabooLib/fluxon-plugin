package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.FluxonScript
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionContext
import org.tabooproject.fluxon.util.getFluxonScript
import org.tabooproject.fluxon.util.invokeInline
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.event.EventPriority
import taboolib.common.platform.event.PostOrder
import taboolib.common.platform.event.ProxyListener
import taboolib.common.platform.function.*
import java.util.*

object FunctionListener {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // 注册扩展函数
            registerExtensionFunction(ProxyListener::class.java, "cancel", 0) { unregisterListener(it.target!!) }
            registerFunction("listenBukkit", listOf(2, 3, 4)) {
                val env = it.environment
                val script = env.getFluxonScript()
                if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    return@registerFunction null
                }
                val bind = it.tryGetClass(0)
                val property = it.tryGetBukkitProperty(1)
                val ignoreCancelled = it.getBoolean(if (property == null) 1 else 2)
                val fn = it.getFunction(it.argumentCount - 1)
                registerLifeCycleTask(LifeCycle.ENABLE) {
                    registerBukkitListener(bind, property ?: EventPriority.NORMAL, ignoreCancelled) { event ->
                        fn.invokeInline(env, 1, event, null, null, null, event)
                    }.registerResource(script)
                }
            }
            registerFunction("listenBungee", listOf(2, 3, 4)) {
                val env = it.environment
                val script = env.getFluxonScript()
                if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    return@registerFunction null
                }
                val bind = it.tryGetClass(0)
                val property = it.getNumberOrNull(1)
                val ignoreCancelled = it.getBoolean(if (property == null) 1 else 2)
                val fn = it.getFunction(it.argumentCount - 1)
                registerLifeCycleTask(LifeCycle.ENABLE) {
                    registerBungeeListener(bind, property?.toInt() ?: 0, ignoreCancelled) { event ->
                        fn.invokeInline(env, 1, event, null, null, null, event)
                    }.registerResource(script)
                }
            }
            registerFunction("listenVelocity", listOf(2, 3)) {
                val env = it.environment
                val script = env.getFluxonScript()
                if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    return@registerFunction null
                }
                val bind = it.tryGetClass(0)
                val property = it.tryGetVelocityProperty(1)
                val fn = it.getFunction(it.argumentCount - 1)
                registerLifeCycleTask(LifeCycle.ENABLE) {
                    registerVelocityListener(bind, property) { event ->
                        fn.invokeInline(env, 1, event, null, null, null, event)
                    }.registerResource(script)
                }
            }
        }
    }

    private fun FunctionContext<Any>.tryGetClass(i: Int): Class<*> {
        val any = getArgument(i)
        if (any is Class<*>) return any
        if (any is String) return Class.forName(any)
        error("Argument #$i is not Class or String: $any")
    }

    private fun FunctionContext<Any>.tryGetBukkitProperty(i: Int): EventPriority? {
        val any = getArgument(i)
        if (any is EventPriority) return any
        if (any is String) return EventPriority.valueOf(any.uppercase())
        return null
    }

    private fun FunctionContext<Any>.tryGetVelocityProperty(i: Int): PostOrder {
        val any = getArgument(i)
        if (any is PostOrder) return any
        if (any is String) return PostOrder.valueOf(any.uppercase())
        return PostOrder.NORMAL
    }

    private fun ProxyListener.registerResource(script: FluxonScript) {
        script.resources["listen_${UUID.randomUUID()}"] = AutoCloseable {
            unregisterListener(this)
        }
    }
}