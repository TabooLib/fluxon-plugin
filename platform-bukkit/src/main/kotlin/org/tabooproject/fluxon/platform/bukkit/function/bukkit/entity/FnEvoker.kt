package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Evoker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEvoker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Evoker::class.java)
                .function("currentSpell", 0) { it.target?.currentSpell }
                .function("setCurrentSpell", 1) { it.target?.setCurrentSpell(it.getArgument(0) as Evoker.Spell) }
        }
    }
}
