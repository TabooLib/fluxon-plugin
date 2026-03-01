package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.entity.VillagerCareerChangeEvent\$ChangeReason"])
@PlatformSide(Platform.BUKKIT)
object FnVillagerCareerChangeEventChangeReason : FnEnumGetter<org.bukkit.event.entity.VillagerCareerChangeEvent.ChangeReason>() {

    override val enumClass: Class<org.bukkit.event.entity.VillagerCareerChangeEvent.ChangeReason> = org.bukkit.event.entity.VillagerCareerChangeEvent.ChangeReason::class.java
}
