package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.EnderDragon\$Phase"])
@PlatformSide(Platform.BUKKIT)
object FnEnderDragonPhase : FnEnumGetter<org.bukkit.entity.EnderDragon.Phase>() {

    override val enumClass: Class<org.bukkit.entity.EnderDragon.Phase> = org.bukkit.entity.EnderDragon.Phase::class.java
}
