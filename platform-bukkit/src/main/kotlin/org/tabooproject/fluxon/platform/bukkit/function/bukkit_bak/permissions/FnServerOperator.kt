package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permissible

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPermissible {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Permissible::class.java)
                .function("isPermissionSet", 1) {
                    //  public boolean isPermissionSet(@NotNull String var1)
                    //  public boolean isPermissionSet(@NotNull Permission var1)
                    TODO()
                }
                .function("hasPermission", 1) {
                    //  public boolean hasPermission(@NotNull String var1)
                    //  public boolean hasPermission(@NotNull Permission var1)
                    TODO()
                }
                .function("addAttachment", 3) { TODO() }
                .function("addAttachment", 1) { TODO() }
                .function("addAttachment", 4) { TODO() }
                .function("addAttachment", 2) { TODO() }
                .function("removeAttachment", 1) { TODO() }
                .function("recalculatePermissions", 0) { it.target?.recalculatePermissions() }
                .function("effectivePermissions", 0) { it.target?.effectivePermissions }
        }
    }
}
