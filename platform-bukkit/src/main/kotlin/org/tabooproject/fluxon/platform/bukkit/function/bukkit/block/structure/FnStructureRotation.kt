package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.structure

import org.bukkit.block.structure.StructureRotation
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.structure.StructureRotation"])
@PlatformSide(Platform.BUKKIT)
object FnStructureRotation : FnEnumGetter<StructureRotation>() {

    override val enumClass: Class<StructureRotation> = StructureRotation::class.java
}