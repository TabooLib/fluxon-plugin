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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.ArmorStand"])
@PlatformSide(Platform.BUKKIT)
object FnArmorStand {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorStand::class.java)
                .function("itemInHand", returnsObject().noParams()) { it.target?.itemInHand }
                .function("setItemInHand", returnsObject().params(Type.OBJECT)) { it.target?.setItemInHand(it.getRef(0) as ItemStack) }
                .function("boots", returnsObject().noParams()) { it.target?.boots }
                .function("setBoots", returnsObject().params(Type.OBJECT)) { it.target?.setBoots(it.getRef(0) as ItemStack) }
                .function("leggings", returnsObject().noParams()) { it.target?.leggings }
                .function("setLeggings", returnsObject().params(Type.OBJECT)) { it.target?.setLeggings(it.getRef(0) as ItemStack) }
                .function("chestplate", returnsObject().noParams()) { it.target?.chestplate }
                .function("setChestplate", returnsObject().params(Type.OBJECT)) { it.target?.setChestplate(it.getRef(0) as ItemStack) }
                .function("helmet", returnsObject().noParams()) { it.target?.helmet }
                .function("setHelmet", returnsObject().params(Type.OBJECT)) { it.target?.setHelmet(it.getRef(0) as ItemStack) }
                .function("bodyPose", returnsObject().noParams()) { it.target?.bodyPose }
                .function("setBodyPose", returnsObject().params(Type.OBJECT)) { it.target?.setBodyPose(it.getRef(0) as EulerAngle) }
                .function("leftArmPose", returnsObject().noParams()) { it.target?.leftArmPose }
                .function("setLeftArmPose", returnsObject().params(Type.OBJECT)) { it.target?.setLeftArmPose(it.getRef(0) as EulerAngle) }
                .function("rightArmPose", returnsObject().noParams()) { it.target?.rightArmPose }
                .function("setRightArmPose", returnsObject().params(Type.OBJECT)) { it.target?.setRightArmPose(it.getRef(0) as EulerAngle) }
                .function("leftLegPose", returnsObject().noParams()) { it.target?.leftLegPose }
                .function("setLeftLegPose", returnsObject().params(Type.OBJECT)) { it.target?.setLeftLegPose(it.getRef(0) as EulerAngle) }
                .function("rightLegPose", returnsObject().noParams()) { it.target?.rightLegPose }
                .function("setRightLegPose", returnsObject().params(Type.OBJECT)) { it.target?.setRightLegPose(it.getRef(0) as EulerAngle) }
                .function("headPose", returnsObject().noParams()) { it.target?.headPose }
                .function("setHeadPose", returnsObject().params(Type.OBJECT)) { it.target?.setHeadPose(it.getRef(0) as EulerAngle) }
                .function("hasBasePlate", returns(Type.Z).noParams()) { it.target?.hasBasePlate() }
                .function("setBasePlate", returnsObject().params(Type.OBJECT)) { it.target?.setBasePlate(it.getBool(0)) }
                .function("isVisible", returns(Type.Z).noParams()) { it.target?.isVisible }
                .function("setVisible", returnsObject().params(Type.OBJECT)) { it.target?.setVisible(it.getBool(0)) }
                .function("hasArms", returns(Type.Z).noParams()) { it.target?.hasArms() }
                .function("setArms", returnsObject().params(Type.OBJECT)) { it.target?.setArms(it.getBool(0)) }
                .function("isSmall", returns(Type.Z).noParams()) { it.target?.isSmall }
                .function("setSmall", returnsObject().params(Type.OBJECT)) { it.target?.setSmall(it.getBool(0)) }
                .function("isMarker", returns(Type.Z).noParams()) { it.target?.isMarker }
                .function("setMarker", returnsObject().params(Type.OBJECT)) { it.target?.setMarker(it.getBool(0)) }
                .function("addEquipmentLock", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.addEquipmentLock(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ArmorStand.LockType
                    )
                }
                .function("removeEquipmentLock", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.removeEquipmentLock(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ArmorStand.LockType
                    )
                }
                .function("hasEquipmentLock", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.hasEquipmentLock(
                        it.getRef(0) as EquipmentSlot,
                        it.getRef(1) as ArmorStand.LockType
                    )
                }
        }
    }
}
