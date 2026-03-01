package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.TropicalFish\$Pattern"])
@PlatformSide(Platform.BUKKIT)
object FnTropicalFishPattern : FnEnumGetter<org.bukkit.entity.TropicalFish.Pattern>() {

    override val enumClass: Class<org.bukkit.entity.TropicalFish.Pattern> = org.bukkit.entity.TropicalFish.Pattern::class.java
}
