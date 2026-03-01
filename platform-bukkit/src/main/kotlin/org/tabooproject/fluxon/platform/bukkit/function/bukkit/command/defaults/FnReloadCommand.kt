package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.defaults

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.defaults.ReloadCommand"])
@PlatformSide(Platform.BUKKIT)
object FnReloadCommand {

    val TYPE = Type.fromClass(org.bukkit.command.defaults.ReloadCommand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.command.defaults.ReloadCommand::class.java)
                // static
        }
    }
}
