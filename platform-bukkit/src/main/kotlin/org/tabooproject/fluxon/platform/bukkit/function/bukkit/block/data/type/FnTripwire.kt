package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Tripwire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.Tripwire"])
@PlatformSide(Platform.BUKKIT)
object FnTripwire {

    val TYPE = Type.fromClass(Tripwire::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Tripwire::class.java)
                .function("isDisarmed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDisarmed ?: false) }
                .function("setDisarmed", returnsVoid().params(Type.Z)) { it.target?.setDisarmed(it.getBool(0)) }
        }
    }
}
