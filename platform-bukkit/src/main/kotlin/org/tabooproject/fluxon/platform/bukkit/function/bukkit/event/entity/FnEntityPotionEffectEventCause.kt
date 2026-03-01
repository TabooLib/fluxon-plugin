package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityPotionEffectEvent\$Cause"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPotionEffectEventCause : FnEnumGetter<org.bukkit.event.entity.EntityPotionEffectEvent.Cause>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityPotionEffectEvent.Cause> = org.bukkit.event.entity.EntityPotionEffectEvent.Cause::class.java
}
