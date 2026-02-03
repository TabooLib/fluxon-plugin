package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDamageEvent
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


@Requires(classes = ["org.bukkit.event.block.BlockDamageEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDamageEvent {

    val TYPE = Type.fromClass(BlockDamageEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDamageEvent::class.java)
                .function("player", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("instaBreak", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.instaBreak) }
                .function("setInstaBreak", returnsVoid().params(Type.Z)) { it.target?.setInstaBreak(it.getBool(0)) }
                .function("itemInHand", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemInHand) }
        }
    }
}
