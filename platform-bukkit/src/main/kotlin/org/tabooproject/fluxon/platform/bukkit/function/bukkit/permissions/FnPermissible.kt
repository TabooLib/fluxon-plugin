package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permissible
import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.permissions.Permissible"])
@PlatformSide(Platform.BUKKIT)
object FnPermissible {

    val TYPE = Type.fromClass(Permissible::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Permissible::class.java)
                .function("isPermissionSet", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.isPermissionSet(var1)
                        is Permission -> it.target?.isPermissionSet(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    } ?: false)
                }
                .function("hasPermission", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is String -> it.target?.hasPermission(var1)
                        is Permission -> it.target?.hasPermission(var1)
                        else -> throw IllegalArgumentException("参数必须是 String 或 Permission 类型")
                    } ?: false)
                }
                .function("addAttachment", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.addAttachment(it.getRef(0) as Plugin))
                }
                .function("addAttachment", returnsObject().params(Type.OBJECT, Type.I)) {
                    it.setReturnRef(it.target?.addAttachment(
                        it.getRef(0) as Plugin,
                        it.getInt(1).toInt()
                    ))
                }
                .function("addAttachment", returnsObject().params(Type.OBJECT, Type.STRING, Type.Z)) {
                    it.setReturnRef(it.target?.addAttachment(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getBool(2)
                    ))
                }
                .function("addAttachment", returnsObject().params(Type.OBJECT, Type.STRING, Type.Z, Type.I)) {
                    it.setReturnRef(it.target?.addAttachment(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getBool(2),
                        it.getInt(3).toInt()
                    ))
                }
                .function("removeAttachment", returnsVoid().params(Type.OBJECT)) {
                    it.target?.removeAttachment(it.getRef(0) as PermissionAttachment)
                }
                .function("recalculatePermissions", returnsVoid().noParams()) { it.target?.recalculatePermissions() }
                .function("effectivePermissions", returnsObject().noParams()) { it.setReturnRef(it.target?.effectivePermissions) }
        }
    }
}
