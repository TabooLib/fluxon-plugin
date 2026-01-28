package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.MusicInstrument
import org.bukkit.inventory.meta.MusicInstrumentMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.meta.MusicInstrumentMeta"])
@PlatformSide(Platform.BUKKIT)
object FnMusicInstrumentMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MusicInstrumentMeta::class.java)
                .function("setInstrument", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setInstrument(it.getRef(0) as MusicInstrument)) }
                .function("instrument", returnsObject().noParams()) { it.setReturnRef(it.target?.instrument) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
