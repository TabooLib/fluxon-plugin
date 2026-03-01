package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.AbstractArrow\$PickupStatus"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractArrowPickupStatus : FnEnumGetter<org.bukkit.entity.AbstractArrow.PickupStatus>() {

    override val enumClass: Class<org.bukkit.entity.AbstractArrow.PickupStatus> = org.bukkit.entity.AbstractArrow.PickupStatus::class.java
}
