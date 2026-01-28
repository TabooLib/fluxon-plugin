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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.LivingEntity"])
@PlatformSide(Platform.BUKKIT)
object FnLivingEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LivingEntity::class.java)
                .function("hasPotion", returns(Type.Z).noParams()) { it.target?.activePotionEffects?.isNotEmpty() }
                .function("eyeHeight", returnsObject().noParams()) { it.target?.eyeHeight }
                .function("getEyeHeight", returnsObject().params(Type.OBJECT)) { it.target?.getEyeHeight(it.getBool(0)) }
                .function("eyeLocation", returnsObject().noParams()) { it.target?.eyeLocation }
                .function("getLineOfSight", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.getLineOfSight(
                        it.getRef(0) as Set<Material>,
                        it.getInt(1).toInt()
                    )
                }
                .function("getTargetBlock", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.getTargetBlock(
                        it.getRef(0) as Set<Material>,
                        it.getInt(1).toInt()
                    )
                }
                .function("getLastTwoTargetBlocks", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.getLastTwoTargetBlocks(it.getRef(0) as Set<Material>, it.getInt(1).toInt()) }
                .function("getTargetBlockExact", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getTargetBlockExact(it.getInt(0).toInt())
                    } else {
                        it.target?.getTargetBlockExact(
                            it.getInt(0).toInt(),
                            it.getRef(1) as FluidCollisionMode
                        )
                    }
                }
                .function("getTargetBlockExact", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getTargetBlockExact(it.getInt(0).toInt())
                    } else {
                        it.target?.getTargetBlockExact(
                            it.getInt(0).toInt(),
                            it.getRef(1) as FluidCollisionMode
                        )
                    }
                }
                .function("rayTraceBlocks", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.rayTraceBlocks(it.getAsDouble(0))
                    } else {
                        it.target?.rayTraceBlocks(
                            it.getAsDouble(0),
                            it.getRef(1) as FluidCollisionMode
                        )
                    }
                }
                .function("rayTraceBlocks", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.rayTraceBlocks(it.getAsDouble(0))
                    } else {
                        it.target?.rayTraceBlocks(
                            it.getAsDouble(0),
                            it.getRef(1) as FluidCollisionMode
                        )
                    }
                }
                .function("remainingAir", returnsObject().noParams()) { it.target?.remainingAir }
                .function("setRemainingAir", returnsObject().params(Type.OBJECT)) { it.target?.setRemainingAir(it.getInt(0).toInt()) }
                .function("maximumAir", returnsObject().noParams()) { it.target?.maximumAir }
                .function("setMaximumAir", returnsObject().params(Type.OBJECT)) { it.target?.setMaximumAir(it.getInt(0).toInt()) }
                .function("itemInUse", returnsObject().noParams()) { it.target?.itemInUse }
                .function("itemInUseTicks", returnsObject().noParams()) { it.target?.itemInUseTicks }
                .function("setItemInUseTicks", returnsObject().params(Type.OBJECT)) { it.target?.setItemInUseTicks(it.getInt(0).toInt()) }
                .function("arrowCooldown", returnsObject().noParams()) { it.target?.arrowCooldown }
                .function("setArrowCooldown", returnsObject().params(Type.OBJECT)) { it.target?.setArrowCooldown(it.getInt(0).toInt()) }
                .function("arrowsInBody", returnsObject().noParams()) { it.target?.arrowsInBody }
                .function("setArrowsInBody", returnsObject().params(Type.OBJECT)) { it.target?.setArrowsInBody(it.getInt(0).toInt()) }
                .function("maximumNoDamageTicks", returnsObject().noParams()) { it.target?.maximumNoDamageTicks }
                .function("setMaximumNoDamageTicks", returnsObject().params(Type.OBJECT)) { it.target?.setMaximumNoDamageTicks(it.getInt(0).toInt()) }
                .function("lastDamage", returnsObject().noParams()) { it.target?.lastDamage }
                .function("setLastDamage", returnsObject().params(Type.OBJECT)) { it.target?.setLastDamage(it.getAsDouble(0)) }
                .function("noDamageTicks", returnsObject().noParams()) { it.target?.noDamageTicks }
                .function("setNoDamageTicks", returnsObject().params(Type.OBJECT)) { it.target?.setNoDamageTicks(it.getInt(0).toInt()) }
                .function("noActionTicks", returnsObject().noParams()) { it.target?.noActionTicks }
                .function("setNoActionTicks", returnsObject().params(Type.OBJECT)) { it.target?.setNoActionTicks(it.getInt(0).toInt()) }
                .function("killer", returnsObject().noParams()) { it.target?.killer }
                .syncFunction("addPotionEffect", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.addPotionEffect(it.getRef(0) as PotionEffect)
                    } else {
                        it.target?.addPotionEffect(
                            it.getRef(0) as PotionEffect,
                            it.getBool(1)
                        )
                    }
                }
                .syncFunction("addPotionEffect", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.addPotionEffect(it.getRef(0) as PotionEffect)
                    } else {
                        it.target?.addPotionEffect(
                            it.getRef(0) as PotionEffect,
                            it.getBool(1)
                        )
                    }
                }
                .syncFunction("addPotionEffects", returnsObject().params(Type.OBJECT)) { it.target?.addPotionEffects(it.getRef(0) as Collection<PotionEffect>) }
                .function("hasPotionEffect", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasPotionEffect(it.getRef(0) as PotionEffectType) }
                .function("getPotionEffect", returnsObject().params(Type.OBJECT)) { it.target?.getPotionEffect(it.getRef(0) as PotionEffectType) }
                .function("removePotionEffect", returnsObject().params(Type.OBJECT)) { it.target?.removePotionEffect(it.getRef(0) as PotionEffectType) }
                .function("activePotionEffects", returnsObject().noParams()) { it.target?.activePotionEffects }
                .function("hasLineOfSight", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasLineOfSight(it.getRef(0) as Entity) }
                .function("removeWhenFarAway", returnsObject().noParams()) { it.target?.removeWhenFarAway }
                .function("setRemoveWhenFarAway", returnsObject().params(Type.OBJECT)) { it.target?.setRemoveWhenFarAway(it.getBool(0)) }
                .function("equipment", returnsObject().noParams()) { it.target?.equipment }
                .function("setCanPickupItems", returnsObject().params(Type.OBJECT)) { it.target?.setCanPickupItems(it.getBool(0)) }
                .function("canPickupItems", returns(Type.Z).noParams()) { it.target?.canPickupItems }
                .function("isLeashed", returns(Type.Z).noParams()) { it.target?.isLeashed }
                .function("leashHolder", returnsObject().noParams()) { it.target?.leashHolder }
                .function("setLeashHolder", returnsObject().params(Type.OBJECT)) { it.target?.setLeashHolder(it.getRef(0) as Entity) }
                .function("isGliding", returns(Type.Z).noParams()) { it.target?.isGliding }
                .function("setGliding", returnsObject().params(Type.OBJECT)) { it.target?.setGliding(it.getBool(0)) }
                .function("isSwimming", returns(Type.Z).noParams()) { it.target?.isSwimming }
                .function("setSwimming", returnsObject().params(Type.OBJECT)) { it.target?.setSwimming(it.getBool(0)) }
                .function("isRiptiding", returns(Type.Z).noParams()) { it.target?.isRiptiding }
                .function("isSleeping", returns(Type.Z).noParams()) { it.target?.isSleeping }
                .function("isClimbing", returns(Type.Z).noParams()) { it.target?.isClimbing }
                .function("setAI", returnsObject().params(Type.OBJECT)) { it.target?.setAI(it.getBool(0)) }
                .function("hasAI", returns(Type.Z).noParams()) { it.target?.hasAI() }
                .function("attack", returnsObject().params(Type.OBJECT)) { it.target?.attack(it.getRef(0) as Entity) }
                .function("swingMainHand", returnsObject().noParams()) { it.target?.swingMainHand() }
                .function("swingOffHand", returnsObject().noParams()) { it.target?.swingOffHand() }
                .function("playHurtAnimation", returnsObject().params(Type.OBJECT)) { it.target?.playHurtAnimation(it.getFloat(0)) }
                .function("setCollidable", returnsObject().params(Type.OBJECT)) { it.target?.setCollidable(it.getBool(0)) }
                .function("isCollidable", returns(Type.Z).noParams()) { it.target?.isCollidable }
                .function("collidableExemptions", returnsObject().noParams()) { it.target?.collidableExemptions }
                .function("hurtSound", returnsObject().noParams()) { it.target?.hurtSound }
                .function("deathSound", returnsObject().noParams()) { it.target?.deathSound }
                .function("getFallDamageSound", returnsObject().params(Type.OBJECT)) { it.target?.getFallDamageSound(it.getInt(0).toInt()) }
                .function("fallDamageSoundSmall", returnsObject().noParams()) { it.target?.fallDamageSoundSmall }
                .function("fallDamageSoundBig", returnsObject().noParams()) { it.target?.fallDamageSoundBig }
                .function("getDrinkingSound", returnsObject().params(Type.OBJECT)) { it.target?.getDrinkingSound(it.getRef(0) as ItemStack) }
                .function("getEatingSound", returnsObject().params(Type.OBJECT)) { it.target?.getEatingSound(it.getRef(0) as ItemStack) }
                .function("canBreatheUnderwater", returns(Type.Z).noParams()) { it.target?.canBreatheUnderwater() }
                .function("category", returnsObject().noParams()) { it.target?.category }
                .function("setInvisible", returnsObject().params(Type.OBJECT)) { it.target?.setInvisible(it.getBool(0)) }
                .function("isInvisible", returns(Type.Z).noParams()) { it.target?.isInvisible }
        }
    }
}
