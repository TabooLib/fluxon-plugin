package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockFertilizeEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockFertilizeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockFertilizeEvent {

    val TYPE = Type.fromClass(BlockFertilizeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockFertilizeEvent::class.java)
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("blocks", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
        }
    }
}
