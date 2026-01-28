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
                .function("data", returnsObject().noParams()) { it.target?.data }
                .function("id", returns(Type.I).noParams()) { it.target?.id }
                .function("isLegacy", returns(Type.Z).noParams()) { it.target?.isLegacy }
                .function("key", returnsObject().noParams()) { it.target?.key }
                .function("maxStackSize", returns(Type.I).noParams()) { it.target?.maxStackSize }
                .function("maxDurability", returns(Type.I).noParams()) { it.target?.maxDurability }
                .function("createBlockData", returnsObject().noParams()) {
                    it.target?.createBlockData()
                }
                .function("createBlockData", returnsObject().params(Type.STRING)) {
                    it.target?.createBlockData(it.getString(0))
                }
                .function("getNewData", returnsObject().params(Type.I)) { it.target?.getNewData(it.getInt(0).toByte()) }
                .function("isBlock", returns(Type.Z).noParams()) { it.target?.isBlock }
                .function("isEdible", returns(Type.Z).noParams()) { it.target?.isEdible }
                // static
                .function("getMaterial", returnsObject().params(Type.STRING)) {
                    Material.getMaterial(it.getString(0)!!)
                }
                .function("getMaterial", returnsObject().params(Type.STRING, Type.Z)) {
                    Material.getMaterial(it.getString(0)!!, it.getBool(1))
                }
                // static
                .function("matchMaterial", returnsObject().params(Type.STRING)) {
                    Material.matchMaterial(it.getString(0)!!)
                }
                .function("matchMaterial", returnsObject().params(Type.STRING, Type.Z)) {
                    Material.matchMaterial(it.getString(0)!!, it.getBool(1))
                }
                .function("isRecord", returns(Type.Z).noParams()) { it.target?.isRecord }
                .function("isSolid", returns(Type.Z).noParams()) { it.target?.isSolid }
                .function("isAir", returns(Type.Z).noParams()) { it.target?.isAir }
                .function("isTransparent", returns(Type.Z).noParams()) { it.target?.isTransparent }
                .function("isFlammable", returns(Type.Z).noParams()) { it.target?.isFlammable }
                .function("isBurnable", returns(Type.Z).noParams()) { it.target?.isBurnable }
                .function("isFuel", returns(Type.Z).noParams()) { it.target?.isFuel }
                .function("isOccluding", returns(Type.Z).noParams()) { it.target?.isOccluding }
                .function("hasGravity", returns(Type.Z).noParams()) { it.target?.hasGravity() }
                .function("isItem", returns(Type.Z).noParams()) { it.target?.isItem }
                .function("isInteractable", returns(Type.Z).noParams()) { it.target?.isInteractable }
                .function("hardness", returns(Type.F).noParams()) { it.target?.hardness }
                .function("blastResistance", returns(Type.F).noParams()) { it.target?.blastResistance }
                .function("slipperiness", returns(Type.F).noParams()) { it.target?.slipperiness }
                .function("craftingRemainingItem", returnsObject().noParams()) { it.target?.craftingRemainingItem }
                .function("equipmentSlot", returnsObject().noParams()) { it.target?.equipmentSlot }
                .function("creativeCategory", returnsObject().noParams()) { it.target?.creativeCategory }
                .function("translationKey", returns(Type.STRING).noParams()) { it.target?.translationKey }
                .function("blockTranslationKey", returns(Type.STRING).noParams()) { it.target?.blockTranslationKey }
                .function("itemTranslationKey", returns(Type.STRING).noParams()) { it.target?.itemTranslationKey }
                .function("isEnabledByFeature", returns(Type.Z).params(Type.OBJECT)) { it.target?.isEnabledByFeature(it.getRef(0) as World) }
                .function("isCompostable", returns(Type.Z).noParams()) { it.target?.isCompostable }
                .function("compostChance", returns(Type.F).noParams()) { it.target?.compostChance }
            registerFunction("material", returnsObject().params(Type.STRING)) {
                val name = it.getRef(0).toString()
                XMaterial.matchXMaterial(name).getOrNull()?.get() ?: error("Material 不存在: $name")
            }
            registerFunction("materialOrNull", returnsObject().params(Type.STRING)) {
                val name = it.getRef(0).toString()
                XMaterial.matchXMaterial(name).getOrNull()?.get()
            }
        }
    }
}
