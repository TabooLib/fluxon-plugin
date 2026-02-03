package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockIgniteEvent
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockIgniteEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockIgniteEvent {

    val TYPE = Type.fromClass(BlockIgniteEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockIgniteEvent::class.java)
                .function("cause", returns(FnBlockIgniteEventIgniteCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("ignitingEntity", returns(FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.ignitingEntity) }
                .function("ignitingBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.ignitingBlock) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.block.BlockIgniteEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockIgniteEventIgniteCause : FnEnumGetter<BlockIgniteEvent.IgniteCause>() {

    override val enumClass: Class<BlockIgniteEvent.IgniteCause> = BlockIgniteEvent.IgniteCause::class.java
}