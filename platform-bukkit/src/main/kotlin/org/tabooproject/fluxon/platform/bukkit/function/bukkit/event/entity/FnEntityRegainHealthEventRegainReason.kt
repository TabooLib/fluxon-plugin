package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityRegainHealthEvent\$RegainReason"])
@PlatformSide(Platform.BUKKIT)
object FnEntityRegainHealthEventRegainReason : FnEnumGetter<org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason> = org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason::class.java
}
