package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.boss.DragonBattle\$RespawnPhase"])
@PlatformSide(Platform.BUKKIT)
object FnDragonBattleRespawnPhase : FnEnumGetter<org.bukkit.boss.DragonBattle.RespawnPhase>() {

    override val enumClass: Class<org.bukkit.boss.DragonBattle.RespawnPhase> = org.bukkit.boss.DragonBattle.RespawnPhase::class.java
}
