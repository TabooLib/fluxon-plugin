package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.util.permissions.CommandPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCommandPermissions {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandPermissions::class.java)
                // static
                .function(
                    "registerPermissions",
                    1
                ) { CommandPermissions.registerPermissions(it.getArgument(0) as Permission) }
        }
    }
}
