package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.bukkit.event.weather.WeatherChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnWeatherChangeEvent {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WeatherChangeEvent::class.java)
                .function("isCancelled", 0) { it.target?.isCancelled }
                .function("setCancelled", 1) { it.target?.setCancelled(it.getBoolean(0)) }
                .function("toWeatherState", 0) { it.target?.toWeatherState() }
                .function("handlers", 0) { it.target?.handlers }
                // static
                .function("handlerList", 0) { WeatherChangeEvent.getHandlerList() }
        }
    }
}
