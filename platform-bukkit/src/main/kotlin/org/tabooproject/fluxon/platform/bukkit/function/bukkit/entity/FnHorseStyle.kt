package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Horse\$Style"])
@PlatformSide(Platform.BUKKIT)
object FnHorseStyle : FnEnumGetter<org.bukkit.entity.Horse.Style>() {

    override val enumClass: Class<org.bukkit.entity.Horse.Style> = org.bukkit.entity.Horse.Style::class.java
}
