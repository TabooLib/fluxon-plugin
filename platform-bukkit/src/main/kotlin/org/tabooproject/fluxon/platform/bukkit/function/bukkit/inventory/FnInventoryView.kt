package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.InventoryView"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryView {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryView::class.java)
                .function("topInventory", returnsObject().noParams()) { it.target?.topInventory }
                .function("bottomInventory", returnsObject().noParams()) { it.target?.bottomInventory }
                .function("player", returnsObject().noParams()) { it.target?.player }
                .function("type", returnsObject().noParams()) {
                    it.target?.type
                }
                .function("setItem", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setItem(it.getInt(0).toInt(), it.getRef(1) as ItemStack) }
                .function("getItem", returnsObject().params(Type.OBJECT)) { it.target?.getItem(it.getInt(0).toInt()) }
                .function("setCursor", returnsObject().params(Type.OBJECT)) { it.target?.setCursor(it.getRef(0) as ItemStack) }
                .function("cursor", returnsObject().noParams()) { it.target?.cursor }
                .function("getInventory", returnsObject().params(Type.OBJECT)) { it.target?.getInventory(it.getInt(0).toInt()) }
                .function("convertSlot", returnsObject().params(Type.OBJECT)) { it.target?.convertSlot(it.getInt(0).toInt()) }
                .function("close", returnsObject().noParams()) { it.target?.close() }
                .function("countSlots", returnsObject().noParams()) { it.target?.countSlots() }
                .function("setProperty", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setProperty(
                        it.getRef(0) as InventoryView.Property,
                        it.getInt(1).toInt()
                    )
                }
                .function("title", returnsObject().noParams()) { it.target?.title }
                .function("originalTitle", returnsObject().noParams()) { it.target?.originalTitle }
                .function("setTitle", returnsObject().params(Type.OBJECT)) { it.target?.setTitle(it.getString(0)!!) }
        }
    }
}

@Requires(classes = ["org.bukkit.inventory.InventoryView.Property"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryViewProperty {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryView.Property::class.java)
                .function("id", returnsObject().noParams()) { it.target?.getId() }
        }
    }
}
