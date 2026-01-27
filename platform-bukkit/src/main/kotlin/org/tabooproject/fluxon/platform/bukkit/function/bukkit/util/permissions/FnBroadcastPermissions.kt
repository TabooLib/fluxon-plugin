package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.util.permissions.BroadcastPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.util.permissions.BroadcastPermissions"])
@PlatformSide(Platform.BUKKIT)
object FnBroadcastPermissions {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BroadcastPermissions::class.java)
                // static
                .function(
                    "registerPermissions",
                    1
                ) { BroadcastPermissions.registerPermissions(it.getArgument(0) as Permission) }
        }
    }
}
