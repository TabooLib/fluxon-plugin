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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.generator.structure.GeneratedStructure"])
@PlatformSide(Platform.BUKKIT)
object FnGeneratedStructure {

    val TYPE = Type.fromClass(GeneratedStructure::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GeneratedStructure::class.java)
                .function("boundingBox",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).noParams()) { it.setReturnRef(it.target?.boundingBox) }
                .function("structure",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.structure.FnStructure.TYPE).noParams()) { it.setReturnRef(it.target?.structure) }
                .function("pieces",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.pieces) }
        }
    }
}
