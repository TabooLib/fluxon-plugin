package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.bukkit.util.permissions.DefaultPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDefaultPermissions {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DefaultPermissions::class.java)
                // static
                .function(
                    "registerPermission",
                    1
                ) { DefaultPermissions.registerPermission(it.getArgument(0) as Permission) }
                // static
                .function("registerPermission", 2) {
                    // static Permission registerPermission(@NotNull Permission perm, boolean withLegacy)
                    // static Permission registerPermission(@NotNull Permission perm, @NotNull Permission parent)
                    // static Permission registerPermission(@NotNull String name, @Nullable String desc)
                    TODO()
                }
                // static
                .function("registerPermission", 3) {
                    // static Permission registerPermission(@NotNull String name, @Nullable String desc, @NotNull Permission parent)
                    // static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def)
                    TODO()
                }
                // static
                .function("registerPermission", 4) {
                    // static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def, @NotNull Permission parent)
                    // static Permission registerPermission(@NotNull String name, @Nullable String desc, @Nullable PermissionDefault def, @Nullable Map<String, Boolean> children)
                    TODO()
                }
                // static
                .function("registerPermission", 5) {
                    DefaultPermissions.registerPermission(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getArgument(2) as PermissionDefault,
                        it.getArgument(3) as Map<String, Boolean>,
                        it.getArgument(4) as Permission
                    )
                }
                // static
                .function("registerCorePermissions", 0) { DefaultPermissions.registerCorePermissions() }
        }
    }
}
