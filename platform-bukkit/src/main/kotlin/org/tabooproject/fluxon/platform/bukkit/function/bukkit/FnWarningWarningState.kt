package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Warning\$WarningState"])
@PlatformSide(Platform.BUKKIT)
object FnWarningWarningState : FnEnumGetter<org.bukkit.Warning.WarningState>() {

    override val enumClass: Class<org.bukkit.Warning.WarningState> = org.bukkit.Warning.WarningState::class.java
}
