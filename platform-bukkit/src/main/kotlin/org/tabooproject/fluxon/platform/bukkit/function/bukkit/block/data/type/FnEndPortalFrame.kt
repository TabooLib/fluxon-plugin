package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.EndPortalFrame
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnEndPortalFrame {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EndPortalFrame::class.java)
                .function("hasEye", 0) { it.target?.hasEye() }
                .function("setEye", 1) { it.target?.setEye(it.getBoolean(0)) }
        }
    }
}
