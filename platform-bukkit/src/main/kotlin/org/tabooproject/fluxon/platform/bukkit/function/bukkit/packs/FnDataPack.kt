package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.packs.DataPack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.packs.DataPack"])
@PlatformSide(Platform.BUKKIT)
object FnDataPack {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DataPack::class.java)
                .function("title", returnsObject().noParams()) { it.setReturnRef(it.target?.title) }
                .function("description", returnsObject().noParams()) { it.setReturnRef(it.target?.description) }
                .function("packFormat", returnsObject().noParams()) { it.setReturnRef(it.target?.packFormat) }
                .function("minSupportedPackFormat", returnsObject().noParams()) { it.setReturnRef(it.target?.minSupportedPackFormat) }
                .function("maxSupportedPackFormat", returnsObject().noParams()) { it.setReturnRef(it.target?.maxSupportedPackFormat) }
                .function("isEnabled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isEnabled) }
                .function("isRequired", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isRequired) }
                .function("compatibility", returnsObject().noParams()) { it.setReturnRef(it.target?.compatibility) }
                .function("requestedFeatures", returnsObject().noParams()) { it.setReturnRef(it.target?.requestedFeatures) }
                .function("source", returnsObject().noParams()) { it.setReturnRef(it.target?.source) }
        }
    }
}
