package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.TreeSpecies
import org.bukkit.entity.Boat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Boat"])
@PlatformSide(Platform.BUKKIT)
object FnBoat {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Boat::class.java)
                .function("woodType", returnsObject().noParams()) { it.target?.woodType }
                .function("setWoodType", returnsObject().params(Type.OBJECT)) { it.target?.setWoodType(it.getRef(0) as TreeSpecies) }
                .function("boatType", returnsObject().noParams()) { it.target?.boatType }
                .function("setBoatType", returnsObject().params(Type.OBJECT)) { it.target?.setBoatType(it.getRef(0) as Boat.Type) }
                .function("maxSpeed", returnsObject().noParams()) { it.target?.maxSpeed }
                .function("setMaxSpeed", returnsObject().params(Type.OBJECT)) { it.target?.setMaxSpeed(it.getAsDouble(0)) }
                .function("occupiedDeceleration", returnsObject().noParams()) { it.target?.occupiedDeceleration }
                .function("setOccupiedDeceleration", returnsObject().params(Type.OBJECT)) {
                    it.target?.setOccupiedDeceleration(
                        it.getAsDouble(0)
                    )
                }
                .function("unoccupiedDeceleration", returnsObject().noParams()) { it.target?.unoccupiedDeceleration }
                .function("setUnoccupiedDeceleration", returnsObject().params(Type.OBJECT)) {
                    it.target?.setUnoccupiedDeceleration(
                        it.getAsDouble(0)
                    )
                }
                .function("workOnLand", returnsObject().noParams()) { it.target?.workOnLand }
                .function("setWorkOnLand", returnsObject().params(Type.OBJECT)) { it.target?.setWorkOnLand(it.getBool(0)) }
                .function("status", returnsObject().noParams()) { it.target?.status }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Boat.Type"])
@PlatformSide(Platform.BUKKIT)
object FnBoatType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Boat.Type::class.java)
                .function("material", returnsObject().noParams()) { it.target?.material }
        }
    }
}
