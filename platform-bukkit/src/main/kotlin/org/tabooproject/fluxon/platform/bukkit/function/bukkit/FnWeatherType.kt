package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import taboolib.common.Requires
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.WeatherType"])
@PlatformSide(Platform.BUKKIT)
object FnWeatherType : FnEnumGetter<org.bukkit.WeatherType>() {

    override val enumClass: Class<org.bukkit.WeatherType> = org.bukkit.WeatherType::class.java
}
