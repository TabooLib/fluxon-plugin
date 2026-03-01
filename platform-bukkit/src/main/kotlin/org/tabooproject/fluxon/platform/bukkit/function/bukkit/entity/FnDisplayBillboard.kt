package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Display\$Billboard"])
@PlatformSide(Platform.BUKKIT)
object FnDisplayBillboard : FnEnumGetter<org.bukkit.entity.Display.Billboard>() {

    override val enumClass: Class<org.bukkit.entity.Display.Billboard> = org.bukkit.entity.Display.Billboard::class.java
}
