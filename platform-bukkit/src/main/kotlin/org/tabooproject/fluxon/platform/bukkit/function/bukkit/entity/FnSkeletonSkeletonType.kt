package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Skeleton\$SkeletonType"])
@PlatformSide(Platform.BUKKIT)
object FnSkeletonSkeletonType : FnEnumGetter<org.bukkit.entity.Skeleton.SkeletonType>() {

    override val enumClass: Class<org.bukkit.entity.Skeleton.SkeletonType> = org.bukkit.entity.Skeleton.SkeletonType::class.java
}
