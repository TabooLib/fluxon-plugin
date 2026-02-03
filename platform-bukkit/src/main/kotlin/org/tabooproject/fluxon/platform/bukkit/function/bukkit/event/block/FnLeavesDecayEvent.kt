package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.LeavesDecayEvent
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.LeavesDecayEvent"])
@PlatformSide(Platform.BUKKIT)
object FnLeavesDecayEvent {

    val TYPE = Type.fromClass(LeavesDecayEvent::class.java)
}
