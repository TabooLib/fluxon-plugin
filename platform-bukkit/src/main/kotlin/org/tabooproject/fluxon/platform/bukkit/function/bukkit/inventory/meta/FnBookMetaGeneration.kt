package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.inventory.meta.BookMeta\$Generation"])
@PlatformSide(Platform.BUKKIT)
object FnBookMetaGeneration : FnEnumGetter<org.bukkit.inventory.meta.BookMeta.Generation>() {

    override val enumClass: Class<org.bukkit.inventory.meta.BookMeta.Generation> = org.bukkit.inventory.meta.BookMeta.Generation::class.java
}
