package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.boss.BarColor"])
@PlatformSide(Platform.BUKKIT)
object FnBarColor : FnEnumGetter<org.bukkit.boss.BarColor>() {

    override val enumClass: Class<org.bukkit.boss.BarColor> = org.bukkit.boss.BarColor::class.java
}
