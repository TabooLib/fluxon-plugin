package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lockable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnLockable {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lockable::class.java)
                .function("isLocked", 0) { it.target?.isLocked }
                .function("lock", 0) { it.target?.lock }
                .function("setLock", 1) { it.target?.setLock(it.getString(0)) }
        }
    }
}
