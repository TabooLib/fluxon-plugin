package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.MinecraftExperimental\$Requires"])
@PlatformSide(Platform.BUKKIT)
object FnMinecraftExperimentalRequires : FnEnumGetter<org.bukkit.MinecraftExperimental.Requires>() {

    override val enumClass: Class<org.bukkit.MinecraftExperimental.Requires> = org.bukkit.MinecraftExperimental.Requires::class.java
}
