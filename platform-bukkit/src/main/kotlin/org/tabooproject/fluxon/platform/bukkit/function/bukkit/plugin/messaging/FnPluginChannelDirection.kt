package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.messaging

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.plugin.messaging.PluginChannelDirection"])
@PlatformSide(Platform.BUKKIT)
object FnPluginChannelDirection : FnEnumGetter<org.bukkit.plugin.messaging.PluginChannelDirection>() {

    override val enumClass: Class<org.bukkit.plugin.messaging.PluginChannelDirection> = org.bukkit.plugin.messaging.PluginChannelDirection::class.java
}
