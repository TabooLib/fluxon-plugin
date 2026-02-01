package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.CropState
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.CropState"])
@PlatformSide(Platform.BUKKIT)
object FnCropState {

    val TYPE = Type.fromClass(CropState::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CropState::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnInt(it.target?.data?.toInt() ?: 0) }
                // static
                .function("getByData", returnsObject().params(Type.I)) { it.setReturnRef(CropState.getByData(it.getInt(0).toByte())) }
        }
    }
}
