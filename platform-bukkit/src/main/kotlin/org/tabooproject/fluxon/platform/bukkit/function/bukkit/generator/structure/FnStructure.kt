package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure

import org.bukkit.generator.structure.Structure
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.generator.structure.Structure"])
@PlatformSide(Platform.BUKKIT)
object FnStructure {

    val TYPE = Type.fromClass(Structure::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Structure::class.java)
                .function("structureType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructureType.TYPE).noParams()) { it.setReturnRef(it.target?.structureType) }
        }
    }
}
