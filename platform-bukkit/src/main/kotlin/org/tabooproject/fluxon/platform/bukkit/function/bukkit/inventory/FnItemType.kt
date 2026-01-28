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
                .function("typed", returnsObject().noParams()) { it.setReturnRef(it.target?.typed()) }
                .function("createItemStack", returnsObject().noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.createItemStack()
                    } else {
                        it.target?.createItemStack(it.getInt(0).toInt())
                    })
                }
                .function("createItemStack", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.createItemStack()
                    } else {
                        it.target?.createItemStack(it.getInt(0).toInt())
                    })
                }
                .function("hasBlockType", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasBlockType()) }
                .function("blockType", returnsObject().noParams()) { it.setReturnRef(it.target?.blockType) }
                .function("maxStackSize", returnsObject().noParams()) { it.setReturnRef(it.target?.maxStackSize) }
                .function("maxDurability", returnsObject().noParams()) { it.setReturnRef(it.target?.maxDurability) }
                .function("isEdible", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isEdible) }
                .function("isRecord", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isRecord) }
                .function("isFuel", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFuel) }
                .function("isCompostable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCompostable) }
                .function("compostChance", returnsObject().noParams()) { it.setReturnRef(it.target?.compostChance) }
                .function("craftingRemainingItem", returnsObject().noParams()) { it.setReturnRef(it.target?.craftingRemainingItem) }
                .function("creativeCategory", returnsObject().noParams()) { it.setReturnRef(it.target?.creativeCategory) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isEnabledByFeature(it.getRef(0) as World)) }
                .function("asMaterial", returnsObject().noParams()) { it.setReturnRef(it.target?.asMaterial()) }
                .function("itemMetaClass", returnsObject().noParams()) { it.setReturnRef(it.target?.itemMetaClass) }
        }
    }
}
