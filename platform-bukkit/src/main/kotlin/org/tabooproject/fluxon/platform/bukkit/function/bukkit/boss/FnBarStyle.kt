package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.boss.BarStyle"])
@PlatformSide(Platform.BUKKIT)
object FnBarStyle : FnEnumGetter<org.bukkit.boss.BarStyle>() {

    override val enumClass: Class<org.bukkit.boss.BarStyle> = org.bukkit.boss.BarStyle::class.java
}
