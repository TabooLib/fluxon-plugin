package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.hanging

import org.bukkit.event.hanging.HangingPlaceEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.hanging.HangingPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnHangingPlaceEvent {

    val TYPE = Type.fromClass(HangingPlaceEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HangingPlaceEvent::class.java)
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("block", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
                .function("blockFace", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.blockFace) }
                .function("hand", returns(FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.hand) }
                .function("itemStack", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.itemStack) }
        }
    }
}
