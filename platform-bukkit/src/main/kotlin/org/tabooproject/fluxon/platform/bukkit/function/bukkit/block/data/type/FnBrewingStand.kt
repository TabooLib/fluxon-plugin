package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BrewingStand
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.block.data.type.BrewingStand"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStand {

    val TYPE = Type.fromClass(BrewingStand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStand::class.java)
                .function("hasBottle", returns(Type.Z).params(Type.I)) { it.setReturnBool(it.target?.hasBottle(it.getInt(0)) ?: false) }
                .function("setBottle", returnsVoid().params(Type.I, Type.Z)) { it.target?.setBottle(it.getInt(0), it.getBool(1)) }
                .function("bottles", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.bottles) }
                .function("maximumBottles", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumBottles ?: 0) }
        }
    }
}
