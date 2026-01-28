package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.PluginIdentifiableCommand
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.PluginIdentifiableCommand"])
@PlatformSide(Platform.BUKKIT)
object FnPluginIdentifiableCommand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginIdentifiableCommand::class.java)
                .function("plugin", returnsObject().noParams()) { it.target?.plugin }
        }
    }
}
