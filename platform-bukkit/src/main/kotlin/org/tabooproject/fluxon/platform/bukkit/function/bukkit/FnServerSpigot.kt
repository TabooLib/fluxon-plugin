package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Server
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Server\$Spigot"])
@PlatformSide(Platform.BUKKIT)
object FnServerSpigot {

    val TYPE = Type.fromClass(Server.Spigot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.Server.Spigot::class.java)
                // static
        }
    }
}
