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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
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
                .function("default", returnsObject().noParams()) { it.setReturnRef(it.target?.default) }
                .function("setDefault", returnsVoid().params(Type.OBJECT)) { it.target?.setDefault(it.getRef(0) as PermissionDefault) }
                .function("description", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.description) }
                .function("setDescription", returnsVoid().params(Type.STRING)) { it.target?.setDescription(it.getString(0)) }
                .function("permissibles", returnsObject().noParams()) { it.setReturnRef(it.target?.permissibles) }
                .function("recalculatePermissibles", returnsVoid().noParams()) { it.target?.recalculatePermissibles() }
                .function("addParent", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    when (val var1 = it.getRef(0)) {
                        is String -> it.target?.addParent(var1, it.getBool(1))
                        is Permission -> it.target?.addParent(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    }
                }
                // static
                .function("loadPermissions", returnsObject().params(Type.OBJECT, Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(Permission.loadPermissions(
                        it.getRef(0) as Map<*, *>,
                        it.getString(1)!!,
                        it.getRef(2) as PermissionDefault
                    ))
                }
                // static
                .function("loadPermission", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(
                        Permission.loadPermission(
                            it.getString(0)!!,
                            it.getRef(1) as Map<String, Any>
                        )
                    )
                }
                .function("loadPermission", returnsObject().params(Type.STRING, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
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
