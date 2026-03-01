package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.TreeSpecies
import org.bukkit.block.BlockFace
import org.bukkit.material.Door
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Door"])
@PlatformSide(Platform.BUKKIT)
object FnDoor {

    val TYPE = Type.fromClass(Door::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Door::class.java)
                // static
                .function("getWoodDoorOfSpecies",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnTreeSpecies.TYPE)) { it.setReturnRef(Door.getWoodDoorOfSpecies(it.getRef(0) as TreeSpecies)) }
                .function("isOpen", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOpen ?: false) }
                .function("setOpen", returnsVoid().params(Type.Z)) { it.target?.setOpen(it.getBool(0)) }
                .function("isTopHalf", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTopHalf ?: false) }
                .function("setTopHalf", returnsVoid().params(Type.Z)) { it.target?.setTopHalf(it.getBool(0)) }
                .function("hingeCorner",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.hingeCorner) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("setFacingDirection",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.facing) }
                .function("hinge",returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hinge) }
                .function("setHinge", returnsVoid().params(Type.Z)) { it.target?.setHinge(it.getBool(0)) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
