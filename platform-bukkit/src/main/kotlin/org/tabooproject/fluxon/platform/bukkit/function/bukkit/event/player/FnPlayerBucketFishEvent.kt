package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerBucketFishEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerBucketFishEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBucketFishEvent::class.java)
                .function("entity", 0) { it.target?.entity }
                .function("waterBucket", 0) { it.target?.waterBucket }
                .function("fishBucket", 0) { it.target?.fishBucket }
        }
    }
}
