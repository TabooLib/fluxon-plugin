package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionAttachment
import org.bukkit.permissions.PermissionRemovedExecutor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.permissions.PermissionRemovedExecutor"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionRemovedExecutor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionRemovedExecutor::class.java)
                .function(
                    "attachmentRemoved",
                    1
                ) { it.target?.attachmentRemoved(it.getArgument(0) as PermissionAttachment) }
        }
    }
}
