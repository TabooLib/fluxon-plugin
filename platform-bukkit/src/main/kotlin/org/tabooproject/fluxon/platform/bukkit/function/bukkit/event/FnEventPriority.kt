package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event

import org.bukkit.event.EventPriority
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.EventPriority"])
@PlatformSide(Platform.BUKKIT)
object FnEventPriority : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.event.EventPriority>() {

    override val enumClass: Class<org.bukkit.event.EventPriority> = org.bukkit.event.EventPriority::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EventPriority::class.java)
                .function("slot", returns(Type.I).noParams()) { it.setReturnInt(it.target?.slot ?: 0) }
        }
    }
}
