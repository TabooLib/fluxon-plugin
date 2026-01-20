package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissibleBase
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPermissibleBase {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissibleBase::class.java)
                .function("isOp", 0) { it.target?.isOp }
                .function("setOp", 1) { it.target?.setOp(it.getBoolean(0)) }
                .function("isPermissionSet", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.isPermissionSet(var1)
                        is Permission -> it.target?.isPermissionSet(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                .function("hasPermission", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.hasPermission(var1)
                        is Permission -> it.target?.hasPermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                .function("addAttachment", listOf(1, 2, 3, 4)) {
                    when (it.arguments.size) {
                        1 -> it.target?.addAttachment(it.getArgument(0) as Plugin)
                        2 -> it.target?.addAttachment(
                            it.getArgument(0) as Plugin,
                            it.getNumber(1).toInt()
                        )

                        3 -> it.target?.addAttachment(
                            it.getArgument(0) as Plugin,
                            it.getString(1)!!,
                            it.getBoolean(2)
                        )

                        4 -> it.target?.addAttachment(
                            it.getArgument(0) as Plugin,
                            it.getString(1)!!,
                            it.getBoolean(2),
                            it.getNumber(3).toInt()
                        )
                        else -> error("PermissibleBase#addAttachment 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function(
                    "removeAttachment",
                    1
                ) { it.target?.removeAttachment(it.getArgument(0) as PermissionAttachment) }
                .function("recalculatePermissions", 0) { it.target?.recalculatePermissions() }
                .function("effectivePermissions", 0) { it.target?.effectivePermissions }

//            registerExtension(PermissibleBase.RemoveAttachmentRunnable::class.java)
//                .function("run", 0) { it.target?.run() }
        }
    }
}
