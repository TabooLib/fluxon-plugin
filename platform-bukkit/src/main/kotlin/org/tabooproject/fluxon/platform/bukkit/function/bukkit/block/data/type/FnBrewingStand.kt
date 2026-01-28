package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.BrewingStand
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.BrewingStand"])
@PlatformSide(Platform.BUKKIT)
object FnBrewingStand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BrewingStand::class.java)
                .function("hasBottle", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasBottle(it.getInt(0).toInt()) }
                .function("setBottle", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setBottle(it.getInt(0).toInt(), it.getBool(1)) }
                .function("bottles", returnsObject().noParams()) { it.target?.bottles }
                .function("maximumBottles", returnsObject().noParams()) { it.target?.maximumBottles }
        }
    }
}
