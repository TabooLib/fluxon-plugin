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
                .function("toLegacy", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.toLegacy(it.getRef(0) as Material)) }
                .function("fromLegacy", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.fromLegacy(var1)
                        is MaterialData -> it.target?.fromLegacy(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 MaterialData 类型")
                    })
                }
                .function("fromLegacy", returnsObject().params(Type.OBJECT, Type.Z)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is MaterialData -> it.target?.fromLegacy(var1, it.getBool(1))
                        else -> throw IllegalArgumentException("参数 1 必须是 MaterialData 类型")
                    })
                }
                .function("fromLegacy", returnsObject().params(Type.OBJECT, Type.I)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.fromLegacy(var1, it.getInt(1).toByte())
                        else -> throw IllegalArgumentException("参数 1 必须是 Material 类型")
                    })
                }
                .function("getMaterial", returnsObject().params(Type.STRING, Type.I)) {
                    it.setReturnRef(it.target?.getMaterial(it.getString(0), it.getInt(1).toInt()))
                }
                .function("dataVersion", returns(Type.I).noParams()) { it.setReturnInt(it.target?.dataVersion ?: 0) }
                .function("modifyItemStack", returnsObject().params(Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(it.target?.modifyItemStack(
                        it.getRef(0) as ItemStack,
                        it.getString(1)
                    ))
                }
                .function("checkSupported", returnsVoid().params(Type.OBJECT)) { it.target?.checkSupported(it.getRef(0) as PluginDescriptionFile) }
                .function("processClass", returnsObject().params(Type.OBJECT, Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.processClass(
                        it.getRef(0) as PluginDescriptionFile,
                        it.getString(1),
                        it.getRef(2) as ByteArray
                    ))
                }
                .function("loadAdvancement", returnsObject().params(Type.OBJECT, Type.STRING)) {
                    it.setReturnRef(it.target?.loadAdvancement(
                        it.getRef(0) as NamespacedKey,
                        it.getString(1)
                    ))
                }
                .function("removeAdvancement", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeAdvancement(it.getRef(0) as NamespacedKey) ?: false)
                }
                .function("getCreativeCategory", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getCreativeCategory(it.getRef(0) as Material)) }
                .function("getBlockTranslationKey", returns(Type.STRING).params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getBlockTranslationKey(it.getRef(0) as Material))
                }
                .function("getItemTranslationKey", returns(Type.STRING).params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.getItemTranslationKey(it.getRef(0) as Material))
                }
                .function("getTranslationKey", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is EntityType -> it.target?.getTranslationKey(var1)
                        is ItemStack -> it.target?.getTranslationKey(var1)
                        is Attribute -> it.target?.getTranslationKey(var1)
                        else -> throw IllegalArgumentException("参数必须是 EntityType, ItemStack, 或 Attribute 类型")
                    })
                }
                .function("getFeatureFlag", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getFeatureFlag(it.getRef(0) as NamespacedKey)) }
        }
    }
}
