package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.bukkit.boss.DragonBattle
import org.bukkit.entity.EnderCrystal
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.boss.DragonBattle"])
@PlatformSide(Platform.BUKKIT)
object FnDragonBattle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DragonBattle::class.java)
                .function("enderDragon", returnsObject().noParams()) { it.target?.enderDragon }
                .function("bossBar", returnsObject().noParams()) { it.target?.bossBar }
                .function("endPortalLocation", returnsObject().noParams()) { it.target?.endPortalLocation }
                .function("generateEndPortal", returnsObject().params(Type.OBJECT)) { it.target?.generateEndPortal(it.getBool(0)) }
                .function("hasBeenPreviouslyKilled", returns(Type.Z).noParams()) { it.target?.hasBeenPreviouslyKilled() }
                .function("setPreviouslyKilled", returnsObject().params(Type.OBJECT)) { it.target?.setPreviouslyKilled(it.getBool(0)) }
                .function("initiateRespawn", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.initiateRespawn()
                    } else {
                        it.target?.initiateRespawn(it.getRef(0) as Collection<EnderCrystal>)
                    }
                }
                .function("initiateRespawn", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.initiateRespawn()
                    } else {
                        it.target?.initiateRespawn(it.getRef(0) as Collection<EnderCrystal>)
                    }
                }
                .function("respawnPhase", returnsObject().noParams()) { it.target?.respawnPhase }
                .function("setRespawnPhase", returnsObject().params(Type.OBJECT)) { it.target?.setRespawnPhase(it.getRef(0) as DragonBattle.RespawnPhase) }
                .function("resetCrystals", returnsObject().noParams()) { it.target?.resetCrystals() }
        }
    }
}
