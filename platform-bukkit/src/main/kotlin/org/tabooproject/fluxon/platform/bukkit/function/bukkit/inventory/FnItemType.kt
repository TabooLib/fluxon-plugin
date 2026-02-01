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

    val TYPE = Type.fromClass(ItemType::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemType::class.java)
                .function("typed", returnsObject().noParams()) { it.setReturnRef(it.target?.typed()) }
                .function("createItemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.createItemStack()) }
                .function("createItemStack", returnsObject().params(Type.I)) {
                    it.setReturnRef(it.target?.createItemStack(it.getInt(0).toInt()))
                }
                .function("hasBlockType", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBlockType() ?: false) }
                .function("blockType", returnsObject().noParams()) { it.setReturnRef(it.target?.blockType) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                .function("maxDurability", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxDurability?.toInt() ?: 0) }
                .function("isEdible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEdible ?: false) }
                .function("isRecord", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRecord ?: false) }
                .function("isFuel", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFuel ?: false) }
                .function("isCompostable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCompostable ?: false) }
                .function("compostChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.compostChance ?: 0f) }
                .function("craftingRemainingItem", returnsObject().noParams()) { it.setReturnRef(it.target?.craftingRemainingItem) }
                .function("creativeCategory", returnsObject().noParams()) { it.setReturnRef(it.target?.creativeCategory) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.isEnabledByFeature(it.getRef(0) as World) ?: false) }
                .function("asMaterial", returnsObject().noParams()) { it.setReturnRef(it.target?.asMaterial()) }
                .function("itemMetaClass", returnsObject().noParams()) { it.setReturnRef(it.target?.itemMetaClass) }
        }
    }
}
