package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.HopperMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.minecart.HopperMinecart"])
@PlatformSide(Platform.BUKKIT)
object FnHopperMinecart {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HopperMinecart::class.java)
                .function("isEnabled", 0) { it.target?.isEnabled }
                .function("setEnabled", 1) { it.target?.setEnabled(it.getBoolean(0)) }
        }
    }
}
