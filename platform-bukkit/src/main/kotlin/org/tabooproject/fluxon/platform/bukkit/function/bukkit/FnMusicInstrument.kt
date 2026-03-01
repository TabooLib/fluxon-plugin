package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.MusicInstrument
import org.bukkit.NamespacedKey
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.MusicInstrument"])
@PlatformSide(Platform.BUKKIT)
object FnMusicInstrument {

    val TYPE = Type.fromClass(MusicInstrument::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MusicInstrument::class.java)
                // static
                .function("getByKey", returns(TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.setReturnRef(MusicInstrument.getByKey(it.getRef(0) as NamespacedKey)) }
                // static
                .function("values", returns(Type.fromClass(Array<MusicInstrument>::class.java)).noParams()) { it.setReturnRef(MusicInstrument.values()) }
        }
    }
}
