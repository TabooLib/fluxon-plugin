package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Pose"])
@PlatformSide(Platform.BUKKIT)
object FnPose : FnEnumGetter<org.bukkit.entity.Pose>() {

    override val enumClass: Class<org.bukkit.entity.Pose> = org.bukkit.entity.Pose::class.java
}
