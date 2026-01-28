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
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.AbstractHorseInventory"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractHorseInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractHorseInventory::class.java)
                .function("saddle", returnsObject().noParams()) { it.target?.saddle }
                .function("setSaddle", returnsObject().params(Type.OBJECT)) { it.target?.setSaddle(it.getRef(0) as ItemStack) }
        }
    }
}
