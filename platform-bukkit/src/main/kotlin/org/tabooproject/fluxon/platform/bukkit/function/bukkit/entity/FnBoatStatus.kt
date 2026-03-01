package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Boat\$Status"])
@PlatformSide(Platform.BUKKIT)
object FnBoatStatus : FnEnumGetter<org.bukkit.entity.Boat.Status>() {

    override val enumClass: Class<org.bukkit.entity.Boat.Status> = org.bukkit.entity.Boat.Status::class.java
}
