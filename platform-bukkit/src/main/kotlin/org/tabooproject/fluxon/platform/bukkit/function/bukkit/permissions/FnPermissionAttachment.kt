package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permission
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
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.setPermission(var1, it.getBoolean(1))
                        is Permission -> it.target?.setPermission(var1, it.getBoolean(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                .function("unsetPermission", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.unsetPermission(var1)
                        is Permission -> it.target?.unsetPermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                .function("remove", 0) { it.target?.remove() }
        }
    }
}
