package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.weather

import org.bukkit.event.weather.WeatherEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.weather.WeatherEvent"])
@PlatformSide(Platform.BUKKIT)
object FnWeatherEvent {

    val TYPE = Type.fromClass(WeatherEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(WeatherEvent::class.java)
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.getWorld()) }
        }
    }
}
