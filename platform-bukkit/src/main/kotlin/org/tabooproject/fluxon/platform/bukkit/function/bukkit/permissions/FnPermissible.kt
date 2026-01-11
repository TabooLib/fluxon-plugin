package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permissible
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPermissible {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Permissible::class.java)
                .function("isPermissionSet", 1) {
                    // boolean isPermissionSet(@NotNull String var1)
                    // boolean isPermissionSet(@NotNull Permission var1)
                    TODO()
                }
                .function("hasPermission", 1) {
                    // boolean hasPermission(@NotNull String var1)
                    // boolean hasPermission(@NotNull Permission var1)
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
                .function(
                    "removeAttachment",
                    1
                ) { it.target?.removeAttachment(it.getArgument(0) as PermissionAttachment) }
                .function("recalculatePermissions", 0) { it.target?.recalculatePermissions() }
                .function("effectivePermissions", 0) { it.target?.effectivePermissions }
        }
    }
}
