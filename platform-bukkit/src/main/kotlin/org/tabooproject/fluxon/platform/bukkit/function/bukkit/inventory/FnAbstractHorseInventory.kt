package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.AbstractHorseInventory
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

@Requires(classes = ["org.bukkit.inventory.AbstractHorseInventory"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractHorseInventory {

    val TYPE = Type.fromClass(AbstractHorseInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractHorseInventory::class.java)
                .function("saddle",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.saddle) }
                .function("setSaddle",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setSaddle(it.getRef(0) as ItemStack) }
        }
    }
}
