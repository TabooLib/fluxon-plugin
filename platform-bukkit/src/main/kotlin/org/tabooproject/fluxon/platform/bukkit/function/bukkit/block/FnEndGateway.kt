package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Location
import org.bukkit.block.EndGateway
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.EndGateway"])
@PlatformSide(Platform.BUKKIT)
object FnEndGateway {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EndGateway::class.java)
                .function("exitLocation", 0) { it.target?.exitLocation }
                .function("setExitLocation", 1) { it.target?.setExitLocation(it.getArgument(0) as Location) }
                .function("isExactTeleport", 0) { it.target?.isExactTeleport }
                .function("setExactTeleport", 1) { it.target?.setExactTeleport(it.getBoolean(0)) }
                .function("age", 0) { it.target?.age }
                .function("setAge", 1) { it.target?.setAge(it.getNumber(0).toLong()) }
        }
    }
}
