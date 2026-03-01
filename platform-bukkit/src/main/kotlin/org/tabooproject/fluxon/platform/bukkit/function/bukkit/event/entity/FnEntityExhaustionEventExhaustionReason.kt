package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityExhaustionEvent\$ExhaustionReason"])
@PlatformSide(Platform.BUKKIT)
object FnEntityExhaustionEventExhaustionReason : FnEnumGetter<org.bukkit.event.entity.EntityExhaustionEvent.ExhaustionReason>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityExhaustionEvent.ExhaustionReason> = org.bukkit.event.entity.EntityExhaustionEvent.ExhaustionReason::class.java
}
