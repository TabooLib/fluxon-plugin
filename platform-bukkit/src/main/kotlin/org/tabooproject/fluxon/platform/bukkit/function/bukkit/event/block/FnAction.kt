package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.Action"])
@PlatformSide(Platform.BUKKIT)
object FnAction : FnEnumGetter<org.bukkit.event.block.Action>() {

    override val enumClass: Class<org.bukkit.event.block.Action> = org.bukkit.event.block.Action::class.java
}
