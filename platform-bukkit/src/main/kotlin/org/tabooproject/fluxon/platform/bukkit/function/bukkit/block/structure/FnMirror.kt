package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure

import org.bukkit.block.structure.Mirror
import org.tabooproject.fluxon.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.structure.Mirror"])
@PlatformSide(Platform.BUKKIT)
object FnMirror : FnEnumGetter<Mirror>() {

    override val enumClass: Class<Mirror> = Mirror::class.java
}