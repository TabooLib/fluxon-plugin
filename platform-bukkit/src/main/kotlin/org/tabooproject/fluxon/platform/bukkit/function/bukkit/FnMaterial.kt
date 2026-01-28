package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.World
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.library.xseries.XMaterial
import kotlin.jvm.optionals.getOrNull
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.Material"])
@PlatformSide(Platform.BUKKIT)
object FnMaterial {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Material::class.java)
                .function("data", returnsObject().noParams()) { it.setReturnRef(it.target?.data) }
                .function("id", returns(Type.I).noParams()) { it.setReturnRef(it.target?.id) }
                .function("isLegacy", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isLegacy) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnRef(it.target?.maxStackSize) }
                .function("maxDurability", returns(Type.I).noParams()) { it.setReturnRef(it.target?.maxDurability) }
                .function("createBlockData", returnsObject().noParams()) { it.setReturnRef(it.target?.createBlockData()) }
                .function("createBlockData", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.createBlockData(it.getString(0))) }
                .function("getNewData", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.getNewData(it.getInt(0).toByte())) }
                .function("isBlock", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBlock) }
                .function("isEdible", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isEdible) }
                // static
                .function("getMaterial", returnsObject().params(Type.STRING)) { it.setReturnRef(Material.getMaterial(it.getString(0)!!)) }
                .function("getMaterial", returnsObject().params(Type.STRING, Type.Z)) { it.setReturnRef(Material.getMaterial(it.getString(0)!!, it.getBool(1))) }
                // static
                .function("matchMaterial", returnsObject().params(Type.STRING)) { it.setReturnRef(Material.matchMaterial(it.getString(0)!!)) }
                .function("matchMaterial", returnsObject().params(Type.STRING, Type.Z)) { it.setReturnRef(Material.matchMaterial(it.getString(0)!!, it.getBool(1))) }
                .function("isRecord", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isRecord) }
                .function("isSolid", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSolid) }
                .function("isAir", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAir) }
                .function("isTransparent", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isTransparent) }
                .function("isFlammable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFlammable) }
                .function("isBurnable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBurnable) }
                .function("isFuel", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFuel) }
                .function("isOccluding", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isOccluding) }
                .function("hasGravity", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasGravity()) }
                .function("isItem", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isItem) }
                .function("isInteractable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isInteractable) }
                .function("hardness", returns(Type.F).noParams()) { it.setReturnRef(it.target?.hardness) }
                .function("blastResistance", returns(Type.F).noParams()) { it.setReturnRef(it.target?.blastResistance) }
                .function("slipperiness", returns(Type.F).noParams()) { it.setReturnRef(it.target?.slipperiness) }
                .function("craftingRemainingItem", returnsObject().noParams()) { it.setReturnRef(it.target?.craftingRemainingItem) }
                .function("equipmentSlot", returnsObject().noParams()) { it.setReturnRef(it.target?.equipmentSlot) }
                .function("creativeCategory", returnsObject().noParams()) { it.setReturnRef(it.target?.creativeCategory) }
                .function("translationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.translationKey) }
                .function("blockTranslationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.blockTranslationKey) }
                .function("itemTranslationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.itemTranslationKey) }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isEnabledByFeature(it.getRef(0) as World)) }
                .function("isCompostable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCompostable) }
                .function("compostChance", returns(Type.F).noParams()) { it.setReturnRef(it.target?.compostChance) }
            registerFunction("material", returnsObject().params(Type.STRING)) {
                val name = it.getRef(0).toString()
                it.setReturnRef(XMaterial.matchXMaterial(name).getOrNull()?.get() ?: error("Material 不存在: $name"))}
            registerFunction("materialOrNull", returnsObject().params(Type.STRING)) {
                val name = it.getRef(0).toString()
                it.setReturnRef(XMaterial.matchXMaterial(name).getOrNull()?.get())}
        }
    }
}
