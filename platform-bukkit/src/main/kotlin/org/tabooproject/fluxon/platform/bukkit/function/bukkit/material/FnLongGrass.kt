package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.GrassSpecies
import org.bukkit.material.LongGrass
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

@Requires(classes = ["org.bukkit.material.LongGrass"])
@PlatformSide(Platform.BUKKIT)
object FnLongGrass {

    val TYPE = Type.fromClass(LongGrass::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LongGrass::class.java)
                .function("species", returnsObject().noParams()) { it.setReturnRef(it.target?.species) }
                .function("setSpecies", returnsVoid().params(Type.OBJECT)) { it.target?.setSpecies(it.getRef(0) as GrassSpecies) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
