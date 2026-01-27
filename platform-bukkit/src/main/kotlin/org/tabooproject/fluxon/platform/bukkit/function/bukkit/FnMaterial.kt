package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.World
import org.tabooproject.fluxon.runtime.FluxonRuntime
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
                .function("data", 0) { it.target?.data }
                .function("id", 0) { it.target?.id }
                .function("isLegacy", 0) { it.target?.isLegacy }
                .function("key", 0) { it.target?.key }
                .function("maxStackSize", 0) { it.target?.maxStackSize }
                .function("maxDurability", 0) { it.target?.maxDurability }
                .function("createBlockData", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.createBlockData()
                    } else {
                        it.target?.createBlockData(it.getString(0))
                    }
                }
                .function("getNewData", 1) { it.target?.getNewData(it.getNumber(0).toByte()) }
                .function("isBlock", 0) { it.target?.isBlock }
                .function("isEdible", 0) { it.target?.isEdible }
                // static
                .function("getMaterial", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        Material.getMaterial(it.getString(0)!!)
                    } else {
                        Material.getMaterial(it.getString(0)!!, it.getBoolean(1))
                    }
                }
                // static
                .function("matchMaterial", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        Material.matchMaterial(it.getString(0)!!)
                    } else {
                        Material.matchMaterial(it.getString(0)!!, it.getBoolean(1))
                    }
                }
                .function("isRecord", 0) { it.target?.isRecord }
                .function("isSolid", 0) { it.target?.isSolid }
                .function("isAir", 0) { it.target?.isAir }
                .function("isTransparent", 0) { it.target?.isTransparent }
                .function("isFlammable", 0) { it.target?.isFlammable }
                .function("isBurnable", 0) { it.target?.isBurnable }
                .function("isFuel", 0) { it.target?.isFuel }
                .function("isOccluding", 0) { it.target?.isOccluding }
                .function("hasGravity", 0) { it.target?.hasGravity() }
                .function("isItem", 0) { it.target?.isItem }
                .function("isInteractable", 0) { it.target?.isInteractable }
                .function("hardness", 0) { it.target?.hardness }
                .function("blastResistance", 0) { it.target?.blastResistance }
                .function("slipperiness", 0) { it.target?.slipperiness }
                .function("craftingRemainingItem", 0) { it.target?.craftingRemainingItem }
                .function("equipmentSlot", 0) { it.target?.equipmentSlot }
                .function("creativeCategory", 0) { it.target?.creativeCategory }
                .function("translationKey", 0) { it.target?.translationKey }
                .function("blockTranslationKey", 0) { it.target?.blockTranslationKey }
                .function("itemTranslationKey", 0) { it.target?.itemTranslationKey }
                .function("isEnabledByFeature", 1) { it.target?.isEnabledByFeature(it.getArgument(0) as World) }
                .function("isCompostable", 0) { it.target?.isCompostable }
                .function("compostChance", 0) { it.target?.compostChance }
            registerFunction("material", 1) {
                val name = it.getArgument(0).toString()
                XMaterial.matchXMaterial(name).getOrNull()?.get() ?: error("Material 不存在: $name")
            }
            registerFunction("materialOrNull", 1) {
                val name = it.getArgument(0).toString()
                XMaterial.matchXMaterial(name).getOrNull()?.get()
            }
        }
    }
}
