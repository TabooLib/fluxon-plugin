package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.PoweredMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPoweredMinecart {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PoweredMinecart::class.java)
                .function("fuel", 0) { it.target?.fuel }
                .function("setFuel", 1) { it.target?.setFuel(it.getNumber(0).toInt()) }
        }
    }
}
