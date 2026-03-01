package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.damage.DamageScaling"])
@PlatformSide(Platform.BUKKIT)
object FnDamageScaling : FnEnumGetter<org.bukkit.damage.DamageScaling>() {

    override val enumClass: Class<org.bukkit.damage.DamageScaling> = org.bukkit.damage.DamageScaling::class.java
}
