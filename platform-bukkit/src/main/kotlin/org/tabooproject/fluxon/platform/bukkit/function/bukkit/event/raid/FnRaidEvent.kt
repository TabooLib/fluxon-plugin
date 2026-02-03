package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.raid

import org.bukkit.event.raid.RaidEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnRaid
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.raid.RaidEvent"])
@PlatformSide(Platform.BUKKIT)
object FnRaidEvent {

    val TYPE = Type.fromClass(RaidEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RaidEvent::class.java)
                .function("raid", returns(FnRaid.TYPE).noParams()) { it.setReturnRef(it.target?.raid) }
        }
    }
}
