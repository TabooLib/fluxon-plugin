package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Instrument
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Instrument"])
@PlatformSide(Platform.BUKKIT)
object FnInstrument {

    val TYPE = Type.fromClass(Instrument::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Instrument::class.java)
                .function("sound", returnsObject().noParams()) { it.setReturnRef(it.target?.sound) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                // static
                .function("getByType", returnsObject().params(Type.I)) { it.setReturnRef(Instrument.getByType(it.getInt(0).toByte())) }
        }
    }
}
