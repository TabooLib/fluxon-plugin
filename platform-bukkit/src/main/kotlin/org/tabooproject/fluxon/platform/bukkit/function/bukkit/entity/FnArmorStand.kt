package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ArmorStand
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.util.EulerAngle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnArmorStand {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ArmorStand::class.java)
                .function("itemInHand", 0) { it.target?.itemInHand }
                .function("setItemInHand", 1) { it.target?.setItemInHand(it.getArgument(0) as ItemStack) }
                .function("boots", 0) { it.target?.boots }
                .function("setBoots", 1) { it.target?.setBoots(it.getArgument(0) as ItemStack) }
                .function("leggings", 0) { it.target?.leggings }
                .function("setLeggings", 1) { it.target?.setLeggings(it.getArgument(0) as ItemStack) }
                .function("chestplate", 0) { it.target?.chestplate }
                .function("setChestplate", 1) { it.target?.setChestplate(it.getArgument(0) as ItemStack) }
                .function("helmet", 0) { it.target?.helmet }
                .function("setHelmet", 1) { it.target?.setHelmet(it.getArgument(0) as ItemStack) }
                .function("bodyPose", 0) { it.target?.bodyPose }
                .function("setBodyPose", 1) { it.target?.setBodyPose(it.getArgument(0) as EulerAngle) }
                .function("leftArmPose", 0) { it.target?.leftArmPose }
                .function("setLeftArmPose", 1) { it.target?.setLeftArmPose(it.getArgument(0) as EulerAngle) }
                .function("rightArmPose", 0) { it.target?.rightArmPose }
                .function("setRightArmPose", 1) { it.target?.setRightArmPose(it.getArgument(0) as EulerAngle) }
                .function("leftLegPose", 0) { it.target?.leftLegPose }
                .function("setLeftLegPose", 1) { it.target?.setLeftLegPose(it.getArgument(0) as EulerAngle) }
                .function("rightLegPose", 0) { it.target?.rightLegPose }
                .function("setRightLegPose", 1) { it.target?.setRightLegPose(it.getArgument(0) as EulerAngle) }
                .function("headPose", 0) { it.target?.headPose }
                .function("setHeadPose", 1) { it.target?.setHeadPose(it.getArgument(0) as EulerAngle) }
                .function("hasBasePlate", 0) { it.target?.hasBasePlate() }
                .function("setBasePlate", 1) { it.target?.setBasePlate(it.getBoolean(0)) }
                .function("isVisible", 0) { it.target?.isVisible }
                .function("setVisible", 1) { it.target?.setVisible(it.getBoolean(0)) }
                .function("hasArms", 0) { it.target?.hasArms() }
                .function("setArms", 1) { it.target?.setArms(it.getBoolean(0)) }
                .function("isSmall", 0) { it.target?.isSmall }
                .function("setSmall", 1) { it.target?.setSmall(it.getBoolean(0)) }
                .function("isMarker", 0) { it.target?.isMarker }
                .function("setMarker", 1) { it.target?.setMarker(it.getBoolean(0)) }
                .function("addEquipmentLock", 2) {
                    it.target?.addEquipmentLock(
                        it.getArgument(0) as EquipmentSlot,
                        it.getArgument(1) as ArmorStand.LockType
                    )
                }
                .function("removeEquipmentLock", 2) {
                    it.target?.removeEquipmentLock(
                        it.getArgument(0) as EquipmentSlot,
                        it.getArgument(1) as ArmorStand.LockType
                    )
                }
                .function("hasEquipmentLock", 2) {
                    it.target?.hasEquipmentLock(
                        it.getArgument(0) as EquipmentSlot,
                        it.getArgument(1) as ArmorStand.LockType
                    )
                }
        }
    }
}
