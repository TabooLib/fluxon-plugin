package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.SpectralArrow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.SpectralArrow"])
@PlatformSide(Platform.BUKKIT)
object FnSpectralArrow {

    val TYPE = Type.fromClass(SpectralArrow::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpectralArrow::class.java)
                .function("glowingTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.glowingTicks ?: 0) }
                .function("setGlowingTicks", returnsVoid().params(Type.I)) { it.target?.setGlowingTicks(it.getInt(0).toInt()) }
        }
    }
}
