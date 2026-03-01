package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.ItemDisplay\$ItemDisplayTransform"])
@PlatformSide(Platform.BUKKIT)
object FnItemDisplayItemDisplayTransform : FnEnumGetter<org.bukkit.entity.ItemDisplay.ItemDisplayTransform>() {

    override val enumClass: Class<org.bukkit.entity.ItemDisplay.ItemDisplayTransform> = org.bukkit.entity.ItemDisplay.ItemDisplayTransform::class.java
}
