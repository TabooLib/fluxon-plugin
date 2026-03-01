package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.packs.DataPack
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.packs.DataPack\$Compatibility"])
@PlatformSide(Platform.BUKKIT)
object FnDataPackCompatibility : FnEnumGetter<DataPack.Compatibility>() {

    override val enumClass: Class<DataPack.Compatibility> = DataPack.Compatibility::class.java
}
