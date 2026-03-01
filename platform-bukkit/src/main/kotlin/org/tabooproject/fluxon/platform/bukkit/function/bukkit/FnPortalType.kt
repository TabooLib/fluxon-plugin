package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.PortalType"])
@PlatformSide(Platform.BUKKIT)
object FnPortalType : FnEnumGetter<org.bukkit.PortalType>() {

    override val enumClass: Class<org.bukkit.PortalType> = org.bukkit.PortalType::class.java
}
