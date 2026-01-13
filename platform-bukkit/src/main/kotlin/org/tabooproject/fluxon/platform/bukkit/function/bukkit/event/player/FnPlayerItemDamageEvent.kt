package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerItemDamageEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnPlayerItemDamageEvent {

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerItemDamageEvent::class.java)
                .function("item", 0) { it.target?.item }
                .function("damage", 0) { it.target?.damage }
                .syncFunction("setDamage", 1) { it.target?.apply { damage = it.getNumber(0).toInt() } }
        }
    }
}
