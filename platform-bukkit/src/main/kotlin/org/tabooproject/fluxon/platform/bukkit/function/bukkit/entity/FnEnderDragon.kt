package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EnderDragon
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.EnderDragon"])
@PlatformSide(Platform.BUKKIT)
object FnEnderDragon {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderDragon::class.java)
                .function("phase", returnsObject().noParams()) { it.setReturnRef(it.target?.phase) }
                .function("setPhase", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPhase(it.getRef(0) as EnderDragon.Phase)) }
                .function("dragonBattle", returnsObject().noParams()) { it.setReturnRef(it.target?.dragonBattle) }
                .function("deathAnimationTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.deathAnimationTicks) }
        }
    }
}
