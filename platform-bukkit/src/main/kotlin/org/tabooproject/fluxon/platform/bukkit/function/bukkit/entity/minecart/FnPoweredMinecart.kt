package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.PoweredMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.minecart.PoweredMinecart"])
@PlatformSide(Platform.BUKKIT)
object FnPoweredMinecart {

    val TYPE = Type.fromClass(PoweredMinecart::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PoweredMinecart::class.java)
                .function("fuel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fuel ?: 0) }
                .function("setFuel", returnsVoid().params(Type.I)) { it.target?.setFuel(it.getInt(0).toInt()) }
        }
    }
}
