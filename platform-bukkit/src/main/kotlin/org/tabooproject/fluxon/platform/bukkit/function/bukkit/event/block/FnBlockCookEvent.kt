package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockCookEvent
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

@Requires(classes = ["org.bukkit.event.block.BlockCookEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockCookEvent {

    val TYPE = Type.fromClass(BlockCookEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockCookEvent::class.java)
                .function("source", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.source) }
                .function("result", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.result) }
                .function("setResult", returnsVoid().params(FnItemStack.TYPE)) { it.target?.setResult(it.getRef(0) as ItemStack) }
        }
    }
}
