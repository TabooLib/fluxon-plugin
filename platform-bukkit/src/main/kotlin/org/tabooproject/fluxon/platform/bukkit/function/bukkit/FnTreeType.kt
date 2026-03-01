package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.TreeType"])
@PlatformSide(Platform.BUKKIT)
object FnTreeType : FnEnumGetter<org.bukkit.TreeType>() {

    override val enumClass: Class<org.bukkit.TreeType> = org.bukkit.TreeType::class.java
}
