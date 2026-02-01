package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.GlowSquid
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

@Requires(classes = ["org.bukkit.entity.GlowSquid"])
@PlatformSide(Platform.BUKKIT)
object FnGlowSquid {

    val TYPE = Type.fromClass(GlowSquid::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GlowSquid::class.java)
                .function("darkTicksRemaining", returns(Type.I).noParams()) { it.setReturnInt(it.target?.darkTicksRemaining ?: 0) }
                .function("setDarkTicksRemaining", returnsVoid().params(Type.I)) { it.target?.setDarkTicksRemaining(it.getInt(0).toInt()) }
        }
    }
}
