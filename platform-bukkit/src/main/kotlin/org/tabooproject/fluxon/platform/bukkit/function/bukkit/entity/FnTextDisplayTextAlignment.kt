package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.TextDisplay\$TextAlignment"])
@PlatformSide(Platform.BUKKIT)
object FnTextDisplayTextAlignment : FnEnumGetter<org.bukkit.entity.TextDisplay.TextAlignment>() {

    override val enumClass: Class<org.bukkit.entity.TextDisplay.TextAlignment> = org.bukkit.entity.TextDisplay.TextAlignment::class.java
}
