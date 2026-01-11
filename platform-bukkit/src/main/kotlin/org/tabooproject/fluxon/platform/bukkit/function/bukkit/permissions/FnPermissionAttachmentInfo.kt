package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionAttachmentInfo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPermissionAttachmentInfo {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionAttachmentInfo::class.java)
                .function("permissible", 0) { it.target?.permissible }
                .function("permission", 0) { it.target?.permission }
                .function("attachment", 0) { it.target?.attachment }
                .function("value", 0) { it.target?.value }
        }
    }
}
