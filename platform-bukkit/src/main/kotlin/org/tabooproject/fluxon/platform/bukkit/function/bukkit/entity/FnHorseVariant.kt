package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Horse\$Variant"])
@PlatformSide(Platform.BUKKIT)
object FnHorseVariant : FnEnumGetter<org.bukkit.entity.Horse.Variant>() {

    override val enumClass: Class<org.bukkit.entity.Horse.Variant> = org.bukkit.entity.Horse.Variant::class.java
}
