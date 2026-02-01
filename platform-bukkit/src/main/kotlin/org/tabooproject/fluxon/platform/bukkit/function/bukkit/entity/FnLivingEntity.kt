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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.LivingEntity"])
@PlatformSide(Platform.BUKKIT)
object FnLivingEntity {

    val TYPE = Type.fromClass(LivingEntity::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LivingEntity::class.java)
                .function("hasPotion", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.activePotionEffects?.isNotEmpty() ?: false) }
                .function("eyeHeight", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.eyeHeight ?: 0.0) }
                .function("getEyeHeight", returns(Type.D).params(Type.Z)) { it.setReturnDouble(it.target?.getEyeHeight(it.getBool(0)) ?: 0.0) }
                .function("eyeLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.eyeLocation) }
                .function("getLineOfSight", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getLineOfSight(
                        it.getRef(0) as Set<Material>,
                        it.getInt(1).toInt()
                    ))
                }
                .function("getTargetBlock", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getTargetBlock(
                        it.getRef(0) as Set<Material>,
                        it.getInt(1).toInt()
                    ))
                }
                .function("getLastTwoTargetBlocks", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.setReturnRef(it.target?.getLastTwoTargetBlocks(it.getRef(0) as Set<Material>, it.getInt(1).toInt())) }
                .function("getTargetBlockExact", returnsObject().params(Type.I)) {
                    it.setReturnRef(it.target?.getTargetBlockExact(it.getInt(0).toInt()))
                }
                .function("getTargetBlockExact", returnsObject().params(Type.I, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getTargetBlockExact(
                        it.getInt(0).toInt(),
                        it.getRef(1) as FluidCollisionMode
                    ))
                }
                .function("rayTraceBlocks", returnsObject().params(Type.D)) {
                    it.setReturnRef(it.target?.rayTraceBlocks(it.getDouble(0)))
                }
                .function("rayTraceBlocks", returnsObject().params(Type.D, Type.OBJECT)) {
                    it.setReturnRef(it.target?.rayTraceBlocks(
                        it.getDouble(0),
                        it.getRef(1) as FluidCollisionMode
                    ))
                }
                .function("remainingAir", returns(Type.I).noParams()) { it.setReturnInt(it.target?.remainingAir ?: 0) }
                .function("setRemainingAir", returnsVoid().params(Type.I)) { it.target?.setRemainingAir(it.getInt(0)) }
                .function("maximumAir", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumAir ?: 0) }
                .function("setMaximumAir", returnsVoid().params(Type.I)) { it.target?.setMaximumAir(it.getInt(0)) }
                .function("itemInUse", returnsObject().noParams()) { it.setReturnRef(it.target?.itemInUse) }
                .function("itemInUseTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.itemInUseTicks ?: 0) }
                .function("setItemInUseTicks", returnsVoid().params(Type.I)) { it.target?.setItemInUseTicks(it.getInt(0)) }
                .function("arrowCooldown", returns(Type.I).noParams()) { it.setReturnInt(it.target?.arrowCooldown ?: 0) }
                .function("setArrowCooldown", returnsVoid().params(Type.I)) { it.target?.setArrowCooldown(it.getInt(0)) }
                .function("arrowsInBody", returns(Type.I).noParams()) { it.setReturnInt(it.target?.arrowsInBody ?: 0) }
                .function("setArrowsInBody", returnsVoid().params(Type.I)) { it.target?.setArrowsInBody(it.getInt(0)) }
                .function("maximumNoDamageTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumNoDamageTicks ?: 0) }
                .function("setMaximumNoDamageTicks", returnsVoid().params(Type.I)) { it.target?.setMaximumNoDamageTicks(it.getInt(0)) }
                .function("lastDamage", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.lastDamage ?: 0.0) }
                .function("setLastDamage", returnsVoid().params(Type.D)) { it.target?.setLastDamage(it.getDouble(0)) }
                .function("noDamageTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.noDamageTicks ?: 0) }
                .function("setNoDamageTicks", returnsVoid().params(Type.I)) { it.target?.setNoDamageTicks(it.getInt(0)) }
                .function("noActionTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.noActionTicks ?: 0) }
                .function("setNoActionTicks", returnsVoid().params(Type.I)) { it.target?.setNoActionTicks(it.getInt(0)) }
                .function("killer", returnsObject().noParams()) { it.setReturnRef(it.target?.killer) }
                .syncFunction("addPotionEffect", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.addPotionEffect(it.getRef(0) as PotionEffect) ?: false)
                }
                .syncFunction("addPotionEffect", returns(Type.Z).params(Type.OBJECT, Type.Z)) {
                    it.setReturnBool(it.target?.addPotionEffect(
                        it.getRef(0) as PotionEffect,
                        it.getBool(1)
                    ) ?: false)
                }
                .syncFunction("addPotionEffects", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.addPotionEffects(it.getRef(0) as Collection<PotionEffect>) ?: false) }
                .function("hasPotionEffect", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasPotionEffect(it.getRef(0) as PotionEffectType) ?: false) }
                .function("getPotionEffect", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPotionEffect(it.getRef(0) as PotionEffectType)) }
                .function("removePotionEffect", returnsVoid().params(Type.OBJECT)) { it.target?.removePotionEffect(it.getRef(0) as PotionEffectType) }
                .function("activePotionEffects", returnsObject().noParams()) { it.setReturnRef(it.target?.activePotionEffects) }
                .function("hasLineOfSight", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasLineOfSight(it.getRef(0) as Entity) ?: false) }
                .function("removeWhenFarAway", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.removeWhenFarAway ?: false) }
                .function("setRemoveWhenFarAway", returnsVoid().params(Type.Z)) { it.target?.setRemoveWhenFarAway(it.getBool(0)) }
                .function("equipment", returnsObject().noParams()) { it.setReturnRef(it.target?.equipment) }
                .function("setCanPickupItems", returnsVoid().params(Type.Z)) { it.target?.setCanPickupItems(it.getBool(0)) }
                .function("canPickupItems", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canPickupItems ?: false) }
                .function("isLeashed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLeashed ?: false) }
                .function("leashHolder", returnsObject().noParams()) { it.setReturnRef(it.target?.leashHolder) }
                .function("setLeashHolder", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.setLeashHolder(it.getRef(0) as Entity) ?: false) }
                .function("isGliding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isGliding ?: false) }
                .function("setGliding", returnsVoid().params(Type.Z)) { it.target?.setGliding(it.getBool(0)) }
                .function("isSwimming", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSwimming ?: false) }
                .function("setSwimming", returnsVoid().params(Type.Z)) { it.target?.setSwimming(it.getBool(0)) }
                .function("isRiptiding", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRiptiding ?: false) }
                .function("isSleeping", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSleeping ?: false) }
                .function("isClimbing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isClimbing ?: false) }
                .function("setAI", returnsVoid().params(Type.Z)) { it.target?.setAI(it.getBool(0)) }
                .function("hasAI", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasAI() ?: false) }
                .function("attack", returnsVoid().params(Type.OBJECT)) { it.target?.attack(it.getRef(0) as Entity) }
                .function("swingMainHand", returnsVoid().noParams()) { it.target?.swingMainHand() }
                .function("swingOffHand", returnsVoid().noParams()) { it.target?.swingOffHand() }
                .function("playHurtAnimation", returnsVoid().params(Type.F)) { it.target?.playHurtAnimation(it.getFloat(0)) }
                .function("setCollidable", returnsVoid().params(Type.Z)) { it.target?.setCollidable(it.getBool(0)) }
                .function("isCollidable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCollidable ?: false) }
                .function("collidableExemptions", returnsObject().noParams()) { it.setReturnRef(it.target?.collidableExemptions) }
                .function("hurtSound", returnsObject().noParams()) { it.setReturnRef(it.target?.hurtSound) }
                .function("deathSound", returnsObject().noParams()) { it.setReturnRef(it.target?.deathSound) }
                .function("getFallDamageSound", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getFallDamageSound(it.getInt(0).toInt())) }
                .function("fallDamageSoundSmall", returnsObject().noParams()) { it.setReturnRef(it.target?.fallDamageSoundSmall) }
                .function("fallDamageSoundBig", returnsObject().noParams()) { it.setReturnRef(it.target?.fallDamageSoundBig) }
                .function("getDrinkingSound", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDrinkingSound(it.getRef(0) as ItemStack)) }
                .function("getEatingSound", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getEatingSound(it.getRef(0) as ItemStack)) }
                .function("canBreatheUnderwater", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.canBreatheUnderwater() ?: false) }
                .function("category", returnsObject().noParams()) { it.setReturnRef(it.target?.category) }
                .function("setInvisible", returnsVoid().params(Type.Z)) { it.target?.setInvisible(it.getBool(0)) }
                .function("isInvisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInvisible ?: false) }
        }
    }
}
