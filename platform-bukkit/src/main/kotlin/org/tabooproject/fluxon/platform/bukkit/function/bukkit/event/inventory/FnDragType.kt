package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.DragType
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.DragType"])
@PlatformSide(Platform.BUKKIT)
object FnDragType : FnEnumGetter<DragType>() {

    override val enumClass: Class<DragType> = DragType::class.java
}
