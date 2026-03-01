package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Spellcaster
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Spellcaster"])
@PlatformSide(Platform.BUKKIT)
object FnSpellcaster {

    val TYPE = Type.fromClass(Spellcaster::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Spellcaster::class.java)
                .function("spell", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpellcasterSpell.TYPE).noParams()) { it.setReturnRef(it.target?.spell) }
                .function("setSpell", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpellcasterSpell.TYPE)) { it.target?.setSpell(it.getRef(0) as Spellcaster.Spell)  }
                .function("setSpell", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpellcasterSpell.enumValue(it.getString(0))?.let { p0 -> it.target?.setSpell(p0)  } }
        }
    }
}
