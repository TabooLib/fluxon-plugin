package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.platform.util.attacker
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.event.entity.EntityDamageByEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnEntityDamageByEntityEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityDamageByEntityEvent::class.java)
                .function("damager", 0) { it.target?.damager }
                .function("realDamager", 0) { it.target?.attacker } // 在发射弓箭的情况下也能获取到发射者
//                .function("isCritical", 0) { it.target?.isCritical }
        }
    }
}
