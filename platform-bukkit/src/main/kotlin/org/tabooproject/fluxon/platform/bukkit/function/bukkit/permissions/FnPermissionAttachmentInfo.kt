package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionAttachmentInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.permissions.PermissionAttachmentInfo"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionAttachmentInfo {

    val TYPE = Type.fromClass(PermissionAttachmentInfo::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionAttachmentInfo::class.java)
                .function("permissible",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissible.TYPE).noParams()) { it.setReturnRef(it.target?.permissible) }
                .function("permission",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.permission) }
                .function("attachment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE).noParams()) { it.setReturnRef(it.target?.attachment) }
                .function("value",returns(Type.Z).noParams()) { it.setReturnRef(it.target?.value) }
        }
    }
}
