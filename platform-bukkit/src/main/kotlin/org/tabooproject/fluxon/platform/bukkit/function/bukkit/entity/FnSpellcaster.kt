package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Spellcaster
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnSpellcaster {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Spellcaster::class.java)
                .function("spell", 0) { it.target?.spell }
                .function("setSpell", 1) { it.target?.setSpell(it.getArgument(0) as Spellcaster.Spell) }
        }
    }
}
