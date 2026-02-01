package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.HopperMinecart
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

@Requires(classes = ["org.bukkit.entity.minecart.HopperMinecart"])
@PlatformSide(Platform.BUKKIT)
object FnHopperMinecart {

    val TYPE = Type.fromClass(HopperMinecart::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(HopperMinecart::class.java)
                .function("isEnabled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEnabled ?: false) }
                .function("setEnabled", returnsVoid().params(Type.Z)) { it.target?.setEnabled(it.getBool(0)) }
        }
    }
}
