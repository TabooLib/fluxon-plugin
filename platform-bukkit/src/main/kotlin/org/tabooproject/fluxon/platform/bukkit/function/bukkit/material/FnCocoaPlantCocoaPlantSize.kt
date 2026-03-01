package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.material.CocoaPlant\$CocoaPlantSize"])
@PlatformSide(Platform.BUKKIT)
object FnCocoaPlantCocoaPlantSize : FnEnumGetter<org.bukkit.material.CocoaPlant.CocoaPlantSize>() {

    override val enumClass: Class<org.bukkit.material.CocoaPlant.CocoaPlantSize> = org.bukkit.material.CocoaPlant.CocoaPlantSize::class.java
}
