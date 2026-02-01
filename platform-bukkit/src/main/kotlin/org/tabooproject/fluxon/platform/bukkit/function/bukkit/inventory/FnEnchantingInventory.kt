package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.EnchantingInventory
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

@Requires(classes = ["org.bukkit.inventory.EnchantingInventory"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantingInventory {

    val TYPE = Type.fromClass(EnchantingInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantingInventory::class.java)
                .function("setItem", returnsVoid().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setSecondary", returnsVoid().params(Type.OBJECT)) { it.target?.setSecondary(it.getRef(0) as ItemStack) }
                .function("secondary", returnsObject().noParams()) { it.setReturnRef(it.target?.secondary) }
        }
    }
}
