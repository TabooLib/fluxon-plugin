package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.World
import org.bukkit.block.BlockType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.BlockType"])
@PlatformSide(Platform.BUKKIT)
object FnBlockType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockType::class.java)
                .function("typed", 0) { it.target?.typed() }
                .function("hasItemType", 0) { it.target?.hasItemType() }
                .function("itemType", 0) { it.target?.itemType }
                .function("createBlockData", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.createBlockData()
                    } else {
                        it.target?.createBlockData(it.getString(0))
                    }
                }
                .function("isSolid", 0) { it.target?.isSolid }
                .function("isFlammable", 0) { it.target?.isFlammable }
                .function("isBurnable", 0) { it.target?.isBurnable }
                .function("isOccluding", 0) { it.target?.isOccluding }
                .function("hasGravity", 0) { it.target?.hasGravity() }
                .function("isInteractable", 0) { it.target?.isInteractable }
                .function("hardness", 0) { it.target?.hardness }
                .function("blastResistance", 0) { it.target?.blastResistance }
                .function("slipperiness", 0) { it.target?.slipperiness }
                .function("isAir", 0) { it.target?.isAir }
                .function("isEnabledByFeature", 1) { it.target?.isEnabledByFeature(it.getArgument(0) as World) }
                .function("asMaterial", 0) { it.target?.asMaterial() }
                .function("blockDataClass", 0) { it.target?.blockDataClass }
        }
    }
}

@Requires(classes = ["org.bukkit.block.BlockType.Typed"])
@PlatformSide(Platform.BUKKIT)
object FnBlockTypeTyped {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockType.Typed::class.java)
                .function("blockDataClass", 0) { it.target?.blockDataClass }
                .function("createBlockData", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.createBlockData()
                    } else {
                        (it.target as? BlockType.Typed<*>)?.createBlockData(it.getString(0))
                    }
                }
        }
    }
}
