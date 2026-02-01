package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Biome
import org.tabooproject.fluxon.function.FnEnumGetter
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.Biome"])
@PlatformSide(Platform.BUKKIT)
object FnBiome : FnEnumGetter<Biome>() {

    override val enumClass: Class<Biome> = Biome::class.java
}
