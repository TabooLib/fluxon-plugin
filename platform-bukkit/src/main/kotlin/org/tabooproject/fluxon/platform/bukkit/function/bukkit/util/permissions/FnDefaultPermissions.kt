package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.bukkit.util.permissions.DefaultPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDefaultPermissions {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DefaultPermissions::class.java)
                // static
                .function("registerPermission", listOf(1, 2, 3, 4, 5)) {
                    when (it.arguments.size) {
                        1 -> DefaultPermissions.registerPermission(it.getArgument(0) as Permission)
                        2 -> when (val var1 = it.getArgument(0)) {
                            is Permission -> when (val var2 = it.getArgument(1)) {
                                is Boolean -> DefaultPermissions.registerPermission(var1, var2)
                                is Permission -> DefaultPermissions.registerPermission(var1, var2)
                                else -> throw IllegalArgumentException("第二个参数必须是 Boolean 或 Permission 类型")
                            }

                            is String -> DefaultPermissions.registerPermission(var1, it.getString(1))
                            else -> throw IllegalArgumentException("第一个参数必须是 Permission 或 String 类型")
                        }

                        3 -> when (val var3 = it.getArgument(2)) {
                            is Permission -> DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1), var3)
                            is PermissionDefault -> DefaultPermissions.registerPermission(
                                it.getString(0)!!,
                                it.getString(1),
                                var3
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Permission 或 PermissionDefault 类型")
                        }

                        4 -> when (val var4 = it.getArgument(3)) {
                            is Permission -> DefaultPermissions.registerPermission(
                                it.getString(0)!!,
                                it.getString(1),
                                it.getArgument(2) as PermissionDefault,
                                var4
                            )

                            is Map<*, *> -> DefaultPermissions.registerPermission(
                                it.getString(0)!!,
                                it.getString(1),
                                it.getArgument(2) as PermissionDefault,
                                var4 as Map<String, Boolean>
                            )

                            else -> throw IllegalArgumentException("第四个参数必须是 Permission 或 Map<String, Boolean> 类型")
                        }

                        5 -> DefaultPermissions.registerPermission(
                            it.getString(0)!!,
                            it.getString(1),
                            it.getArgument(2) as PermissionDefault,
                            it.getArgument(3) as Map<String, Boolean>,
                            it.getArgument(4) as Permission
                        )
                        else -> error("DefaultPermissions#registerPermission 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                // static
                .function("registerCorePermissions", 0) { DefaultPermissions.registerCorePermissions() }
        }
    }
}
