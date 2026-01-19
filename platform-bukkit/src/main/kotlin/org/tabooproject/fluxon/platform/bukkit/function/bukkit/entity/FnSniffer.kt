package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Sniffer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSniffer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sniffer::class.java)
                .function("exploredLocations", 0) { it.target?.exploredLocations }
                .function(
                    "removeExploredLocation",
                    1
                ) { it.target?.removeExploredLocation(it.getArgument(0) as Location) }
                .function("addExploredLocation", 1) { it.target?.addExploredLocation(it.getArgument(0) as Location) }
                .function("state", 0) { it.target?.state }
                .function("setState", 1) { it.target?.setState(it.getArgument(0) as Sniffer.State) }
                .function("findPossibleDigLocation", 0) { it.target?.findPossibleDigLocation() }
                .function("canDig", 0) { it.target?.canDig() }
        }
    }
}
