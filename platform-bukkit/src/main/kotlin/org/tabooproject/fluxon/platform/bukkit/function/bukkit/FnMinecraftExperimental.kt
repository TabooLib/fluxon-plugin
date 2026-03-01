package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.MinecraftExperimental"])
@PlatformSide(Platform.BUKKIT)
object FnMinecraftExperimental {

    val TYPE = Type.fromClass(org.bukkit.MinecraftExperimental::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.MinecraftExperimental::class.java)
                // static
        }
    }
}
