package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.FluidCollisionMode
import org.bukkit.Material
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
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
                .function("hasPotion", 0) { it.target?.activePotionEffects?.isNotEmpty() }
                .function("eyeHeight", listOf(0, 1)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.eyeHeight
                    } else {
                        it.target?.getEyeHeight(it.getBoolean(0))
                    }
                }
                .function("eyeLocation", 0) { it.target?.eyeLocation }
                .function("lineOfSight", 2) {
                    it.target?.getLineOfSight(
                        it.getArgument(0) as Set<Material>,
                        it.getNumber(1).toInt()
                    )
                }
                .function("targetBlock", 2) {
                    it.target?.getTargetBlock(
                        it.getArgument(0) as Set<Material>,
                        it.getNumber(1).toInt()
                    )
                }
                .function(
                    "lastTwoTargetBlocks",
                    2
                ) { it.target?.getLastTwoTargetBlocks(it.getArgument(0) as Set<Material>, it.getNumber(1).toInt()) }
                .function("targetBlockExact", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getTargetBlockExact(it.getNumber(0).toInt())
                    } else {
                        it.target?.getTargetBlockExact(
                            it.getNumber(0).toInt(),
                            it.getArgument(1) as FluidCollisionMode
                        )
                    }
                }
                .function("rayTraceBlocks", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.rayTraceBlocks(it.getNumber(0).toDouble())
                    } else {
                        it.target?.rayTraceBlocks(
                            it.getNumber(0).toDouble(),
                            it.getArgument(1) as FluidCollisionMode
                        )
                    }
                }
                .function("remainingAir", 0) { it.target?.remainingAir }
                .function("setRemainingAir", 1) { it.target?.setRemainingAir(it.getNumber(0).toInt()) }
                .function("maximumAir", 0) { it.target?.maximumAir }
                .function("setMaximumAir", 1) { it.target?.setMaximumAir(it.getNumber(0).toInt()) }
                .function("itemInUse", 0) { it.target?.itemInUse }
                .function("itemInUseTicks", 0) { it.target?.itemInUseTicks }
                .function("setItemInUseTicks", 1) { it.target?.setItemInUseTicks(it.getNumber(0).toInt()) }
                .function("arrowCooldown", 0) { it.target?.arrowCooldown }
                .function("setArrowCooldown", 1) { it.target?.setArrowCooldown(it.getNumber(0).toInt()) }
                .function("arrowsInBody", 0) { it.target?.arrowsInBody }
                .function("setArrowsInBody", 1) { it.target?.setArrowsInBody(it.getNumber(0).toInt()) }
                .function("maximumNoDamageTicks", 0) { it.target?.maximumNoDamageTicks }
                .function("setMaximumNoDamageTicks", 1) { it.target?.setMaximumNoDamageTicks(it.getNumber(0).toInt()) }
                .function("lastDamage", 0) { it.target?.lastDamage }
                .function("setLastDamage", 1) { it.target?.setLastDamage(it.getNumber(0).toDouble()) }
                .function("noDamageTicks", 0) { it.target?.noDamageTicks }
                .function("setNoDamageTicks", 1) { it.target?.setNoDamageTicks(it.getNumber(0).toInt()) }
                .function("noActionTicks", 0) { it.target?.noActionTicks }
                .function("setNoActionTicks", 1) { it.target?.setNoActionTicks(it.getNumber(0).toInt()) }
                .function("killer", 0) { it.target?.killer }
                .syncFunction("addPotionEffect", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.addPotionEffect(it.getArgument(0) as PotionEffect)
                    } else {
                        it.target?.addPotionEffect(
                            it.getArgument(0) as PotionEffect,
                            it.getBoolean(1)
                        )
                    }
                }
                .syncFunction(
                    "addPotionEffects",
                    1
                ) { it.target?.addPotionEffects(it.getArgument(0) as Collection<PotionEffect>) }
                .function("hasPotionEffect", 1) { it.target?.hasPotionEffect(it.getArgument(0) as PotionEffectType) }
                .function("potionEffect", 1) { it.target?.getPotionEffect(it.getArgument(0) as PotionEffectType) }
                .function(
                    "removePotionEffect",
                    1
                ) { it.target?.removePotionEffect(it.getArgument(0) as PotionEffectType) }
                .function("activePotionEffects", 0) { it.target?.activePotionEffects }
                .function("hasLineOfSight", 1) { it.target?.hasLineOfSight(it.getArgument(0) as Entity) }
                .function("removeWhenFarAway", 0) { it.target?.removeWhenFarAway }
                .function("setRemoveWhenFarAway", 1) { it.target?.setRemoveWhenFarAway(it.getBoolean(0)) }
                .function("equipment", 0) { it.target?.equipment }
                .function("setCanPickupItems", 1) { it.target?.setCanPickupItems(it.getBoolean(0)) }
                .function("canPickupItems", 0) { it.target?.canPickupItems }
                .function("isLeashed", 0) { it.target?.isLeashed }
                .function("leashHolder", 0) { it.target?.leashHolder }
                .function("setLeashHolder", 1) { it.target?.setLeashHolder(it.getArgument(0) as Entity) }
                .function("isGliding", 0) { it.target?.isGliding }
                .function("setGliding", 1) { it.target?.setGliding(it.getBoolean(0)) }
                .function("isSwimming", 0) { it.target?.isSwimming }
                .function("setSwimming", 1) { it.target?.setSwimming(it.getBoolean(0)) }
                .function("isRiptiding", 0) { it.target?.isRiptiding }
                .function("isSleeping", 0) { it.target?.isSleeping }
                .function("isClimbing", 0) { it.target?.isClimbing }
                .function("setAI", 1) { it.target?.setAI(it.getBoolean(0)) }
                .function("hasAI", 0) { it.target?.hasAI() }
                .function("attack", 1) { it.target?.attack(it.getArgument(0) as Entity) }
                .function("swingMainHand", 0) { it.target?.swingMainHand() }
                .function("swingOffHand", 0) { it.target?.swingOffHand() }
                .function("playHurtAnimation", 1) { it.target?.playHurtAnimation(it.getNumber(0).toFloat()) }
                .function("setCollidable", 1) { it.target?.setCollidable(it.getBoolean(0)) }
                .function("isCollidable", 0) { it.target?.isCollidable }
                .function("collidableExemptions", 0) { it.target?.collidableExemptions }
                .function("hurtSound", 0) { it.target?.hurtSound }
                .function("deathSound", 0) { it.target?.deathSound }
                .function("fallDamageSound", 1) { it.target?.getFallDamageSound(it.getNumber(0).toInt()) }
                .function("fallDamageSoundSmall", 0) { it.target?.fallDamageSoundSmall }
                .function("fallDamageSoundBig", 0) { it.target?.fallDamageSoundBig }
                .function("drinkingSound", 1) { it.target?.getDrinkingSound(it.getArgument(0) as ItemStack) }
                .function("eatingSound", 1) { it.target?.getEatingSound(it.getArgument(0) as ItemStack) }
                .function("canBreatheUnderwater", 0) { it.target?.canBreatheUnderwater() }
                .function("category", 0) { it.target?.category }
                .function("setInvisible", 1) { it.target?.setInvisible(it.getBoolean(0)) }
                .function("isInvisible", 0) { it.target?.isInvisible }
        }
    }
}
