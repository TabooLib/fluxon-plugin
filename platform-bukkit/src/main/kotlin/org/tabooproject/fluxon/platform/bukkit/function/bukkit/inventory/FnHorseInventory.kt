package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.HorseInventory
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.HorseInventory"])
@PlatformSide(Platform.BUKKIT)
object FnHorseInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HorseInventory::class.java)
                .function("armor", returnsObject().noParams()) { it.target?.armor }
                .function("setArmor", returnsObject().params(Type.OBJECT)) { it.target?.setArmor(it.getRef(0) as ItemStack) }
        }
    }
}
