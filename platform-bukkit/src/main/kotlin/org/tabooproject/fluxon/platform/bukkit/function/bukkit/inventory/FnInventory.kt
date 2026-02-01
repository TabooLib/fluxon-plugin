package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.Material
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.Inventory"])
@PlatformSide(Platform.BUKKIT)
object FnInventory {

    val TYPE = Type.fromClass(Inventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Inventory::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnInt(it.target?.size ?: 0) }
                .function("maxStackSize", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxStackSize ?: 0) }
                .function("setMaxStackSize", returnsVoid().params(Type.I)) { it.target?.setMaxStackSize(it.getInt(0).toInt()) }
                .function("getItem", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.getItem(it.getInt(0).toInt())) }
                .function("setItem", returnsVoid().params(Type.I, Type.OBJECT)) {
                    it.target?.setItem(it.getInt(0).toInt(), it.getRef(1) as ItemStack)
                }
                .function("contents", returnsObject().noParams()) { it.setReturnRef(it.target?.contents) }
                .function("setContents", returnsVoid().params(Type.OBJECT)) { it.target?.setContents(it.getRef(0) as Array<ItemStack>) }
                .function("storageContents", returnsObject().noParams()) { it.setReturnRef(it.target?.storageContents) }
                .function("setStorageContents", returnsVoid().params(Type.OBJECT)) { it.target?.setStorageContents(it.getRef(0) as Array<ItemStack>) }
                .function("contains", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.contains(var1)
                        is ItemStack -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    } ?: false)
                }
                .function("contains", returns(Type.Z).params(Type.OBJECT, Type.I)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.contains(var1, it.getInt(1).toInt())
                        is ItemStack -> it.target?.contains(var1, it.getInt(1).toInt())
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    } ?: false)
                }
                .function("containsAtLeast", returns(Type.Z).params(Type.OBJECT, Type.I)) {
                    it.setReturnBool(it.target?.containsAtLeast(
                        it.getRef(0) as ItemStack,
                        it.getInt(1).toInt()
                    ) ?: false)
                }
                .function("first", returns(Type.I).params(Type.OBJECT)) {
                    it.setReturnInt(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.first(var1)
                        is ItemStack -> it.target?.first(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    } ?: -1)
                }
                .function("firstEmpty", returns(Type.I).noParams()) { it.setReturnInt(it.target?.firstEmpty() ?: -1) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("remove", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.remove(var1)
                        is ItemStack -> it.target?.remove(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    }
                }
                .function("clear", returnsVoid().noParams()) { it.target?.clear() }
                .function("clear", returnsVoid().params(Type.I)) { it.target?.clear(it.getInt(0).toInt()) }
                .function("viewers", returnsObject().noParams()) { it.setReturnRef(it.target?.viewers) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
                .function("iterator", returnsObject().noParams()) { it.setReturnRef(it.target?.iterator()) }
                .function("iterator", returnsObject().params(Type.I)) { it.setReturnRef(it.target?.iterator(it.getInt(0).toInt())) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
