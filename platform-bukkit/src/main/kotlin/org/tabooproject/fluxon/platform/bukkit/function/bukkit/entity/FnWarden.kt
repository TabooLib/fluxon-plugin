package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.Warden
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWarden {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Warden::class.java)
                .function("anger", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.anger
                    } else {
                        it.target?.getAnger(it.getArgument(0) as Entity)
                    }
                }
                .function("increaseAnger", 2) {
                    it.target?.increaseAnger(
                        it.getArgument(0) as Entity,
                        it.getNumber(1).toInt()
                    )
                }
                .function("setAnger", 2) { it.target?.setAnger(it.getArgument(0) as Entity, it.getNumber(1).toInt()) }
                .function("clearAnger", 1) { it.target?.clearAnger(it.getArgument(0) as Entity) }
                .function("entityAngryAt", 0) { it.target?.entityAngryAt }
                .function(
                    "setDisturbanceLocation",
                    1
                ) { it.target?.setDisturbanceLocation(it.getArgument(0) as Location) }
                .function("angerLevel", 0) { it.target?.angerLevel }
        }
    }
}
