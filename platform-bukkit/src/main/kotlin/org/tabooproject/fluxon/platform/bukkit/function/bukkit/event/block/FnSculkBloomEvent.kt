package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.SculkBloomEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.SculkBloomEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSculkBloomEvent {

    val TYPE = Type.fromClass(SculkBloomEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkBloomEvent::class.java)
                .function("charge", returns(Type.I).noParams()) { it.setReturnRef(it.target?.charge) }
                .function("setCharge", returnsVoid().params(Type.I)) { it.target?.setCharge(it.getInt(0)) }
        }
    }
}
