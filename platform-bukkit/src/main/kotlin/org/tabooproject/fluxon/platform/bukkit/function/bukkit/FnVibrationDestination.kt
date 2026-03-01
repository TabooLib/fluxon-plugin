package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.Vibration\$Destination"])
@PlatformSide(Platform.BUKKIT)
object FnVibrationDestination {

    val TYPE = Type.fromClass(org.bukkit.Vibration.Destination::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.Vibration.Destination::class.java)
                // static
        }
    }
}
