package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.boss.BarFlag"])
@PlatformSide(Platform.BUKKIT)
object FnBarFlag : FnEnumGetter<org.bukkit.boss.BarFlag>() {

    override val enumClass: Class<org.bukkit.boss.BarFlag> = org.bukkit.boss.BarFlag::class.java
}
