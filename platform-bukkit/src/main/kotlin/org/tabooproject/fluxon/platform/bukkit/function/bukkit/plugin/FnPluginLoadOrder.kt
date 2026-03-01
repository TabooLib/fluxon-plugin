package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.PluginLoadOrder"])
@PlatformSide(Platform.BUKKIT)
object FnPluginLoadOrder : FnEnumGetter<org.bukkit.plugin.PluginLoadOrder>() {

    override val enumClass: Class<org.bukkit.plugin.PluginLoadOrder> = org.bukkit.plugin.PluginLoadOrder::class.java
}
