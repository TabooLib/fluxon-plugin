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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.MusicInstrumentMeta"])
@PlatformSide(Platform.BUKKIT)
object FnMusicInstrumentMeta {

    val TYPE = Type.fromClass(MusicInstrumentMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MusicInstrumentMeta::class.java)
                .function("setInstrument",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMusicInstrument.TYPE)) { it.target?.setInstrument(it.getRef(0) as MusicInstrument) }
                .function("instrument",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMusicInstrument.TYPE).noParams()) { it.setReturnRef(it.target?.instrument) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnMusicInstrumentMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
