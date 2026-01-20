package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.bukkit.event.weather.WeatherEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWeatherEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WeatherEvent::class.java)
                .function("world", 0) { it.target?.getWorld() }
        }
    }
}
