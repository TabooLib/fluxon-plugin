package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.FireworkEffect\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnFireworkEffectType : FnEnumGetter<org.bukkit.FireworkEffect.Type>() {

    override val enumClass: Class<org.bukkit.FireworkEffect.Type> = org.bukkit.FireworkEffect.Type::class.java
}
