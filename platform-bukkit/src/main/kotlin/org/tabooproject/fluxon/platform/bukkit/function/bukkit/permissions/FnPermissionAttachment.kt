package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionRemovedExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPermissionAttachment {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionAttachment::class.java)
                .function("plugin", 0) { it.target?.plugin }
                .function(
                    "setRemovalCallback",
                    1
                ) { it.target?.setRemovalCallback(it.getArgument(0) as PermissionRemovedExecutor) }
                .function("removalCallback", 0) { it.target?.removalCallback }
                .function("permissible", 0) { it.target?.permissible }
                .function("setPermission", 2) {
                    // void setPermission(@NotNull String name, boolean value)
                    // void setPermission(@NotNull Permission perm, boolean value)
                    TODO()
                }
                .function("unsetPermission", 1) {
                    // void unsetPermission(@NotNull String name)
                    // void unsetPermission(@NotNull Permission perm)
                    TODO()
                }
                .function("remove", 0) { it.target?.remove() }
        }
    }
}
