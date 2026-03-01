package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.HeightMap"])
@PlatformSide(Platform.BUKKIT)
object FnHeightMap : FnEnumGetter<org.bukkit.HeightMap>() {

    override val enumClass: Class<org.bukkit.HeightMap> = org.bukkit.HeightMap::class.java
}
