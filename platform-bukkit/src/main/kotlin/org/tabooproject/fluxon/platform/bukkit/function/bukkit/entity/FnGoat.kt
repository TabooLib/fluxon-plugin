package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Goat
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnGoat {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Goat::class.java)
                .function("hasLeftHorn", 0) { it.target?.hasLeftHorn() }
                .function("setLeftHorn", 1) { it.target?.setLeftHorn(it.getBoolean(0)) }
                .function("hasRightHorn", 0) { it.target?.hasRightHorn() }
                .function("setRightHorn", 1) { it.target?.setRightHorn(it.getBoolean(0)) }
                .function("isScreaming", 0) { it.target?.isScreaming }
                .function("setScreaming", 1) { it.target?.setScreaming(it.getBoolean(0)) }
        }
    }
}
