package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Sniffer\$State"])
@PlatformSide(Platform.BUKKIT)
object FnSnifferState : FnEnumGetter<org.bukkit.entity.Sniffer.State>() {

    override val enumClass: Class<org.bukkit.entity.Sniffer.State> = org.bukkit.entity.Sniffer.State::class.java
}
