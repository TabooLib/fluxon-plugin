package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ArmorStand
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.util.EulerAngle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.ArmorStand"])
@PlatformSide(Platform.BUKKIT)
object FnArmorStand {

    val TYPE = Type.fromClass(ArmorStand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorStand::class.java)
                .function("itemInHand", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInHand) }
                .function("setItemInHand", returnsVoid().params(Type.OBJECT)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("boots", returnsObject().noParams()) { it.setReturnRef(it.target?.boots) }
                .function("setBoots", returnsVoid().params(Type.OBJECT)) { it.target?.setBoots(it.getRef(0) as ItemStack) }
                .function("leggings", returnsObject().noParams()) { it.setReturnRef(it.target?.leggings) }
                .function("setLeggings", returnsVoid().params(Type.OBJECT)) { it.target?.setLeggings(it.getRef(0) as ItemStack) }
                .function("chestplate", returnsObject().noParams()) { it.setReturnRef(it.target?.chestplate) }
                .function("setChestplate", returnsVoid().params(Type.OBJECT)) { it.target?.setChestplate(it.getRef(0) as ItemStack) }
                .function("helmet", returnsObject().noParams()) { it.setReturnRef(it.target?.helmet) }
                .function("setHelmet", returnsVoid().params(Type.OBJECT)) { it.target?.setHelmet(it.getRef(0) as ItemStack) }
                .function("bodyPose", returnsObject().noParams()) { it.setReturnRef(it.target?.bodyPose) }
                .function("setBodyPose", returnsVoid().params(Type.OBJECT)) { it.target?.setBodyPose(it.getRef(0) as EulerAngle) }
                .function("leftArmPose", returnsObject().noParams()) { it.setReturnRef(it.target?.leftArmPose) }
                .function("setLeftArmPose", returnsVoid().params(Type.OBJECT)) { it.target?.setLeftArmPose(it.getRef(0) as EulerAngle) }
                .function("rightArmPose", returnsObject().noParams()) { it.setReturnRef(it.target?.rightArmPose) }
                .function("setRightArmPose", returnsVoid().params(Type.OBJECT)) { it.target?.setRightArmPose(it.getRef(0) as EulerAngle) }
                .function("leftLegPose", returnsObject().noParams()) { it.setReturnRef(it.target?.leftLegPose) }
                .function("setLeftLegPose", returnsVoid().params(Type.OBJECT)) { it.target?.setLeftLegPose(it.getRef(0) as EulerAngle) }
                .function("rightLegPose", returnsObject().noParams()) { it.setReturnRef(it.target?.rightLegPose) }
                .function("setRightLegPose", returnsVoid().params(Type.OBJECT)) { it.target?.setRightLegPose(it.getRef(0) as EulerAngle) }
                .function("headPose", returnsObject().noParams()) { it.setReturnRef(it.target?.headPose) }
                .function("setHeadPose", returnsVoid().params(Type.OBJECT)) { it.target?.setHeadPose(it.getRef(0) as EulerAngle) }
                .function("hasBasePlate", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasBasePlate() ?: false) }
                .function("setBasePlate", returnsVoid().params(Type.Z)) { it.target?.setBasePlate(it.getBool(0)) }
                .function("isVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisible ?: false) }
                .function("setVisible", returnsVoid().params(Type.Z)) { it.target?.setVisible(it.getBool(0)) }
                .function("hasArms", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasArms() ?: false) }
                .function("setArms", returnsVoid().params(Type.Z)) { it.target?.setArms(it.getBool(0)) }
                .function("isSmall", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSmall ?: false) }
                .function("setSmall", returnsVoid().params(Type.Z)) { it.target?.setSmall(it.getBool(0)) }
                .function("isMarker", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isMarker ?: false) }
                .function("setMarker", returnsVoid().params(Type.Z)) { it.target?.setMarker(it.getBool(0)) }
                .function("addEquipmentLock", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.addEquipmentLock(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ArmorStand.LockType
                    )
                }
                .function("removeEquipmentLock", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.removeEquipmentLock(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ArmorStand.LockType
                    )
                }
                .function("hasEquipmentLock", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.hasEquipmentLock(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ArmorStand.LockType
                    ) == true)
                }
        }
    }
}
