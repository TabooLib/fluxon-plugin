package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissibleBase
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
                    // boolean isPermissionSet(@NotNull String name)
                    // boolean isPermissionSet(@NotNull Permission perm)
                    TODO()
                }
                .function("hasPermission", 1) {
                    // boolean hasPermission(@NotNull String inName)
                    // boolean hasPermission(@NotNull Permission perm)
                    TODO()
                }
                .function("addAttachment", 3) {
                    it.target?.addAttachment(
                        it.getArgument(0) as Plugin,
                        it.getString(1)!!,
                        it.getBoolean(2)
                    )
                }
                .function("addAttachment", 1) { it.target?.addAttachment(it.getArgument(0) as Plugin) }
                .function(
                    "removeAttachment",
                    1
                ) { it.target?.removeAttachment(it.getArgument(0) as PermissionAttachment) }
                .function("recalculatePermissions", 0) { it.target?.recalculatePermissions() }
                .function("addAttachment", 4) {
                    it.target?.addAttachment(
                        it.getArgument(0) as Plugin,
                        it.getString(1)!!,
                        it.getBoolean(2),
                        it.getNumber(3).toInt()
                    )
                }
                .function("addAttachment", 2) {
                    it.target?.addAttachment(
                        it.getArgument(0) as Plugin,
                        it.getNumber(1).toInt()
                    )
                }
                .function("effectivePermissions", 0) { it.target?.effectivePermissions }

//            registerExtension(PermissibleBase.RemoveAttachmentRunnable::class.java)
//                .function("run", 0) { it.target?.run() }
        }
    }
}
