package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.InventoryView
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnInventoryView {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryView::class.java)
                .function("topInventory", 0) { it.target?.topInventory }
                .function("bottomInventory", 0) { it.target?.bottomInventory }
                .function("player", 0) { it.target?.player }
                .function("type", 0) {
                    it.target?.type
                }
                .function("setItem", 2) { it.target?.setItem(it.getNumber(0).toInt(), it.getArgument(1) as ItemStack) }
                .function("item", 1) { it.target?.getItem(it.getNumber(0).toInt()) }
                .function("setCursor", 1) { it.target?.setCursor(it.getArgument(0) as ItemStack) }
                .function("cursor", 0) { it.target?.cursor }
                .function("inventory", 1) { it.target?.getInventory(it.getNumber(0).toInt()) }
                .function("convertSlot", 1) { it.target?.convertSlot(it.getNumber(0).toInt()) }
                .function("close", 0) { it.target?.close() }
                .function("countSlots", 0) { it.target?.countSlots() }
                .function("setProperty", 2) {
                    it.target?.setProperty(
                        it.getArgument(0) as InventoryView.Property,
                        it.getNumber(1).toInt()
                    )
                }
                .function("title", 0) { it.target?.title }
                .function("originalTitle", 0) { it.target?.originalTitle }
                .function("setTitle", 1) { it.target?.setTitle(it.getString(0)!!) }

            registerExtension(InventoryView.Property::class.java)
                .function("id", 0) { it.target?.getId() }
        }
    }
}
