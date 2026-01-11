package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractArrow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAbstractArrow {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractArrow::class.java)
                .function("knockbackStrength", 0) { it.target?.knockbackStrength }
                .function("setKnockbackStrength", 1) { it.target?.setKnockbackStrength(it.getNumber(0).toInt()) }
                .function("damage", 0) { it.target?.damage }
                .function("setDamage", 1) { it.target?.setDamage(it.getNumber(0).toDouble()) }
                .function("pierceLevel", 0) { it.target?.pierceLevel }
                .function("setPierceLevel", 1) { it.target?.setPierceLevel(it.getNumber(0).toInt()) }
                .function("isCritical", 0) { it.target?.isCritical }
                .function("setCritical", 1) { it.target?.setCritical(it.getBoolean(0)) }
                .function("isInBlock", 0) { it.target?.isInBlock }
                .function("attachedBlock", 0) { it.target?.attachedBlock }
                .function("pickupStatus", 0) { it.target?.pickupStatus }
                .function(
                    "setPickupStatus",
                    1
                ) { it.target?.setPickupStatus(it.getArgument(0) as AbstractArrow.PickupStatus) }
                .function("isShotFromCrossbow", 0) { it.target?.isShotFromCrossbow }
                .function("setShotFromCrossbow", 1) { it.target?.setShotFromCrossbow(it.getBoolean(0)) }
        }
    }
}
