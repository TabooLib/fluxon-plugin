package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidTriggerEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.raid.RaidTriggerEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidTriggerEvent {

    val TYPE = Type.fromClass(RaidTriggerEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidTriggerEvent::class.java)
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
        }
    }
}
