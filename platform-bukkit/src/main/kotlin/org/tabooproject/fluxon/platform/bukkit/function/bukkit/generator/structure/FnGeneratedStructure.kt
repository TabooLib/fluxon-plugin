package org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure

import org.bukkit.generator.structure.GeneratedStructure
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.generator.structure.GeneratedStructure"])
@PlatformSide(Platform.BUKKIT)
object FnGeneratedStructure {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GeneratedStructure::class.java)
                .function("boundingBox", returnsObject().noParams()) { it.target?.boundingBox }
                .function("structure", returnsObject().noParams()) { it.target?.structure }
                .function("pieces", returnsObject().noParams()) { it.target?.pieces }
        }
    }
}
