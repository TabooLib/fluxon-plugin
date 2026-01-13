package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractArrow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnAbstractArrow {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractArrow::class.java)
                // 只读属性
                .function("isInBlock", 0) { it.target?.isInBlock }
                .function("attachedBlock", 0) { it.target?.let { arrow -> if (arrow.isInBlock) arrow.attachedBlock else null } }
                .function("isCanPickup", 0) { it.target?.pickupStatus == AbstractArrow.PickupStatus.ALLOWED }
                .function("isCannotPickup", 0) { it.target?.pickupStatus == AbstractArrow.PickupStatus.DISALLOWED }
                .function("isCreativeOnlyPickup", 0) { it.target?.pickupStatus == AbstractArrow.PickupStatus.CREATIVE_ONLY }

                // 可读写属性
                .function("knockbackStrength", 0) { it.target?.knockbackStrength }
                .syncFunction("setKnockbackStrength", 1) { it.target?.apply { knockbackStrength = it.getNumber(0).toInt() } }
                .function("damage", 0) { it.target?.damage }
                .syncFunction("setDamage", 1) { it.target?.apply { damage = it.getNumber(0).toDouble() } }
                .function("pierceLevel", 0) { it.target?.pierceLevel }
                .syncFunction("setPierceLevel", 1) { it.target?.apply { pierceLevel = it.getNumber(0).toInt() } }
                .function("isCritical", 0) { it.target?.isCritical }
                .syncFunction("setCritical", 1) { it.target?.apply { isCritical = it.getBoolean(0) } }
                .function("isShotFromCrossbow", 0) { it.target?.isShotFromCrossbow }
                .syncFunction("setShotFromCrossbow", 1) { it.target?.apply { isShotFromCrossbow = it.getBoolean(0) } }
        }
    }
}
