package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Vibration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Vibration"])
@PlatformSide(Platform.BUKKIT)
object FnVibration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration::class.java)
                .function("origin", returnsObject().noParams()) { it.target?.origin }
                .function("destination", returnsObject().noParams()) { it.target?.destination }
                .function("arrivalTime", returnsObject().noParams()) { it.target?.arrivalTime }
        }
    }
}

@Requires(classes = ["org.bukkit.Vibration.Destination.EntityDestination"])
@PlatformSide(Platform.BUKKIT)
object FnVibrationDestinationEntityDestination {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration.Destination.EntityDestination::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.entity }
        }
    }
}

@Requires(classes = ["org.bukkit.Vibration.Destination.BlockDestination"])
@PlatformSide(Platform.BUKKIT)
object FnVibrationDestinationBlockDestination {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration.Destination.BlockDestination::class.java)
                .function("location", returnsObject().noParams()) { it.target?.location }
                .function("block", returnsObject().noParams()) { it.target?.block }
        }
    }
}
