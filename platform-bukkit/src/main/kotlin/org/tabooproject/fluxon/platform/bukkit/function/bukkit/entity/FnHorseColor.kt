package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Horse\$Color"])
@PlatformSide(Platform.BUKKIT)
object FnHorseColor : FnEnumGetter<org.bukkit.entity.Horse.Color>() {

    override val enumClass: Class<org.bukkit.entity.Horse.Color> = org.bukkit.entity.Horse.Color::class.java
}
