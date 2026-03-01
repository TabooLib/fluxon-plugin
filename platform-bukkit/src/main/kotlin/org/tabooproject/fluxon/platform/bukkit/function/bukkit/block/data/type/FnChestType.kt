package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.data.type.Chest\$Type"])
@PlatformSide(Platform.BUKKIT)
object FnChestType : FnEnumGetter<org.bukkit.block.data.type.Chest.Type>() {

    override val enumClass: Class<org.bukkit.block.data.type.Chest.Type> = org.bukkit.block.data.type.Chest.Type::class.java
}
