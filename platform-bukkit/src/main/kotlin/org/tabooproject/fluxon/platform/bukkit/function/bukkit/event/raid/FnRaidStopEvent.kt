package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidStopEvent
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.raid.RaidStopEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidStopEvent {

    val TYPE = Type.fromClass(RaidStopEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidStopEvent::class.java)
                .function("reason", returns(FnRaidStopEventReason.TYPE).noParams()) { it.setReturnRef(it.target?.reason) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.raid.RaidStopEvent.Reason"])
@PlatformSide(Platform.BUKKIT)
object FnRaidStopEventReason : FnEnumGetter<RaidStopEvent.Reason>() {

    override val enumClass: Class<RaidStopEvent.Reason> = RaidStopEvent.Reason::class.java
}
