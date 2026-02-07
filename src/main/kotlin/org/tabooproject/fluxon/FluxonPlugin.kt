package org.tabooproject.fluxon

import org.tabooproject.fluxon.compiler.FluxonFeatures
import org.tabooproject.fluxon.inst.function.FunctionJvm
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.env.RuntimeDependencies
import taboolib.common.env.RuntimeDependency
import taboolib.common.platform.Awake
import taboolib.common.util.runSync

@RuntimeDependencies(
    RuntimeDependency("org.ow2.asm:asm:9.8", test = "org.objectweb.asm.ClassReader"),
    RuntimeDependency("org.ow2.asm:asm-util:9.8", test = "org.objectweb.asm.tree.MethodNode"),
    RuntimeDependency("org.ow2.asm:asm-commons:9.8", test = "org.objectweb.asm.commons.MethodRemapper"),
)
object FluxonPlugin {

    /**
     * 全局特性：是否允许在非脚本环境使用调度器
     * 当启用时，允许在非脚本环境使用调度器，例如 submit、runAsync 等
     * 默认值：false（禁用），避免内存泄漏风险
     */
    var DEFAULT_ALLOW_EXECUTE_TASK_ON_NON_SCRIPT_ENV = false

    @Awake(LifeCycle.INIT)
    fun init() {
        // 启用特性
        FluxonFeatures.DEFAULT_ALLOW_INVALID_REFERENCE = true
        FluxonFeatures.DEFAULT_ALLOW_REFLECTION_ACCESS = true
        FluxonFeatures.DEFAULT_ALLOW_JAVA_CONSTRUCTION = true
        FluxonFeatures.DEFAULT_PACKAGE_AUTO_IMPORT.addAll(listOf("fs:time", "fs:crypto", "fs:reflect", "fs:io", "fs:jvm"))
        // 注册函数
        FunctionJvm.init(FluxonRuntime.getInstance())
        // 注册主线程执行器
        FluxonRuntime.getInstance().setPrimaryThreadExecutor {
            runSync { it.run() }
        }
    }
}