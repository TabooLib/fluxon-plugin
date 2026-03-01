package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityTargetEvent\$TargetReason"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTargetEventTargetReason : FnEnumGetter<org.bukkit.event.entity.EntityTargetEvent.TargetReason>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityTargetEvent.TargetReason> = org.bukkit.event.entity.EntityTargetEvent.TargetReason::class.java
}
