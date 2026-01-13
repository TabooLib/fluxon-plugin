package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Material
import org.bukkit.entity.LivingEntity
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FnLivingEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LivingEntity::class.java)
                // 只读属性
                .function("killer", 0) { it.target?.killer }
                .function("lastDamageCause", 0) { it.target?.lastDamageCause }
                .function("eyeLocation", 0) { it.target?.eyeLocation }
                .function("eyeHeight", 0) { it.target?.eyeHeight }
                .function("hasPotion", 0) { it.target?.activePotionEffects?.isNotEmpty() }
                .function("hasAI", 0) { it.target?.hasAI() }
                .function("isClimbing", 0) { it.target?.isClimbing }
                .function("isCollidable", 0) { it.target?.isCollidable }
                .function("isGliding", 0) { it.target?.isGliding }
                .function("isInvisible", 0) { it.target?.isInvisible }
                .function("isLeashed", 0) { it.target?.isLeashed }
                .function("isRiptiding", 0) { it.target?.isRiptiding }
                .function("isSleeping", 0) { it.target?.isSleeping }
                .function("isSwimming", 0) { it.target?.isSwimming }
                .function("category", 0) { it.target?.category }
                .function("equipment", 0) { it.target?.equipment }

                // 氧气
                .function("remainingAir", 0) { it.target?.remainingAir }
                .syncFunction("setRemainingAir", 1) { it.target?.apply { remainingAir = it.getNumber(0).toInt() } }
                .function("maximumAir", 0) { it.target?.maximumAir }
                .syncFunction("setMaximumAir", 1) { it.target?.apply { maximumAir = it.getNumber(0).toInt() } }

                // 伤害相关
                .function("lastDamage", 0) { it.target?.lastDamage }
                .syncFunction("setLastDamage", 1) { it.target?.apply { lastDamage = it.getNumber(0).toDouble() } }
                .syncFunction("setLastDamageCause", 1) { it.target?.apply { lastDamageCause = it.getArgument(0) as? EntityDamageEvent } }
                .function("noDamageTicks", 0) { it.target?.noDamageTicks }
                .syncFunction("setNoDamageTicks", 1) { it.target?.apply { noDamageTicks = it.getNumber(0).toInt() } }

                // 箭矢相关
                .function("arrowCooldown", 0) { it.target?.arrowCooldown }
                .syncFunction("setArrowCooldown", 1) { it.target?.apply { arrowCooldown = it.getNumber(0).toInt() } }
                .function("arrowsInBody", 0) { it.target?.arrowsInBody }
                .syncFunction("setArrowsInBody", 1) { it.target?.apply { arrowsInBody = it.getNumber(0).toInt() } }

                // 拾取物品
                .function("canPickupItems", 0) { it.target?.canPickupItems }
                .syncFunction("setCanPickupItems", 1) { it.target?.apply { canPickupItems = it.getBoolean(0) } }

                // 布尔属性设置
                .syncFunction("setCollidable", 1) { it.target?.apply { isCollidable = it.getBoolean(0) } }
                .syncFunction("setInvisible", 1) { it.target?.apply { isInvisible = it.getBoolean(0) } }
                .syncFunction("setSwimming", 1) { it.target?.apply { isSwimming = it.getBoolean(0) } }

                // 装备栏
                .function("armorContents", 0) { it.target?.equipment?.armorContents ?: arrayOf<ItemStack>() }
                .syncFunction("setArmorContents", 1) {
                    it.target?.equipment?.apply {
                        @Suppress("UNCHECKED_CAST")
                        armorContents = it.getArgument(0) as? Array<out ItemStack> ?: arrayOf()
                    }
                }

                // 主手
                .function("mainHand", 0) { it.target?.equipment?.itemInMainHand ?: ItemStack(Material.AIR) }
                .syncFunction("setMainHand", 1) { it.target?.equipment?.setItemInMainHand(it.getArgument(0) as? ItemStack) }
                .function("itemInMainHandDropChance", 0) { it.target?.equipment?.itemInMainHandDropChance }
                .syncFunction("setItemInMainHandDropChance", 1) { it.target?.equipment?.apply { itemInMainHandDropChance = it.getNumber(0).toFloat() } }

                // 副手
                .function("offHand", 0) { it.target?.equipment?.itemInOffHand ?: ItemStack(Material.AIR) }
                .syncFunction("setOffHand", 1) { it.target?.equipment?.setItemInOffHand(it.getArgument(0) as? ItemStack) }
                .function("itemInOffHandDropChance", 0) { it.target?.equipment?.itemInOffHandDropChance }
                .syncFunction("setItemInOffHandDropChance", 1) { it.target?.equipment?.apply { itemInOffHandDropChance = it.getNumber(0).toFloat() } }

                // 头盔
                .function("helmet", 0) { it.target?.equipment?.helmet ?: ItemStack(Material.AIR) }
                .syncFunction("setHelmet", 1) { it.target?.equipment?.apply { helmet = it.getArgument(0) as? ItemStack } }
                .function("helmetDropChance", 0) { it.target?.equipment?.helmetDropChance }
                .syncFunction("setHelmetDropChance", 1) { it.target?.equipment?.apply { helmetDropChance = it.getNumber(0).toFloat() } }

                // 胸甲
                .function("chestplate", 0) { it.target?.equipment?.chestplate ?: ItemStack(Material.AIR) }
                .syncFunction("setChestplate", 1) { it.target?.equipment?.apply { chestplate = it.getArgument(0) as? ItemStack } }
                .function("chestplateDropChance", 0) { it.target?.equipment?.chestplateDropChance }
                .syncFunction("setChestplateDropChance", 1) { it.target?.equipment?.apply { chestplateDropChance = it.getNumber(0).toFloat() } }

                // 护腿
                .function("leggings", 0) { it.target?.equipment?.leggings ?: ItemStack(Material.AIR) }
                .syncFunction("setLeggings", 1) { it.target?.equipment?.apply { leggings = it.getArgument(0) as? ItemStack } }
                .function("leggingsDropChance", 0) { it.target?.equipment?.leggingsDropChance }
                .syncFunction("setLeggingsDropChance", 1) { it.target?.equipment?.apply { leggingsDropChance = it.getNumber(0).toFloat() } }

                // 护靴
                .function("boots", 0) { it.target?.equipment?.boots ?: ItemStack(Material.AIR) }
                .syncFunction("setBoots", 1) { it.target?.equipment?.apply { boots = it.getArgument(0) as? ItemStack } }
                .function("bootsDropChance", 0) { it.target?.equipment?.bootsDropChance }
                .syncFunction("setBootsDropChance", 1) { it.target?.equipment?.apply { bootsDropChance = it.getNumber(0).toFloat() } }
        }
    }
}
