package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnBlockDamageEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDamageEvent::class.java)
                .function("player", 0) { it.target?.player }
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("instaBreak", 0) { it.target?.instaBreak }
                .syncFunction("setInstaBreak", 1) { it.target?.apply { instaBreak = it.getBoolean(0) } }
        }
    }
}
