package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Evoker
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Evoker"])
@PlatformSide(Platform.BUKKIT)
object FnEvoker {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Evoker::class.java)
                .function("currentSpell", returnsObject().noParams()) { it.target?.currentSpell }
                .function("setCurrentSpell", returnsObject().params(Type.OBJECT)) { it.target?.setCurrentSpell(it.getRef(0) as Evoker.Spell) }
        }
    }
}
