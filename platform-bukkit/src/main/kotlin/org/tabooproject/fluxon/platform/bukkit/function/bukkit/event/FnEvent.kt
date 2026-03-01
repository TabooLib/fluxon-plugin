package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.Event
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@Requires(classes = ["org.bukkit.event.Event"])
@PlatformSide(Platform.BUKKIT)
object FnEvent {

    val TYPE = Type.fromClass(Event::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Event::class.java)
                .function("eventName",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.eventName) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                .function("isAsynchronous", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAsynchronous ?: false) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.Event\$Result"])
@PlatformSide(Platform.BUKKIT)
object FnEventResult : FnEnumGetter<Event.Result>() {

    override val enumClass: Class<Event.Result> = Event.Result::class.java
}
