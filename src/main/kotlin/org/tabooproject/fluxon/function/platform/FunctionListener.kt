package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.FluxonScript
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Function
import org.tabooproject.fluxon.runtime.FunctionContext
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes
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
            registerExtensionFunction(ProxyListener::class.java, null, "cancel", returnsVoid().noParams(), { unregisterListener(it.target!!) }, false, false)
            // listenBukkit - 2 参数
            registerFunction("listenBukkit", returnsVoid().params(Type.CLASS, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val fn = it.getRef(1) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerBukkitListener(bind, EventPriority.NORMAL, false) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenBukkit - 3 参数 (class, priority/ignoreCancelled, fn)
            // FIXME Type.OBJECT
            registerFunction("listenBukkit", returnsVoid().params(Type.CLASS, Type.OBJECT, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val property = it.tryGetBukkitProperty(1)
                    val ignoreCancelled = if (property == null) it.getRef(1) as? Boolean ?: false else false
                    val fn = it.getRef(2) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerBukkitListener(bind, property ?: EventPriority.NORMAL, ignoreCancelled) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenBukkit - 4 参数 (class, priority, ignoreCancelled, fn)
            // FIXME Type.OBJECT
            registerFunction("listenBukkit", returnsVoid().params(Type.CLASS, Type.OBJECT, Type.Z, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val property = it.tryGetBukkitProperty(1) ?: EventPriority.NORMAL
                    val ignoreCancelled = it.getBool(2)
                    val fn = it.getRef(3) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerBukkitListener(bind, property, ignoreCancelled) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenBungee - 2 参数
            registerFunction("listenBungee", returnsVoid().params(Type.CLASS, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val fn = it.getRef(1) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerBungeeListener(bind, 0, false) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenBungee - 3 参数
            registerFunction("listenBungee", returnsVoid().params(Type.CLASS, Type.OBJECT, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val arg1 = it.getRef(1)
                    val property = if (arg1 is Number) arg1.toInt() else null
                    val ignoreCancelled = if (property == null) arg1 as? Boolean ?: false else false
                    val fn = it.getRef(2) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerBungeeListener(bind, property ?: 0, ignoreCancelled) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenBungee - 4 参数
            registerFunction("listenBungee", returnsVoid().params(Type.CLASS, Type.I, Type.Z, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val property = it.getInt(1)
                    val ignoreCancelled = it.getBool(2)
                    val fn = it.getRef(3) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerBungeeListener(bind, property, ignoreCancelled) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenVelocity - 2 参数
            registerFunction("listenVelocity", returnsVoid().params(Type.CLASS, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val fn = it.getRef(1) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerVelocityListener(bind, PostOrder.NORMAL) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
            // listenVelocity - 3 参数
            registerFunction("listenVelocity", returnsVoid().params(Type.CLASS, Type.OBJECT, StandardTypes.FLUXON_FUNCTION)) {
                val env = it.environment
                val script = env.getFluxonScript()
                it.setReturnRef(if (script == null) {
                    warning("无法注册监听器：没有找到脚本环境。")
                    null
                } else {
                    val bind = it.tryGetClass(0)
                    val property = it.tryGetVelocityProperty(1)
                    val fn = it.getRef(2) as Function
                    registerLifeCycleTask(LifeCycle.ENABLE) {
                        registerVelocityListener(bind, property) { event ->
                            fn.invokeInline(env, 1, event, null, null, null, event)
                        }.registerResource(script)
                    }
                })
            }
        }
    }

    private fun FunctionContext<*>.tryGetClass(i: Int): Class<*> {
        val any = getRef(i)
        if (any is Class<*>) return any
        if (any is String) return Class.forName(any)
        error("Argument #$i is not Class or String: $any")
    }

    private fun FunctionContext<*>.tryGetBukkitProperty(i: Int): EventPriority? {
        val any = getRef(i)
        if (any is EventPriority) return any
        if (any is String) return EventPriority.valueOf(any.uppercase())
        return null
    }

    private fun FunctionContext<*>.tryGetVelocityProperty(i: Int): PostOrder {
        val any = getRef(i)
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
