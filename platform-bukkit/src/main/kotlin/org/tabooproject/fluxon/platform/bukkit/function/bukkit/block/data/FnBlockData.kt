package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.BlockData
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockData {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockData::class.java)
                .function("isOccluding", 0) { it.target?.isOccluding }
//                .function("isRandomlyTicked", 0) { it.target?.isRandomlyTicked }
                .function("asString", 0) { it.target?.asString }
                .function("soundGroup", 0) { it.target?.soundGroup }
                .function("lightEmission", 0) { it.target?.lightEmission }
                .function("requiresCorrectToolForDrops", 0) { it.target?.requiresCorrectToolForDrops() }
                .function("pistonMoveReaction", 0) { it.target?.pistonMoveReaction }
                .function("placementMaterial", 0) { it.target?.placementMaterial }
        }
    }
}
