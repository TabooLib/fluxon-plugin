package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.UnsafeValues
import org.bukkit.attribute.Attribute
import org.bukkit.entity.EntityType
import org.bukkit.inventory.ItemStack
import org.bukkit.material.MaterialData
import org.bukkit.plugin.PluginDescriptionFile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.UnsafeValues"])
@PlatformSide(Platform.BUKKIT)
object FnUnsafeValues {

    val TYPE = Type.fromClass(UnsafeValues::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(UnsafeValues::class.java)
                .function("toLegacy",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.toLegacy(it.getRef(0) as Material)) }
                .function("fromLegacy", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.fromLegacy(it.getRef(0) as Material)) }
                .function("fromLegacy", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.setReturnRef(it.target?.fromLegacy(it.getRef(0) as MaterialData)) }
                .function("fromLegacy", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE, Type.Z)) { it.setReturnRef(it.target?.fromLegacy(it.getRef(0) as MaterialData, it.getBool(1))) }
                .function("fromLegacy", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) { it.setReturnRef(it.target?.fromLegacy(it.getRef(0) as Material, it.getInt(1).toByte())) }
                .function("getMaterial", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE).params(Type.STRING, Type.I)) {
                    it.setReturnRef(it.target?.getMaterial(it.getString(0), it.getInt(1).toInt()))
                }
                .function("dataVersion", returns(Type.I).noParams()) { it.setReturnInt(it.target?.dataVersion ?: 0) }
                .function("modifyItemStack",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE, Type.STRING)) {
                    it.setReturnRef(it.target?.modifyItemStack(
                        it.getRef(0) as ItemStack,
                        it.getString(1)
                    ))
                }
                .function("checkSupported",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginDescriptionFile.TYPE)) { it.target?.checkSupported(it.getRef(0) as PluginDescriptionFile) }
                .function("processClass",returns(Type.fromClass(ByteArray::class.java)).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginDescriptionFile.TYPE, Type.STRING, Type.fromClass(ByteArray::class.java))) {
                    it.setReturnRef(it.target?.processClass(
                        it.getRef(0) as PluginDescriptionFile,
                        it.getString(1),
                        it.getRef(2) as ByteArray
                    ))
                }
                .function("loadAdvancement",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement.FnAdvancement.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE, Type.STRING)) {
                    it.setReturnRef(it.target?.loadAdvancement(
                        it.getRef(0) as NamespacedKey,
                        it.getString(1)
                    ))
                }
                .function("removeAdvancement",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) {
                    it.setReturnBool(it.target?.removeAdvancement(it.getRef(0) as NamespacedKey) ?: false)
                }
                .function("getCreativeCategory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnCreativeCategory.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnRef(it.target?.getCreativeCategory(it.getRef(0) as Material)) }
                .function("getBlockTranslationKey",returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.setReturnRef(it.target?.getBlockTranslationKey(it.getRef(0) as Material))
                }
                .function("getItemTranslationKey",returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) {
                    it.setReturnRef(it.target?.getItemTranslationKey(it.getRef(0) as Material))
                }
                .function("getTranslationKey", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.setReturnRef(it.target?.getTranslationKey(it.getRef(0) as EntityType)) }
                .function("getTranslationKey", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnRef(it.target?.getTranslationKey(it.getRef(0) as ItemStack)) }
                .function("getTranslationKey", returns(Type.STRING).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute.FnAttribute.TYPE)) { it.setReturnRef(it.target?.getTranslationKey(it.getRef(0) as Attribute)) }
                .function("getFeatureFlag",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnFeatureFlag.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(it.target?.getFeatureFlag(it.getRef(0) as NamespacedKey)) }
        }
    }
}
