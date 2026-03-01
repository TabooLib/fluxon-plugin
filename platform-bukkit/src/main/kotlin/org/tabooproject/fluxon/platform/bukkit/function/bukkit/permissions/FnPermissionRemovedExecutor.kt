package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionRemovedExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.permissions.PermissionRemovedExecutor"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionRemovedExecutor {

    val TYPE = Type.fromClass(PermissionRemovedExecutor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionRemovedExecutor::class.java)
                .function("attachmentRemoved", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermissionAttachment.TYPE)) { it.target?.attachmentRemoved(it.getRef(0) as PermissionAttachment) }
        }
    }
}
