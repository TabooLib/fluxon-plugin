package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign

import org.bukkit.block.sign.Side
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.sign.Side"])
@PlatformSide(Platform.BUKKIT)
object FnSide : FnEnumGetter<Side>() {

    override val enumClass: Class<Side> = Side::class.java
}