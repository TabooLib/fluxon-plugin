package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Fireball
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Fireball"])
@PlatformSide(Platform.BUKKIT)
object FnFireball {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fireball::class.java)
                .function("setDirection", 1) { it.target?.setDirection(it.getArgument(0) as Vector) }
                .function("direction", 0) { it.target?.direction }
                .function("setAcceleration", 1) { it.target?.setAcceleration(it.getArgument(0) as Vector) }
                .function("acceleration", 0) { it.target?.acceleration }
        }
    }
}
