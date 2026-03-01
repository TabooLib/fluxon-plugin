package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityDamageEvent\$DamageCause"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDamageEventDamageCause : FnEnumGetter<org.bukkit.event.entity.EntityDamageEvent.DamageCause>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityDamageEvent.DamageCause> = org.bukkit.event.entity.EntityDamageEvent.DamageCause::class.java
}
