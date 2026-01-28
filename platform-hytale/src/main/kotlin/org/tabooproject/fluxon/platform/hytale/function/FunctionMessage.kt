package org.tabooproject.fluxon.platform.hytale.function

import com.hypixel.hytale.server.core.Message
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.HYTALE)
object FunctionMessage {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("raw", returnsObject().params(Type.STRING)) { it.setReturnRef(Message.raw(it.getString(0)!!)) }
        }
    }
}