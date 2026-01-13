package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.permissions.ServerOperator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnServerOperator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerOperator::class.java)
                // OP 权限
                .function("isOp", 0) { it.target?.isOp }
                .syncFunction("setOp", 1) { it.target?.apply { isOp = it.getBoolean(0) } }
        }
    }
}
