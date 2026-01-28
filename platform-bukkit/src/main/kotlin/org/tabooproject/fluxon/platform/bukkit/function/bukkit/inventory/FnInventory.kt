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
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.Inventory"])
@PlatformSide(Platform.BUKKIT)
object FnInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Inventory::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnRef(it.target?.size) }
                .function("maxStackSize", returnsObject().noParams()) { it.setReturnRef(it.target?.maxStackSize) }
                .function("setMaxStackSize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxStackSize(it.getInt(0).toInt())) }
                .function("getItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getItem(it.getInt(0).toInt())) }
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.setItem(it.getInt(0).toInt(), it.getRef(1) as ItemStack)) }
                .function("contents", returnsObject().noParams()) { it.setReturnRef(it.target?.contents) }
                .function("setContents", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setContents(it.getRef(0) as Array<ItemStack>)) }
                .function("storageContents", returnsObject().noParams()) { it.setReturnRef(it.target?.storageContents) }
                .function("setStorageContents", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setStorageContents(it.getRef(0) as Array<ItemStack>)) }
                .function("contains", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Material -> it.target?.contains(var1)
                            is ItemStack -> it.target?.contains(var1)
                            else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                        }
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Material -> it.target?.contains(var1, it.getInt(1).toInt())
                            is ItemStack -> it.target?.contains(var1, it.getInt(1).toInt())
                            else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                        }
                    })
                }
                .function("contains", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Material -> it.target?.contains(var1)
                            is ItemStack -> it.target?.contains(var1)
                            else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                        }
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Material -> it.target?.contains(var1, it.getInt(1).toInt())
                            is ItemStack -> it.target?.contains(var1, it.getInt(1).toInt())
                            else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                        }
                    })
                }
                .function("containsAtLeast", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.containsAtLeast(
                        it.getRef(0) as ItemStack,
                        it.getInt(1).toInt()
                    ))
                }
                .function("first", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.first(var1)
                        is ItemStack -> it.target?.first(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    })
                }
                .function("firstEmpty", returnsObject().noParams()) { it.setReturnRef(it.target?.firstEmpty()) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isEmpty) }
                .function("remove", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.remove(var1)
                        is ItemStack -> it.target?.remove(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    })
                }
                .function("clear", returnsObject().noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.clear()
                    } else {
                        it.target?.clear(it.getInt(0).toInt())
                    })
                }
                .function("clear", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.clear()
                    } else {
                        it.target?.clear(it.getInt(0).toInt())
                    })
                }
                .function("viewers", returnsObject().noParams()) { it.setReturnRef(it.target?.viewers) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
                .function("iterator", returnsObject().noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.iterator()
                    } else {
                        it.target?.iterator(it.getInt(0).toInt())
                    })
                }
                .function("iterator", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.iterator()
                    } else {
                        it.target?.iterator(it.getInt(0).toInt())
                    })
                }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
