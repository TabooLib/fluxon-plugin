package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.ServicePriority"])
@PlatformSide(Platform.BUKKIT)
object FnServicePriority : FnEnumGetter<org.bukkit.plugin.ServicePriority>() {

    override val enumClass: Class<org.bukkit.plugin.ServicePriority> = org.bukkit.plugin.ServicePriority::class.java
}
