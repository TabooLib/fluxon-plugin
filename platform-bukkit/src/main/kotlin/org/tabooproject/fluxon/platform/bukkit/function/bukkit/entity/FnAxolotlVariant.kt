package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Axolotl\$Variant"])
@PlatformSide(Platform.BUKKIT)
object FnAxolotlVariant : FnEnumGetter<org.bukkit.entity.Axolotl.Variant>() {

    override val enumClass: Class<org.bukkit.entity.Axolotl.Variant> = org.bukkit.entity.Axolotl.Variant::class.java
}
