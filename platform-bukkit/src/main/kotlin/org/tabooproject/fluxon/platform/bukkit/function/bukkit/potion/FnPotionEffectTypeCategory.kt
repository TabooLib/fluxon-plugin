package org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.potion.PotionEffectTypeCategory"])
@PlatformSide(Platform.BUKKIT)
object FnPotionEffectTypeCategory : FnEnumGetter<org.bukkit.potion.PotionEffectTypeCategory>() {

    override val enumClass: Class<org.bukkit.potion.PotionEffectTypeCategory> = org.bukkit.potion.PotionEffectTypeCategory::class.java
}
