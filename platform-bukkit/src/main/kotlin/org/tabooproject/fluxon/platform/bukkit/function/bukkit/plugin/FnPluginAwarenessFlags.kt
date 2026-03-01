package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.PluginAwareness\$Flags"])
@PlatformSide(Platform.BUKKIT)
object FnPluginAwarenessFlags : FnEnumGetter<org.bukkit.plugin.PluginAwareness.Flags>() {

    override val enumClass: Class<org.bukkit.plugin.PluginAwareness.Flags> = org.bukkit.plugin.PluginAwareness.Flags::class.java
}
