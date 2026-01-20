package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerBucketEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPlayerBucketEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerBucketEvent::class.java)
                .function("bucket", 0) { it.target?.bucket }
                .function("itemStack", 0) { it.target?.itemStack }
                .function("setItemStack", 1) { it.target?.setItemStack(it.getArgument(0) as ItemStack) }
                .function("block", 0) { it.target?.block }
                .function("blockClicked", 0) { it.target?.blockClicked }
                .function("blockFace", 0) { it.target?.blockFace }
                .function("hand", 0) { it.target?.hand }
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
        }
    }
}
