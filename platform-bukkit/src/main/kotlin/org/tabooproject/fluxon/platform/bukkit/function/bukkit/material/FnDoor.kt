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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Door"])
@PlatformSide(Platform.BUKKIT)
object FnDoor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Door::class.java)
                // static
                .function("getWoodDoorOfSpecies", returnsObject().params(Type.OBJECT)) { Door.getWoodDoorOfSpecies(it.getRef(0) as TreeSpecies) }
                .function("isOpen", returns(Type.Z).noParams()) { it.target?.isOpen }
                .function("setOpen", returnsObject().params(Type.OBJECT)) { it.target?.setOpen(it.getBool(0)) }
                .function("isTopHalf", returns(Type.Z).noParams()) { it.target?.isTopHalf }
                .function("setTopHalf", returnsObject().params(Type.OBJECT)) { it.target?.setTopHalf(it.getBool(0)) }
                .function("hingeCorner", returnsObject().noParams()) { it.target?.hingeCorner }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("setFacingDirection", returnsObject().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing", returnsObject().noParams()) { it.target?.facing }
                .function("hinge", returnsObject().noParams()) { it.target?.hinge }
                .function("setHinge", returnsObject().params(Type.OBJECT)) { it.target?.setHinge(it.getBool(0)) }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
