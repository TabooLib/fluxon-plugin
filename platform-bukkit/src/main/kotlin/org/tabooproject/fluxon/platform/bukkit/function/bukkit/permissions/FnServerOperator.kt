package org.tabooproject.fluxon.platform.bukkit.function.bukkit.permissions

import org.bukkit.permissions.ServerOperator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.permissions.ServerOperator"])
@PlatformSide(Platform.BUKKIT)
object FnServerOperator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerOperator::class.java)
                .function("isOp", 0) { it.target?.isOp }
                .function("setOp", 1) { it.target?.setOp(it.getBoolean(0)) }
        }
    }
}
