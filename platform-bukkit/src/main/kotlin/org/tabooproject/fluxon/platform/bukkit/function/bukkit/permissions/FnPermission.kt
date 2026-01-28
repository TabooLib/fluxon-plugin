package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionDefault
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.permissions.Permission"])
@PlatformSide(Platform.BUKKIT)
object FnPermission {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Permission::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("default", returnsObject().noParams()) { it.setReturnRef(it.target?.default) }
                .function("setDefault", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDefault(it.getRef(0) as PermissionDefault)) }
                .function("description", returnsObject().noParams()) { it.setReturnRef(it.target?.description) }
                .function("setDescription", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDescription(it.getString(0))) }
                .function("permissibles", returnsObject().noParams()) { it.setReturnRef(it.target?.permissibles) }
                .function("recalculatePermissibles", returnsObject().noParams()) { it.setReturnRef(it.target?.recalculatePermissibles()) }
                .function("addParent", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.addParent(var1, it.getBool(1))
                        is Permission -> it.target?.addParent(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    })
                }
                // static
                .function("loadPermissions", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(Permission.loadPermissions(
                        it.getRef(0) as Map<*, *>,
                        it.getString(1)!!,
                        it.getRef(2) as PermissionDefault
                    ))
                }
                // static
                .function("loadPermission", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<String, Any>
                        )
                    } else {
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<*, *>,
                            it.getRef(2) as PermissionDefault,
                            it.getRef(3) as List<Permission>
                        )
                    })
                }
                .function("loadPermission", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<String, Any>
                        )
                    } else {
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<*, *>,
                            it.getRef(2) as PermissionDefault,
                            it.getRef(3) as List<Permission>
                        )
                    })
                }
        }
    }
}
