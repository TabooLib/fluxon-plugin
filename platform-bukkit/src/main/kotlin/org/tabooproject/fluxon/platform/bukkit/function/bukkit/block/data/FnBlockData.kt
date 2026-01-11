package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.BlockSupport
import org.bukkit.block.data.BlockData
import org.bukkit.block.structure.Mirror
import org.bukkit.block.structure.StructureRotation
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBlockData {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockData::class.java)
                .function("material", 0) { it.target?.material }
                .function("asString", 0) { it.target?.asString }
                .function("asString", 1) { it.target?.getAsString(it.getBoolean(0)) }
                .function("merge", 1) { it.target?.merge(it.getArgument(0) as BlockData) }
                .function("matches", 1) { it.target?.matches(it.getArgument(0) as BlockData) }
                .function("clone", 0) { it.target?.clone() }
                .function("soundGroup", 0) { it.target?.soundGroup }
                .function("lightEmission", 0) { it.target?.lightEmission }
                .function("isOccluding", 0) { it.target?.isOccluding }
                .function("requiresCorrectToolForDrops", 0) { it.target?.requiresCorrectToolForDrops() }
                .function("isPreferredTool", 1) { it.target?.isPreferredTool(it.getArgument(0) as ItemStack) }
                .function("pistonMoveReaction", 0) { it.target?.pistonMoveReaction }
                .function("isSupported", 1) {
                    // boolean isSupported(@NotNull Block var1)
                    // boolean isSupported(@NotNull Location var1)
                    TODO()
                }
                .function("isFaceSturdy", 2) {
                    it.target?.isFaceSturdy(
                        it.getArgument(0) as BlockFace,
                        it.getArgument(1) as BlockSupport
                    )
                }
                .function("mapColor", 0) { it.target?.mapColor }
                .function("placementMaterial", 0) { it.target?.placementMaterial }
                .function("rotate", 1) { it.target?.rotate(it.getArgument(0) as StructureRotation) }
                .function("mirror", 1) { it.target?.mirror(it.getArgument(0) as Mirror) }
                .function("copyTo", 1) { it.target?.copyTo(it.getArgument(0) as BlockData) }
        }
    }
}
