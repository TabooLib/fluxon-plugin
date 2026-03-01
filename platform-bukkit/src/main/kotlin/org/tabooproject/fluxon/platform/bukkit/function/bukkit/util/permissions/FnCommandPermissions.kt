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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.permissions.CommandPermissions"])
@PlatformSide(Platform.BUKKIT)
object FnCommandPermissions {

    val TYPE = Type.fromClass(CommandPermissions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandPermissions::class.java)
                // static
                .function("registerPermissions",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnRef(CommandPermissions.registerPermissions(it.getRef(0) as Permission)) }
        }
    }
}
