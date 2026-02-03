package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPlaceEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot
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

@Requires(classes = ["org.bukkit.event.block.BlockPlaceEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPlaceEvent {

    val TYPE = Type.fromClass(BlockPlaceEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPlaceEvent::class.java)
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.getPlayer()) }
                .function("blockPlaced", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.blockPlaced) }
                .function("blockReplacedState", returns(FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.blockReplacedState) }
                .function("blockAgainst", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.blockAgainst) }
                .function("itemInHand", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.getItemInHand()) }
                .function("hand", returns(FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.getHand()) }
                .function("canBuild", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canBuild() ?: false) }
                .function("setBuild", returnsVoid().params(Type.Z)) { it.target?.setBuild(it.getBool(0)) }
        }
    }
}
