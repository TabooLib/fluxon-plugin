package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.scoreboard.RenderType"])
@PlatformSide(Platform.BUKKIT)
object FnRenderType : FnEnumGetter<org.bukkit.scoreboard.RenderType>() {

    override val enumClass: Class<org.bukkit.scoreboard.RenderType> = org.bukkit.scoreboard.RenderType::class.java
}
