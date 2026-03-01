package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Vibration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Vibration"])
@PlatformSide(Platform.BUKKIT)
object FnVibration {

    val TYPE = Type.fromClass(Vibration::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration::class.java)
                .function("origin",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.origin) }
                .function("destination", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnVibrationDestination.TYPE).noParams()) { it.setReturnRef(it.target?.destination) }
                .function("arrivalTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.arrivalTime ?: 0) }
        }
    }
}

@Requires(classes = ["org.bukkit.Vibration\$Destination\$EntityDestination"])
@PlatformSide(Platform.BUKKIT)
object FnVibrationDestinationEntityDestination {

    val TYPE = Type.fromClass(Vibration.Destination.EntityDestination::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration.Destination.EntityDestination::class.java)
                .function("entity", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
        }
    }
}

@Requires(classes = ["org.bukkit.Vibration\$Destination\$BlockDestination"])
@PlatformSide(Platform.BUKKIT)
object FnVibrationDestinationBlockDestination {

    val TYPE = Type.fromClass(Vibration.Destination.BlockDestination::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vibration.Destination.BlockDestination::class.java)
                .function("location", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("block", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
        }
    }
}
