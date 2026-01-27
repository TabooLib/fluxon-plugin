package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Location
import org.bukkit.block.Beehive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.Beehive"])
@PlatformSide(Platform.BUKKIT)
object FnBeehive {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beehive::class.java)
                .function("flower", 0) { it.target?.flower }
                .function("setFlower", 1) { it.target?.setFlower(it.getArgument(0) as Location) }
                .function("isSedated", 0) { it.target?.isSedated }
        }
    }
}
