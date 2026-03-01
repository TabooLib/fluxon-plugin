package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.EntityCategory"])
@PlatformSide(Platform.BUKKIT)
object FnEntityCategory : FnEnumGetter<org.bukkit.entity.EntityCategory>() {

    override val enumClass: Class<org.bukkit.entity.EntityCategory> = org.bukkit.entity.EntityCategory::class.java
}
