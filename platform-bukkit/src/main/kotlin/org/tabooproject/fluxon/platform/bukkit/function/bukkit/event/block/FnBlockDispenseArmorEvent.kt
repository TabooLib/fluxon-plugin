package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockDispenseArmorEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockDispenseArmorEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockDispenseArmorEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockDispenseArmorEvent::class.java)
                .function("targetEntity", 0) { it.target?.targetEntity }
        }
    }
}
