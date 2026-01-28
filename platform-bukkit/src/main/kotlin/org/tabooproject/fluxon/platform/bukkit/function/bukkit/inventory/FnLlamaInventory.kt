package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.LlamaInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.LlamaInventory"])
@PlatformSide(Platform.BUKKIT)
object FnLlamaInventory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LlamaInventory::class.java)
                .function("decor", returnsObject().noParams()) { it.setReturnRef(it.target?.decor) }
                .function("setDecor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDecor(it.getRef(0) as ItemStack)) }
        }
    }
}
