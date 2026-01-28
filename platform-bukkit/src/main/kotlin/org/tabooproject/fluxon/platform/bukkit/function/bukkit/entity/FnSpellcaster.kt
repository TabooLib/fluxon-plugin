package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Spellcaster
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Spellcaster"])
@PlatformSide(Platform.BUKKIT)
object FnSpellcaster {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Spellcaster::class.java)
                .function("spell", returnsObject().noParams()) { it.setReturnRef(it.target?.spell) }
                .function("setSpell", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpell(it.getRef(0) as Spellcaster.Spell)) }
        }
    }
}
