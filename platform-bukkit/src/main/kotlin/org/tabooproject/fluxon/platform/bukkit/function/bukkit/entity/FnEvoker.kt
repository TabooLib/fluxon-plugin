package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Evoker
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

@Requires(classes = ["org.bukkit.entity.Evoker"])
@PlatformSide(Platform.BUKKIT)
object FnEvoker {

    val TYPE = Type.fromClass(Evoker::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Evoker::class.java)
                .function("currentSpell", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnSpellcasterSpell.TYPE).noParams()) { it.setReturnRef(it.target?.currentSpell) }
                .function("setCurrentSpell", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEvokerSpell.TYPE)) { it.target?.setCurrentSpell(it.getRef(0) as Evoker.Spell)  }
                .function("setCurrentSpell", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEvokerSpell.enumValue(it.getString(0))?.let { p0 -> it.target?.setCurrentSpell(p0)  } }
        }
    }
}
