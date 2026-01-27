package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Endermite
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Endermite"])
@PlatformSide(Platform.BUKKIT)
object FnEndermite {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Endermite::class.java)
                .function("isPlayerSpawned", 0) { it.target?.isPlayerSpawned }
                .function("setPlayerSpawned", 1) { it.target?.setPlayerSpawned(it.getBoolean(0)) }
        }
    }
}
