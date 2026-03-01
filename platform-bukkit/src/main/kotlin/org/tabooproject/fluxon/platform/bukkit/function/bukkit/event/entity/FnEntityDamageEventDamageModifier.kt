package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityDamageEvent\$DamageModifier"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDamageEventDamageModifier : FnEnumGetter<org.bukkit.event.entity.EntityDamageEvent.DamageModifier>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityDamageEvent.DamageModifier> = org.bukkit.event.entity.EntityDamageEvent.DamageModifier::class.java
}
