package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.server

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.server.ServerLoadEvent\$LoadType"])
@PlatformSide(Platform.BUKKIT)
object FnServerLoadEventLoadType : FnEnumGetter<org.bukkit.event.server.ServerLoadEvent.LoadType>() {

    override val enumClass: Class<org.bukkit.event.server.ServerLoadEvent.LoadType> = org.bukkit.event.server.ServerLoadEvent.LoadType::class.java
}
