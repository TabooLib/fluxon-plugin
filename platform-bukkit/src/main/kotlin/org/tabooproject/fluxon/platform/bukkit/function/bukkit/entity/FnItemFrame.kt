package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Rotation
import org.bukkit.entity.ItemFrame
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnItemFrame {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemFrame::class.java)
                .function("item", 0) { it.target?.item }
                .function("setItem", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setItem(it.getArgument(0) as ItemStack)
                    } else {
                        it.target?.setItem(it.getArgument(0) as ItemStack, it.getBoolean(1))
                    }
                }
                .function("itemDropChance", 0) { it.target?.itemDropChance }
                .function("setItemDropChance", 1) { it.target?.setItemDropChance(it.getNumber(0).toFloat()) }
                .function("rotation", 0) { it.target?.rotation }
                .function("setRotation", 1) { it.target?.setRotation(it.getArgument(0) as Rotation) }
                .function("isVisible", 0) { it.target?.isVisible }
                .function("setVisible", 1) { it.target?.setVisible(it.getBoolean(0)) }
                .function("isFixed", 0) { it.target?.isFixed }
                .function("setFixed", 1) { it.target?.setFixed(it.getBoolean(0)) }
        }
    }
}
