package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EnderDragon
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.EnderDragon"])
@PlatformSide(Platform.BUKKIT)
object FnEnderDragon {

    val TYPE = Type.fromClass(EnderDragon::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderDragon::class.java)
                .function("phase", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEnderDragonPhase.TYPE).noParams()) { it.setReturnRef(it.target?.phase) }
                .function("setPhase", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEnderDragonPhase.TYPE)) { it.target?.setPhase(it.getRef(0) as EnderDragon.Phase)  }
                .function("setPhase", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEnderDragonPhase.enumValue(it.getString(0))?.let { p0 -> it.target?.setPhase(p0)  } }
                .function("dragonBattle",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnDragonBattle.TYPE).noParams()) { it.setReturnRef(it.target?.dragonBattle) }
                .function("deathAnimationTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.deathAnimationTicks ?: 0) }
        }
    }
}
