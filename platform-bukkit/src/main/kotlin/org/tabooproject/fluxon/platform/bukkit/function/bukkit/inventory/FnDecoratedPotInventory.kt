package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.DecoratedPotInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.DecoratedPotInventory"])
@PlatformSide(Platform.BUKKIT)
object FnDecoratedPotInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DecoratedPotInventory::class.java)
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItem(it.getRef(0) as ItemStack)) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
