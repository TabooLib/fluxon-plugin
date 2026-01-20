package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.TripwireHook
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTripwireHook {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TripwireHook::class.java)
                .function("isConnected", 0) { it.target?.isConnected }
                .function("setConnected", 1) { it.target?.setConnected(it.getBoolean(0)) }
                .function("isActivated", 0) { it.target?.isActivated }
                .function("setActivated", 1) { it.target?.setActivated(it.getBoolean(0)) }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("attachedFace", 0) { it.target?.attachedFace }
                .function("isPowered", 0) { it.target?.isPowered }
                .function("clone", 0) { it.target?.clone() }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
