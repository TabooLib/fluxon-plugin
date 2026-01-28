package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.GlowSquid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.GlowSquid"])
@PlatformSide(Platform.BUKKIT)
object FnGlowSquid {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GlowSquid::class.java)
                .function("darkTicksRemaining", returnsObject().noParams()) { it.target?.darkTicksRemaining }
                .function("setDarkTicksRemaining", returnsObject().params(Type.OBJECT)) { it.target?.setDarkTicksRemaining(it.getInt(0).toInt()) }
        }
    }
}
