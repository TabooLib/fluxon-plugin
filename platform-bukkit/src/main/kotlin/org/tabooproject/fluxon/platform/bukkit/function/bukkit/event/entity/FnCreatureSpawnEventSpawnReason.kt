package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.CreatureSpawnEvent\$SpawnReason"])
@PlatformSide(Platform.BUKKIT)
object FnCreatureSpawnEventSpawnReason : FnEnumGetter<org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason>() {

    override val enumClass: Class<org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason> = org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason::class.java
}
