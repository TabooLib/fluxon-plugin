package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.Permission
import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionRemovedExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.permissions.PermissionAttachment"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionAttachment {

    val TYPE = Type.fromClass(PermissionAttachment::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionAttachment::class.java)
                .function("plugin",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).noParams()) { it.setReturnRef(it.target?.plugin) }
                .function("setRemovalCallback",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionRemovedExecutor.TYPE)) { it.target?.setRemovalCallback(it.getRef(0) as PermissionRemovedExecutor) }
                .function("removalCallback",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionRemovedExecutor.TYPE).noParams()) { it.setReturnRef(it.target?.removalCallback) }
                .function("permissible",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissible.TYPE).noParams()) { it.setReturnRef(it.target?.permissible) }
                .function("setPermission", returnsVoid().params(Type.STRING, Type.Z)) { it.target?.setPermission(it.getString(0)!!, it.getBool(1)) }
                .function("setPermission", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE, Type.Z)) {
                    it.target?.setPermission(it.getRef(0) as Permission, it.getBool(1))
                }
                .function("unsetPermission", returnsVoid().params(Type.STRING)) { it.target?.unsetPermission(it.getString(0)!!) }
                .function("unsetPermission", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.target?.unsetPermission(it.getRef(0) as Permission) }
                .function("remove", returnsVoid().noParams()) { it.target?.remove() }
        }
    }
}
