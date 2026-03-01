package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Wither\$Head"])
@PlatformSide(Platform.BUKKIT)
object FnWitherHead : FnEnumGetter<org.bukkit.entity.Wither.Head>() {

    override val enumClass: Class<org.bukkit.entity.Wither.Head> = org.bukkit.entity.Wither.Head::class.java
}
