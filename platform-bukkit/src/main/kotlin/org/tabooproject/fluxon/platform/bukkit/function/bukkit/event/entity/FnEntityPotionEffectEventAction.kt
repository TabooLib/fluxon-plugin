package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityPotionEffectEvent\$Action"])
@PlatformSide(Platform.BUKKIT)
object FnEntityPotionEffectEventAction : FnEnumGetter<org.bukkit.event.entity.EntityPotionEffectEvent.Action>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityPotionEffectEvent.Action> = org.bukkit.event.entity.EntityPotionEffectEvent.Action::class.java
}
