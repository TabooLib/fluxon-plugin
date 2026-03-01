package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractArrow
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.AbstractArrow"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractArrow {

    val TYPE = Type.fromClass(AbstractArrow::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractArrow::class.java)
                .function("attachedBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.let { arrow -> if (arrow.isInBlock) arrow.attachedBlock else null }) }
                .function("isCanPickup", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.pickupStatus == AbstractArrow.PickupStatus.ALLOWED) }
                .function("isCannotPickup", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.pickupStatus == AbstractArrow.PickupStatus.DISALLOWED) }
                .function("isCreativeOnlyPickup", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.pickupStatus == AbstractArrow.PickupStatus.CREATIVE_ONLY) }
                .function("knockbackStrength", returns(Type.I).noParams()) { it.setReturnInt(it.target?.knockbackStrength ?: 0) }
                .function("setKnockbackStrength", returnsVoid().params(Type.I)) { it.target?.setKnockbackStrength(it.getInt(0)) }
                .function("damage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.damage ?: 0.0) }
                .function("setDamage", returnsVoid().params(Type.D)) { it.target?.setDamage(it.getDouble(0)) }
                .function("pierceLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.pierceLevel ?: 0) }
                .function("setPierceLevel", returnsVoid().params(Type.I)) { it.target?.setPierceLevel(it.getInt(0)) }
                .function("isCritical", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCritical ?: false) }
                .function("setCritical", returnsVoid().params(Type.Z)) { it.target?.setCritical(it.getBool(0)) }
                .function("isInBlock", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInBlock ?: false) }
                .function("attachedBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.attachedBlock) }
                .function("pickupStatus", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAbstractArrowPickupStatus.TYPE).noParams()) { it.setReturnRef(it.target?.pickupStatus) }
                .function("setPickupStatus", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAbstractArrowPickupStatus.TYPE)) { it.target?.setPickupStatus(it.getRef(0) as AbstractArrow.PickupStatus)  }
                .function("setPickupStatus", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAbstractArrowPickupStatus.enumValue(it.getString(0))?.let { p0 -> it.target?.setPickupStatus(p0)  } }
                .function("isShotFromCrossbow", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShotFromCrossbow ?: false) }
                .function("setShotFromCrossbow", returnsVoid().params(Type.Z)) { it.target?.setShotFromCrossbow(it.getBool(0)) }
        }
    }
}
