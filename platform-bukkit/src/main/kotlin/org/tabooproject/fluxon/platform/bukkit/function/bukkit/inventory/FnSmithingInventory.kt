package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.SmithingInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.SmithingInventory"])
@PlatformSide(Platform.BUKKIT)
object FnSmithingInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SmithingInventory::class.java)
                .function("result", returnsObject().noParams()) { it.target?.result }
                .function("setResult", returnsObject().params(Type.OBJECT)) { it.target?.setResult(it.getRef(0) as ItemStack) }
                .function("recipe", returnsObject().noParams()) { it.target?.recipe }
        }
    }
}
