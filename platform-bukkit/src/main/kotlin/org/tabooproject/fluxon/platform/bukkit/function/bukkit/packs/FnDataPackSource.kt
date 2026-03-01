package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.packs.DataPack
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.packs.DataPack\$Source"])
@PlatformSide(Platform.BUKKIT)
object FnDataPackSource : FnEnumGetter<DataPack.Source>() {

    override val enumClass: Class<DataPack.Source> = DataPack.Source::class.java
}
