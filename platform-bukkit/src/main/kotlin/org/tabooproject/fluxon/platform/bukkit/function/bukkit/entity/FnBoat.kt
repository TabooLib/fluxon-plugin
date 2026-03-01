package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.TreeSpecies
import org.bukkit.entity.Boat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Boat"])
@PlatformSide(Platform.BUKKIT)
object FnBoat {

    val TYPE = Type.fromClass(Boat::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Boat::class.java)
                .function("woodType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeSpecies.TYPE).noParams()) { it.setReturnRef(it.target?.woodType) }
                .function("setWoodType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeSpecies.TYPE)) { it.target?.setWoodType(it.getRef(0) as TreeSpecies) }
                .function("boatType",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnBoatType.TYPE).noParams()) { it.setReturnRef(it.target?.boatType) }
                .function("setBoatType",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnBoatType.TYPE)) { it.target?.setBoatType(it.getRef(0) as Boat.Type) }
                .function("maxSpeed", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxSpeed ?: 0.0) }
                .function("setMaxSpeed", returnsVoid().params(Type.D)) { it.target?.setMaxSpeed(it.getDouble(0)) }
                .function("occupiedDeceleration", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.occupiedDeceleration ?: 0.0) }
                .function("setOccupiedDeceleration", returnsVoid().params(Type.D)) {
                    it.target?.setOccupiedDeceleration(it.getDouble(0))
                }
                .function("unoccupiedDeceleration", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.unoccupiedDeceleration ?: 0.0) }
                .function("setUnoccupiedDeceleration", returnsVoid().params(Type.D)) {
                    it.target?.setUnoccupiedDeceleration(it.getDouble(0))
                }
                .function("workOnLand", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.workOnLand ?: false) }
                .function("setWorkOnLand", returnsVoid().params(Type.Z)) { it.target?.setWorkOnLand(it.getBool(0)) }
                .function("status", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnBoatStatus.TYPE).noParams()) { it.setReturnRef(it.target?.status) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Boat\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnBoatType : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.entity.Boat.Type>() {

    override val enumClass: Class<org.bukkit.entity.Boat.Type> = org.bukkit.entity.Boat.Type::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Boat.Type::class.java)
                .function("material", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.material) }
        }
    }
}
