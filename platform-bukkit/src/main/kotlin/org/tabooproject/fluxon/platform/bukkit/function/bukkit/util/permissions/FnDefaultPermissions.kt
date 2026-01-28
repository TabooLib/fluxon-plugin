package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.bukkit.util.permissions.DefaultPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.util.permissions.DefaultPermissions"])
@PlatformSide(Platform.BUKKIT)
object FnDefaultPermissions {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DefaultPermissions::class.java)
                // 1 参数: Permission
                .function("registerPermission", returnsObject().params(Type.OBJECT)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getRef(0) as Permission)) }
                // 2 参数: Permission + Boolean
                .function("registerPermission", returnsObject().params(Type.OBJECT, Type.Z)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getRef(0) as Permission, it.getBool(1))) }
                // 2 参数: Permission + Permission
                .function("registerPermission", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    val var1 = it.getRef(0)
                    val var2 = it.getRef(1)
                    it.setReturnRef(when {
                        var1 is Permission && var2 is Permission -> DefaultPermissions.registerPermission(var1, var2)
                        var1 is Permission && var2 is Boolean -> DefaultPermissions.registerPermission(var1, var2)
                        else -> throw IllegalArgumentException("参数类型错误")
                    })
                }
                // 2 参数: String + String
                .function("registerPermission", returnsObject().params(Type.STRING, Type.STRING)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1))) }
                // 3 参数: String + String + Permission/PermissionDefault
                .function("registerPermission", returnsObject().params(Type.STRING, Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(when (val var3 = it.getRef(2)) {
                        is Permission -> DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1), var3)
                        is PermissionDefault -> DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1), var3)
                        else -> throw IllegalArgumentException("第三个参数必须是 Permission 或 PermissionDefault 类型")
                    })
                }
                // 4 参数: String + String + PermissionDefault + Permission/Map
                .function("registerPermission", returnsObject().params(Type.STRING, Type.STRING, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var4 = it.getRef(3)) {
                        is Permission -> DefaultPermissions.registerPermission(
                            it.getString(0)!!,
                            it.getString(1),
                            it.getRef(2) as PermissionDefault,
                            var4
                        )
                        is Map<*, *> -> DefaultPermissions.registerPermission(
                            it.getString(0)!!,
                            it.getString(1),
                            it.getRef(2) as PermissionDefault,
                            @Suppress("UNCHECKED_CAST")
                            var4 as Map<String, Boolean>
                        )
                        else -> throw IllegalArgumentException("第四个参数必须是 Permission 或 Map<String, Boolean> 类型")
                    })
                }
                // 5 参数: String + String + PermissionDefault + Map + Permission
                .function("registerPermission", returnsObject().params(Type.STRING, Type.STRING, Type.OBJECT, Type.MAP, Type.OBJECT)) {
                    it.setReturnRef(DefaultPermissions.registerPermission(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as PermissionDefault,
                        @Suppress("UNCHECKED_CAST")
                        (it.getRef(3) as Map<String, Boolean>),
                        it.getRef(4) as Permission
                    ))
                }
                // static
                .function("registerCorePermissions", returnsVoid().noParams()) { DefaultPermissions.registerCorePermissions() }
        }
    }
}
