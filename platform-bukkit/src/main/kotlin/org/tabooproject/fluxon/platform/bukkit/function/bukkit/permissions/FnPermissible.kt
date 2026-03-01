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
                .function("isPermissionSet", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isPermissionSet(it.getString(0)!!) ?: false) }
                .function("isPermissionSet", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnBool(it.target?.isPermissionSet(it.getRef(0) as Permission) ?: false) }
                .function("hasPermission", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.hasPermission(it.getString(0)!!) ?: false) }
                .function("hasPermission", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnBool(it.target?.hasPermission(it.getRef(0) as Permission) ?: false) }
                .function("addAttachment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) {
                    it.setReturnRef(it.target?.addAttachment(it.getRef(0) as Plugin))
                }
                .function("addAttachment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.I)) {
                    it.setReturnRef(it.target?.addAttachment(
                        it.getRef(0) as Plugin,
                        it.getInt(1).toInt()
                    ))
                }
                .function("addAttachment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING, Type.Z)) {
                    it.setReturnRef(it.target?.addAttachment(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getBool(2)
                    ))
                }
                .function("addAttachment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, Type.STRING, Type.Z, Type.I)) {
                    it.setReturnRef(it.target?.addAttachment(
                        it.getRef(0) as Plugin,
                        it.getString(1)!!,
                        it.getBool(2),
                        it.getInt(3).toInt()
                    ))
                }
                .function("removeAttachment",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE)) {
                    it.target?.removeAttachment(it.getRef(0) as PermissionAttachment)
                }
                .function("recalculatePermissions", returnsVoid().noParams()) { it.target?.recalculatePermissions() }
                .function("effectivePermissions", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.effectivePermissions) }
        }
    }
}
