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

@Requires(classes = ["org.bukkit.permissions.PermissionAttachmentInfo"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionAttachmentInfo {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionAttachmentInfo::class.java)
                .function("permissible", returnsObject().noParams()) { it.target?.permissible }
                .function("permission", returnsObject().noParams()) { it.target?.permission }
                .function("attachment", returnsObject().noParams()) { it.target?.attachment }
                .function("value", returnsObject().noParams()) { it.target?.value }
        }
    }
}
