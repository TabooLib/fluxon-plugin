package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.World
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
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
object FnMaterial : FnEnumGetter<Material>() {

    override val enumClass: Class<Material> = Material::class.java

    override fun enumValue(value: String): Material? {
        return XMaterial.matchXMaterial(value).getOrNull()?.get()
    }

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Material::class.java)
                .function("data", returns(Type.CLASS).noParams()) { it.setReturnRef(it.target?.data) }
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
                .function("isLegacy", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLegacy ?: false) }
                .function("key", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                    // TODO: Short
                .function("maxDurability", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxDurability?.toInt() ?: 0) }
                .function("createBlockData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.createBlockData()) }
                .function("createBlockData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.createBlockData(it.getString(0))) }
                .function("getNewData", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE).params(Type.I)) { it.setReturnRef(it.target?.getNewData(it.getInt(0).toByte())) }
                .function("isBlock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBlock ?: false) }
                .function("isEdible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEdible ?: false) }
                // static
                .function("getMaterial", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.STRING)) { it.setReturnRef(Material.getMaterial(it.getString(0)!!)) }
                .function("getMaterial", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.STRING, Type.Z)) { it.setReturnRef(Material.getMaterial(it.getString(0)!!, it.getBool(1))) }
                // static
                .function("matchMaterial", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.STRING)) { it.setReturnRef(Material.matchMaterial(it.getString(0)!!)) }
                .function("matchMaterial", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.STRING, Type.Z)) { it.setReturnRef(Material.matchMaterial(it.getString(0)!!, it.getBool(1))) }
                .function("isRecord", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRecord ?: false) }
                .function("isSolid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSolid ?: false) }
                .function("isAir", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAir ?: false) }
                .function("isTransparent", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTransparent ?: false) }
                .function("isFlammable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFlammable ?: false) }
                .function("isBurnable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBurnable ?: false) }
                .function("isFuel", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFuel ?: false) }
                .function("isOccluding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOccluding ?: false) }
                .function("hasGravity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasGravity() ?: false) }
                .function("isItem", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isItem ?: false) }
                .function("isInteractable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInteractable ?: false) }
                .function("hardness", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.hardness ?: 0.0f) }
                .function("blastResistance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.blastResistance ?: 0.0f) }
                .function("slipperiness", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.slipperiness ?: 0.0f) }
                .function("craftingRemainingItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.craftingRemainingItem) }
                .function("equipmentSlot", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.equipmentSlot) }
                .function("creativeCategory", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnCreativeCategory.TYPE).noParams()) { it.setReturnRef(it.target?.creativeCategory) }
                .function("translationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.translationKey) }
                .function("blockTranslationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.blockTranslationKey) }
                .function("itemTranslationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.itemTranslationKey) }
                .function("isEnabledByFeature",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) {
                    it.setReturnBool(it.target?.isEnabledByFeature(it.getRef(0) as World) ?: false)
                }
                .function("isCompostable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCompostable ?: false) }
                .function("compostChance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.compostChance ?: 0.0f) }
        }
    }
}
