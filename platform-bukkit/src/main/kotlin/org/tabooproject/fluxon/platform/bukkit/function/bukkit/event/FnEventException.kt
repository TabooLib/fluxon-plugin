package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.EventException
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.EventException"])
@PlatformSide(Platform.BUKKIT)
object FnEventException {

    val TYPE = Type.fromClass(EventException::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EventException::class.java)
                .function("cause", returns(Type.fromClass(Throwable::class.java)).noParams()) { it.setReturnRef(it.target?.cause) }
        }
    }
}
