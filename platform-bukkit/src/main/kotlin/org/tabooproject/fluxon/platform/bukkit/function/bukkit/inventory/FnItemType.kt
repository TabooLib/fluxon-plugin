package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.World
import org.bukkit.inventory.ItemType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnItemType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemType::class.java)
                .function("typed", 0) { it.target?.typed() }
                .function("createItemStack", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.createItemStack()
                    } else {
                        it.target?.createItemStack(it.getNumber(0).toInt())
                    }
                }
                .function("hasBlockType", 0) { it.target?.hasBlockType() }
                .function("blockType", 0) { it.target?.blockType }
                .function("maxStackSize", 0) { it.target?.maxStackSize }
                .function("maxDurability", 0) { it.target?.maxDurability }
                .function("isEdible", 0) { it.target?.isEdible }
                .function("isRecord", 0) { it.target?.isRecord }
                .function("isFuel", 0) { it.target?.isFuel }
                .function("isCompostable", 0) { it.target?.isCompostable }
                .function("compostChance", 0) { it.target?.compostChance }
                .function("craftingRemainingItem", 0) { it.target?.craftingRemainingItem }
                .function("creativeCategory", 0) { it.target?.creativeCategory }
                .function("isEnabledByFeature", 1) { it.target?.isEnabledByFeature(it.getArgument(0) as World) }
                .function("asMaterial", 0) { it.target?.asMaterial() }
                .function("itemMetaClass", 0) { it.target?.itemMetaClass }
        }
    }
}
