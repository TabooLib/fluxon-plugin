package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.SpawnCategory"])
@PlatformSide(Platform.BUKKIT)
object FnSpawnCategory : FnEnumGetter<org.bukkit.entity.SpawnCategory>() {

    override val enumClass: Class<org.bukkit.entity.SpawnCategory> = org.bukkit.entity.SpawnCategory::class.java
}
