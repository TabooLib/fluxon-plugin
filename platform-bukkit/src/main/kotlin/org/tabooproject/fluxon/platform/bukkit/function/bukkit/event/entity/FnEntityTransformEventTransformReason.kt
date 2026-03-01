package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.EntityTransformEvent\$TransformReason"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTransformEventTransformReason : FnEnumGetter<org.bukkit.event.entity.EntityTransformEvent.TransformReason>() {

    override val enumClass: Class<org.bukkit.event.entity.EntityTransformEvent.TransformReason> = org.bukkit.event.entity.EntityTransformEvent.TransformReason::class.java
}
