package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Instrument
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Instrument"])
@PlatformSide(Platform.BUKKIT)
object FnInstrument : FnEnumGetter<Instrument>() {

    override val enumClass: Class<Instrument> = Instrument::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Instrument::class.java)
                .function("sound", returns(FnSound.TYPE).noParams()) { it.setReturnRef(it.target?.sound) }
                .function("type", returns(Type.I).noParams()) { it.setReturnRef(it.target?.type) }
        }
    }
}
