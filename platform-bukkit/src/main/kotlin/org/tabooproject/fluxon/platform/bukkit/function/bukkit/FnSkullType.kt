package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.SkullType
import org.tabooproject.fluxon.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.SkullType"])
@PlatformSide(Platform.BUKKIT)
object FnSkullType : FnEnumGetter<SkullType>() {

    override val enumClass: Class<SkullType> = SkullType::class.java
}