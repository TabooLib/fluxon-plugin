package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidFinishEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.raid.RaidFinishEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidFinishEvent {

    val TYPE = Type.fromClass(RaidFinishEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidFinishEvent::class.java)
                .function("winners", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.winners) }
        }
    }
}
