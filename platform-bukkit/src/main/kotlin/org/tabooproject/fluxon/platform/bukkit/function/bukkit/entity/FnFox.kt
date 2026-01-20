package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Fox
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFox {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fox::class.java)
                .function("foxType", 0) { it.target?.foxType }
                .function("setFoxType", 1) { it.target?.setFoxType(it.getArgument(0) as Fox.Type) }
                .function("isCrouching", 0) { it.target?.isCrouching }
                .function("setCrouching", 1) { it.target?.setCrouching(it.getBoolean(0)) }
                .function("setSleeping", 1) { it.target?.setSleeping(it.getBoolean(0)) }
                .function("firstTrustedPlayer", 0) { it.target?.firstTrustedPlayer }
                .function(
                    "setFirstTrustedPlayer",
                    1
                ) { it.target?.setFirstTrustedPlayer(it.getArgument(0) as AnimalTamer) }
                .function("secondTrustedPlayer", 0) { it.target?.secondTrustedPlayer }
                .function(
                    "setSecondTrustedPlayer",
                    1
                ) { it.target?.setSecondTrustedPlayer(it.getArgument(0) as AnimalTamer) }
                .function("isFaceplanted", 0) { it.target?.isFaceplanted }
        }
    }
}
