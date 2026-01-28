package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractArrow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.AbstractArrow"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractArrow {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractArrow::class.java)
                .function("attachedBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.let { arrow -> if (arrow.isInBlock) arrow.attachedBlock else null }) }
                .function("isCanPickup", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.pickupStatus == AbstractArrow.PickupStatus.ALLOWED) }
                .function("isCannotPickup", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.pickupStatus == AbstractArrow.PickupStatus.DISALLOWED) }
                .function("isCreativeOnlyPickup", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.pickupStatus == AbstractArrow.PickupStatus.CREATIVE_ONLY) }
                .function("knockbackStrength", returnsObject().noParams()) { it.setReturnRef(it.target?.knockbackStrength) }
                .function("setKnockbackStrength", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setKnockbackStrength(it.getInt(0).toInt())) }
                .function("damage", returnsObject().noParams()) { it.setReturnRef(it.target?.damage) }
                .function("setDamage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDamage(it.getAsDouble(0))) }
                .function("pierceLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.pierceLevel) }
                .function("setPierceLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPierceLevel(it.getInt(0).toInt())) }
                .function("isCritical", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isCritical) }
                .function("setCritical", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCritical(it.getBool(0))) }
                .function("isInBlock", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isInBlock) }
                .function("attachedBlock", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedBlock) }
                .function("pickupStatus", returnsObject().noParams()) { it.setReturnRef(it.target?.pickupStatus) }
                .function("setPickupStatus", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPickupStatus(it.getRef(0) as AbstractArrow.PickupStatus)) }
                .function("isShotFromCrossbow", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isShotFromCrossbow) }
                .function("setShotFromCrossbow", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShotFromCrossbow(it.getBool(0))) }
        }
    }
}
