package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.World
import org.bukkit.inventory.ItemType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.ItemType"])
@PlatformSide(Platform.BUKKIT)
object FnItemType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemType::class.java)
                .function("typed", returnsObject().noParams()) { it.target?.typed() }
                .function("createItemStack", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.createItemStack()
                    } else {
                        it.target?.createItemStack(it.getInt(0).toInt())
                    }
                }
                .function("createItemStack", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.createItemStack()
                    } else {
                        it.target?.createItemStack(it.getInt(0).toInt())
                    }
                }
                .function("hasBlockType", returns(Type.Z).noParams()) { it.target?.hasBlockType() }
                .function("blockType", returnsObject().noParams()) { it.target?.blockType }
                .function("maxStackSize", returnsObject().noParams()) { it.target?.maxStackSize }
                .function("maxDurability", returnsObject().noParams()) { it.target?.maxDurability }
                .function("isEdible", returns(Type.Z).noParams()) { it.target?.isEdible }
                .function("isRecord", returns(Type.Z).noParams()) { it.target?.isRecord }
                .function("isFuel", returns(Type.Z).noParams()) { it.target?.isFuel }
                .function("isCompostable", returns(Type.Z).noParams()) { it.target?.isCompostable }
                .function("compostChance", returnsObject().noParams()) { it.target?.compostChance }
                .function("craftingRemainingItem", returnsObject().noParams()) { it.target?.craftingRemainingItem }
                .function("creativeCategory", returnsObject().noParams()) { it.target?.creativeCategory }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.target?.isEnabledByFeature(it.getRef(0) as World) }
                .function("asMaterial", returnsObject().noParams()) { it.target?.asMaterial() }
                .function("itemMetaClass", returnsObject().noParams()) { it.target?.itemMetaClass }
        }
    }
}
