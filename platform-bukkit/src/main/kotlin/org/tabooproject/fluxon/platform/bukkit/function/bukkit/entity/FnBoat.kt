package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.TreeSpecies
import org.bukkit.entity.Boat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBoat {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Boat::class.java)
                .function("woodType", 0) { it.target?.woodType }
                .function("setWoodType", 1) { it.target?.setWoodType(it.getArgument(0) as TreeSpecies) }
                .function("boatType", 0) { it.target?.boatType }
                .function("setBoatType", 1) { it.target?.setBoatType(it.getArgument(0) as Boat.Type) }
                .function("maxSpeed", 0) { it.target?.maxSpeed }
                .function("setMaxSpeed", 1) { it.target?.setMaxSpeed(it.getNumber(0).toDouble()) }
                .function("occupiedDeceleration", 0) { it.target?.occupiedDeceleration }
                .function("setOccupiedDeceleration", 1) {
                    it.target?.setOccupiedDeceleration(
                        it.getNumber(0).toDouble()
                    )
                }
                .function("unoccupiedDeceleration", 0) { it.target?.unoccupiedDeceleration }
                .function("setUnoccupiedDeceleration", 1) {
                    it.target?.setUnoccupiedDeceleration(
                        it.getNumber(0).toDouble()
                    )
                }
                .function("workOnLand", 0) { it.target?.workOnLand }
                .function("setWorkOnLand", 1) { it.target?.setWorkOnLand(it.getBoolean(0)) }
                .function("status", 0) { it.target?.status }

            registerExtension(Boat.Type::class.java)
                .function("material", 0) { it.target?.material }
        }
    }
}
