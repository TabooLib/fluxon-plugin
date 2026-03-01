package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.NetherWartsState"])
@PlatformSide(Platform.BUKKIT)
object FnNetherWartsState : FnEnumGetter<org.bukkit.NetherWartsState>() {

    override val enumClass: Class<org.bukkit.NetherWartsState> = org.bukkit.NetherWartsState::class.java
}
