package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockFormEvent
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockFormEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockFormEvent {

    val TYPE = Type.fromClass(BlockFormEvent::class.java)
}
