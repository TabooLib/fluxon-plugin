package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.SoundGroup
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.SoundGroup"])
@PlatformSide(Platform.BUKKIT)
object FnSoundGroup {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SoundGroup::class.java)
                .function("volume", returnsObject().noParams()) { it.setReturnRef(it.target?.volume) }
                .function("pitch", returnsObject().noParams()) { it.setReturnRef(it.target?.pitch) }
                .function("breakSound", returnsObject().noParams()) { it.setReturnRef(it.target?.breakSound) }
                .function("stepSound", returnsObject().noParams()) { it.setReturnRef(it.target?.stepSound) }
                .function("placeSound", returnsObject().noParams()) { it.setReturnRef(it.target?.placeSound) }
                .function("hitSound", returnsObject().noParams()) { it.setReturnRef(it.target?.hitSound) }
                .function("fallSound", returnsObject().noParams()) { it.setReturnRef(it.target?.fallSound) }
        }
    }
}
