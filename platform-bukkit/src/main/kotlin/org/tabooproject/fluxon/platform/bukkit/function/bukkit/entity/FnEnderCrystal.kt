package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.EnderCrystal
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEnderCrystal {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderCrystal::class.java)
                .function("isShowingBottom", 0) { it.target?.isShowingBottom }
                .function("setShowingBottom", 1) { it.target?.setShowingBottom(it.getBoolean(0)) }
                .function("beamTarget", 0) { it.target?.beamTarget }
                .function("setBeamTarget", 1) { it.target?.setBeamTarget(it.getArgument(0) as Location) }
        }
    }
}
