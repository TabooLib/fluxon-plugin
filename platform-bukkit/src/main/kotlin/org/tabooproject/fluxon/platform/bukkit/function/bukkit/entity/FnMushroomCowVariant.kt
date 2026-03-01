package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.MushroomCow\$Variant"])
@PlatformSide(Platform.BUKKIT)
object FnMushroomCowVariant : FnEnumGetter<org.bukkit.entity.MushroomCow.Variant>() {

    override val enumClass: Class<org.bukkit.entity.MushroomCow.Variant> = org.bukkit.entity.MushroomCow.Variant::class.java
}
