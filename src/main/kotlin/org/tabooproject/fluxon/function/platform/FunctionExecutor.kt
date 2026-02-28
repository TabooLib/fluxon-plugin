package org.tabooproject.fluxon.function.platform

import org.tabooproject.fluxon.FluxonPlugin
import org.tabooproject.fluxon.runtime.Environment
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Function
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.java.Export
import org.tabooproject.fluxon.util.getFluxonScript
import org.tabooproject.fluxon.util.invokeInline
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.function.submit
import taboolib.common.platform.function.warning
import taboolib.common.platform.service.PlatformExecutor
import java.util.*

object FunctionExecutor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // 注册扩展函数
            registerExtensionFunction(PlatformExecutor.PlatformTask::class.java, null, "cancel", returnsVoid().noParams(), { it.target!!.cancel() }, false, false)
            // Builder 模式
            exportRegistry.registerClass(TaskBuilder::class.java)
            registerFunction("submit", returnsObject().noParams()) { it.setReturnRef(TaskBuilder(it.environment)) }
            // 快捷函数：立即执行
            registerFunction("run", returnsObject().params(Type.OBJECT)) { context ->
                val lambda = context.getRef(0) as Function
                context.setReturnRef(executeTask(lambda, context.environment, async = false, delay = 0, period = 0))}
            registerFunction("runAsync", returnsObject().params(Type.OBJECT)) { context ->
                val lambda = context.getRef(0) as Function
                context.setReturnRef(executeTask(lambda, context.environment, async = true, delay = 0, period = 0))}
            // 快捷函数：延迟执行
            registerFunction("runLater", returnsObject().params(Type.J, Type.OBJECT)) { context ->
                val delay = context.getLong(0)
                val lambda = context.getRef(1) as Function
                context.setReturnRef(executeTask(lambda, context.environment, async = false, delay = delay, period = 0))}
            registerFunction("runAsyncLater", returnsObject().params(Type.J, Type.OBJECT)) { context ->
                val delay = context.getLong(0)
                val lambda = context.getRef(1) as Function
                context.setReturnRef(executeTask(lambda, context.environment, async = true, delay = delay, period = 0))}
            // 快捷函数：定时执行
            registerFunction("runTimer", returnsObject().params(Type.J, Type.J, Type.OBJECT)) { context ->
                val delay = context.getLong(0)
                val period = context.getLong(1)
                val lambda = context.getRef(2) as Function
                context.setReturnRef(executeTask(lambda, context.environment, async = false, delay = delay, period = period))}
            registerFunction("runAsyncTimer", returnsObject().params(Type.J, Type.J, Type.OBJECT)) { context ->
                val delay = context.getLong(0)
                val period = context.getLong(1)
                val lambda = context.getRef(2) as Function
                context.setReturnRef(executeTask(lambda, context.environment, async = true, delay = delay, period = period))}
        }
    }

    /**
     * 执行任务的核心方法
     */
    fun executeTask(
        lambda: Function,
        env: Environment,
        async: Boolean,
        delay: Long,
        period: Long
    ): PlatformExecutor.PlatformTask? {
        val script = env.getFluxonScript()
        if (script == null) {
            if (!FluxonPlugin.DEFAULT_ALLOW_EXECUTE_TASK_ON_NON_SCRIPT_ENV) {
                warning("无法注册调度器：没有找到脚本环境。")
                return null
            }
        }
        val task = submit(async = async, delay = delay, period = period) {
            lambda.invokeInline(env, 1, this, null, null, null, this)
        }
        // 如果是周期性任务，注册为可释放资源
        if (script != null) {
            if (period > 0) {
                val resourceId = "task_${UUID.randomUUID()}"
                script.resources[resourceId] = AutoCloseable {
                    task.cancel()
                }
            }
        }
        return task
    }

    /**
     * 任务构建器
     */
    class TaskBuilder(val env: Environment) {

        var async = false
        var delay = 0L
        var period = 0L

        @Export
        fun async(): TaskBuilder {
            this.async = true
            return this
        }

        @Export
        fun delay(ticks: Long): TaskBuilder {
            this.delay = ticks
            return this
        }

        @Export
        fun period(ticks: Long): TaskBuilder {
            this.period = ticks
            return this
        }

        @Export
        fun run(fn: Function): PlatformExecutor.PlatformTask? {
            return executeTask(fn, env, async, delay, period)
        }
    }
}
