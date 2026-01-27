package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.PermissionDefault
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.permissions.PermissionDefault"])
@PlatformSide(Platform.BUKKIT)
object FnPermissionDefault {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PermissionDefault::class.java)
                .function("getValue", 1) { it.target?.getValue(it.getBoolean(0)) }
                // static
                .function("getByName", 1) { PermissionDefault.getByName(it.getString(0)!!) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
