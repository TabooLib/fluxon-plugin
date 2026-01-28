package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.util.permissions.CommandPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject

@Requires(classes = ["org.bukkit.util.permissions.CommandPermissions"])
@PlatformSide(Platform.BUKKIT)
object FnCommandPermissions {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandPermissions::class.java)
                // static
                .function("registerPermissions", returnsObject().params(Type.OBJECT)) { CommandPermissions.registerPermissions(it.getRef(0) as Permission) }
        }
    }
}
