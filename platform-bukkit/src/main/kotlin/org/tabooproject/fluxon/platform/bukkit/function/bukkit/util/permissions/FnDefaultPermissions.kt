package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.bukkit.util.permissions.DefaultPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.permissions.DefaultPermissions"])
@PlatformSide(Platform.BUKKIT)
object FnDefaultPermissions {

    val TYPE = Type.fromClass(DefaultPermissions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DefaultPermissions::class.java)
                // 1 参数: Permission
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getRef(0) as Permission)) }
                // 2 参数: Permission + Boolean
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE, Type.Z)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getRef(0) as Permission, it.getBool(1))) }
                // 2 参数: Permission + Permission
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getRef(0) as Permission, it.getRef(1) as Permission)) }
                // 2 参数: String + String
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.STRING)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1))) }
                // 3 参数: String + String + Permission/PermissionDefault
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1), it.getRef(2) as Permission)) }
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1), it.getRef(2) as PermissionDefault)) }
                // 4 参数: String + String + PermissionDefault + Permission/Map
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnRef(DefaultPermissions.registerPermission(it.getString(0)!!, it.getString(1), it.getRef(2) as PermissionDefault, it.getRef(3) as Permission)) }
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE, Type.MAP)) {
                    it.setReturnRef(DefaultPermissions.registerPermission(
                        it.getString(0)!!,
                        it.getString(1),
                        it.getRef(2) as PermissionDefault,
                        @Suppress("UNCHECKED_CAST")
                        it.getRef(3) as Map<String, Boolean>
                    ))
                }
                // 5 参数: String + String + PermissionDefault + Map + Permission
                .function("registerPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE, Type.MAP, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) {
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
