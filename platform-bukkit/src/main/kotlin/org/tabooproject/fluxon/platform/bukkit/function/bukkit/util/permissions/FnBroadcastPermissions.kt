package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.permissions

import org.bukkit.permissions.Permission
import org.bukkit.util.permissions.BroadcastPermissions
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.permissions.BroadcastPermissions"])
@PlatformSide(Platform.BUKKIT)
object FnBroadcastPermissions {

    val TYPE = Type.fromClass(BroadcastPermissions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BroadcastPermissions::class.java)
                // static
                .function("registerPermissions",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions.FnPermission.TYPE)) { it.setReturnRef(BroadcastPermissions.registerPermissions(it.getRef(0) as Permission)) }
        }
    }
}
