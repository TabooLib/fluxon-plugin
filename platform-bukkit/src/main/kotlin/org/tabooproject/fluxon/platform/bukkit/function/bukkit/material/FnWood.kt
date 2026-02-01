package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.TreeSpecies
import org.bukkit.material.Wood
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

@Requires(classes = ["org.bukkit.material.Wood"])
@PlatformSide(Platform.BUKKIT)
object FnWood {

    val TYPE = Type.fromClass(Wood::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wood::class.java)
                .function("species", returnsObject().noParams()) { it.setReturnRef(it.target?.species) }
                .function("setSpecies", returnsVoid().params(Type.OBJECT)) { it.target?.setSpecies(it.getRef(0) as TreeSpecies) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
