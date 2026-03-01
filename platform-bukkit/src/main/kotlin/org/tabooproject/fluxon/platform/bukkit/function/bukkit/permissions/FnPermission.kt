package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.permissions.Permission"])
@PlatformSide(Platform.BUKKIT)
object FnPermission {

    val TYPE = Type.fromClass(Permission::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Permission::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("default",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE).noParams()) { it.setReturnRef(it.target?.default) }
                .function("setDefault",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE)) { it.target?.setDefault(it.getRef(0) as PermissionDefault) }
                .function("description", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.description) }
                .function("setDescription", returnsVoid().params(Type.STRING)) { it.target?.setDescription(it.getString(0)) }
                .function("permissibles",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.permissibles) }
                .function("recalculatePermissibles", returnsVoid().noParams()) { it.target?.recalculatePermissibles() }
                .function("addParent", returnsVoid().params(Type.STRING, Type.Z)) { it.target?.addParent(it.getString(0)!!, it.getBool(1)) }
                .function("addParent", returnsVoid().params(TYPE, Type.Z)) { it.target?.addParent(it.getRef(0) as Permission, it.getBool(1)) }
                // static
                .function("loadPermissions",returns(Type.LIST).params(Type.MAP, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE)) {
                    it.setReturnRef(Permission.loadPermissions(
                        it.getRef(0) as Map<*, *>,
                        it.getString(1)!!,
                        it.getRef(2) as PermissionDefault
                    ))
                }
                // static
                .function("loadPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.MAP)) {
                    it.setReturnRef(
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<String, Any>
                        )
                    )
                }
                .function("loadPermission",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(Type.STRING, Type.MAP, org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionDefault.TYPE, Type.LIST)) {
                    it.setReturnRef(
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<*, *>,
                            it.getRef(2) as PermissionDefault,
                            it.getRef(3) as List<Permission>
                        )
                    )
                }
        }
    }
}
