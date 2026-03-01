package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Parrot\$Variant"])
@PlatformSide(Platform.BUKKIT)
object FnParrotVariant : FnEnumGetter<org.bukkit.entity.Parrot.Variant>() {

    override val enumClass: Class<org.bukkit.entity.Parrot.Variant> = org.bukkit.entity.Parrot.Variant::class.java
}
