package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Warden\$AngerLevel"])
@PlatformSide(Platform.BUKKIT)
object FnWardenAngerLevel : FnEnumGetter<org.bukkit.entity.Warden.AngerLevel>() {

    override val enumClass: Class<org.bukkit.entity.Warden.AngerLevel> = org.bukkit.entity.Warden.AngerLevel::class.java
}
