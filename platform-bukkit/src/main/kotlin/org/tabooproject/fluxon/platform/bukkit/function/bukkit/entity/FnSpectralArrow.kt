package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SpectralArrow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.SpectralArrow"])
@PlatformSide(Platform.BUKKIT)
object FnSpectralArrow {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpectralArrow::class.java)
                .function("glowingTicks", returnsObject().noParams()) { it.target?.glowingTicks }
                .function("setGlowingTicks", returnsObject().params(Type.OBJECT)) { it.target?.setGlowingTicks(it.getInt(0).toInt()) }
        }
    }
}
