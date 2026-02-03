package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.PrepareInventoryResultEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.PrepareInventoryResultEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPrepareInventoryResultEvent {

    val TYPE = Type.fromClass(PrepareInventoryResultEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PrepareInventoryResultEvent::class.java)
                .function("result", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("setResult", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setResult(it.getRef(0) as ItemStack) }
        }
    }
}
