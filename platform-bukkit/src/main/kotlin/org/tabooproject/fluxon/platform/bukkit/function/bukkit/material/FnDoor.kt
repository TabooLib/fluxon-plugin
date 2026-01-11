package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.TreeSpecies
import org.bukkit.block.BlockFace
import org.bukkit.material.Door
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnDoor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Door::class.java)
                // static
                .function("woodDoorOfSpecies", 1) { Door.getWoodDoorOfSpecies(it.getArgument(0) as TreeSpecies) }
                .function("isOpen", 0) { it.target?.isOpen }
                .function("setOpen", 1) { it.target?.setOpen(it.getBoolean(0)) }
                .function("isTopHalf", 0) { it.target?.isTopHalf }
                .function("setTopHalf", 1) { it.target?.setTopHalf(it.getBoolean(0)) }
                .function("hingeCorner", 0) { it.target?.hingeCorner }
                .function("toString", 0) { it.target?.toString() }
                .function("setFacingDirection", 1) { it.target?.setFacingDirection(it.getArgument(0) as BlockFace) }
                .function("facing", 0) { it.target?.facing }
                .function("hinge", 0) { it.target?.hinge }
                .function("setHinge", 1) { it.target?.setHinge(it.getBoolean(0)) }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
