package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityKnockbackEvent\$KnockbackCause"])
@PlatformSide(Platform.BUKKIT)
object FnEntityKnockbackEventKnockbackCause : FnEnumGetter<org.bukkit.event.entity.EntityKnockbackEvent.KnockbackCause>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityKnockbackEvent.KnockbackCause> = org.bukkit.event.entity.EntityKnockbackEvent.KnockbackCause::class.java
}
