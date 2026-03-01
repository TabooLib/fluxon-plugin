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

    val TYPE = Type.fromClass(DataPack::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DataPack::class.java)
                .function("title", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.title) }
                .function("description", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.description) }
                .function("packFormat", returns(Type.I).noParams()) { it.setReturnInt(it.target?.packFormat ?: 0) }
                .function("minSupportedPackFormat", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minSupportedPackFormat ?: 0) }
                .function("maxSupportedPackFormat", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxSupportedPackFormat ?: 0) }
                .function("isEnabled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEnabled ?: false) }
                .function("isRequired", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRequired ?: false) }
                .function("compatibility", returns(FnDataPackCompatibility.TYPE).noParams()) { it.setReturnRef(it.target?.compatibility) }
                .function("requestedFeatures", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.requestedFeatures) }
                .function("source", returns(FnDataPackSource.TYPE).noParams()) { it.setReturnRef(it.target?.source) }
        }
    }
}
