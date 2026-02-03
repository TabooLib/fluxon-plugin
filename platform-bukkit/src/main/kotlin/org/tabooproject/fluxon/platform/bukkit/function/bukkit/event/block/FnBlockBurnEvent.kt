package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockBurnEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["org.bukkit.event.block.BlockBurnEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockBurnEvent {

    val TYPE = Type.fromClass(BlockBurnEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockBurnEvent::class.java)
                .function("ignitingBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.ignitingBlock) }
        }
    }
}
