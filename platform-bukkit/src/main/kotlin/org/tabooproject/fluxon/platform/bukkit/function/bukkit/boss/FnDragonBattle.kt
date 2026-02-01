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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.boss.DragonBattle"])
@PlatformSide(Platform.BUKKIT)
object FnDragonBattle {

    val TYPE = Type.fromClass(DragonBattle::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DragonBattle::class.java)
                .function("enderDragon", returnsObject().noParams()) { it.setReturnRef(it.target?.enderDragon) }
                .function("bossBar", returnsObject().noParams()) { it.setReturnRef(it.target?.bossBar) }
                .function("endPortalLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.endPortalLocation) }
                .function("generateEndPortal", returnsVoid().params(Type.Z)) { it.target?.generateEndPortal(it.getBool(0)) }
                .function("hasBeenPreviouslyKilled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBeenPreviouslyKilled() ?: false) }
                .function("setPreviouslyKilled", returnsVoid().params(Type.Z)) { it.target?.setPreviouslyKilled(it.getBool(0)) }
                .function("initiateRespawn", returnsVoid().noParams()) { it.target?.initiateRespawn() }
                .function("initiateRespawn", returnsVoid().params(Type.OBJECT)) {
                    it.target?.initiateRespawn(it.getRef(0) as Collection<EnderCrystal>)
                }
                .function("respawnPhase", returnsObject().noParams()) { it.setReturnRef(it.target?.respawnPhase) }
                .function("setRespawnPhase", returnsVoid().params(Type.OBJECT)) { it.target?.setRespawnPhase(it.getRef(0) as DragonBattle.RespawnPhase) }
                .function("resetCrystals", returnsVoid().noParams()) { it.target?.resetCrystals() }
        }
    }
}
