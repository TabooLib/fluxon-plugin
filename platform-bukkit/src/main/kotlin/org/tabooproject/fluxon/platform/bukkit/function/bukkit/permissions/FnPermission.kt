package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPermission {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Permission::class.java)
                .function("name", 0) { it.target?.name }
                .function("default", 0) { it.target?.default }
                .function("setDefault", 1) { it.target?.setDefault(it.getArgument(0) as PermissionDefault) }
                .function("description", 0) { it.target?.description }
                .function("setDescription", 1) { it.target?.setDescription(it.getString(0)) }
                .function("permissibles", 0) { it.target?.permissibles }
                .function("recalculatePermissibles", 0) { it.target?.recalculatePermissibles() }
                .function("addParent", 2) {
                    when (val var1 = it.getArgument(0)) {
                        is String -> it.target?.addParent(var1, it.getBoolean(1))
                        is Permission -> it.target?.addParent(var1, it.getBoolean(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                // static
                .function("loadPermissions", 3) {
                    Permission.loadPermissions(
                        it.getArgument(0) as Map<*, *>,
                        it.getString(1)!!,
                        it.getArgument(2) as PermissionDefault
                    )
                }
                // static
                .function("loadPermission", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getArgument(1) as Map<String, Any>
                        )
                    } else {
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getArgument(1) as Map<*, *>,
                            it.getArgument(2) as PermissionDefault,
                            it.getArgument(3) as List<Permission>
                        )
                    }
                }
        }
    }
}
