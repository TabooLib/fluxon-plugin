package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

/**
 * FluxonPlugin
 * org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
 *
 * @author mical
 * @since 2026/1/4 12:38
 */
object FnEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Entity::class.java)
                // 基本属性（只读）
                .function("boundingBox", 0) { it.target?.boundingBox }
                .function("entityId", 0) { it.target?.entityId }
                .function("facing", 0) { it.target?.facing }
                .function("height", 0) { it.target?.height }
                .function("lastDamageCause", 0) { it.target?.lastDamageCause }
                .function("location", 0) { it.target?.location }
                .function("maxFireTicks", 0) { it.target?.maxFireTicks }
                .function("maxFreezeTicks", 0) { it.target?.maxFreezeTicks }
                .function("passengers", 0) { it.target?.passengers }
                .function("pistonMoveReaction", 0) { it.target?.pistonMoveReaction }
                .function("pose", 0) { it.target?.pose }
                .function("scoreboardTags", 0) { it.target?.scoreboardTags }
                .function("server", 0) { it.target?.server }
                .function("spawnCategory", 0) { it.target?.spawnCategory }
                .function("type", 0) { it.target?.type }
                .function("uniqueId", 0) { it.target?.uniqueId }
                .function("vehicle", 0) { it.target?.vehicle }
                .function("width", 0) { it.target?.width }
                .function("world", 0) { it.target?.world }

                // 可读写属性
                .function("fallDistance", 0) { it.target?.fallDistance }
                .syncFunction("setFallDistance", 1) { it.target?.apply { fallDistance = it.getNumber(0).toFloat() } }
                .function("fireTicks", 0) { it.target?.fireTicks }
                .syncFunction("setFireTicks", 1) { it.target?.apply { fireTicks = it.getNumber(0).toInt() } }
                .function("freezeTicks", 0) { it.target?.freezeTicks }
                .syncFunction("setFreezeTicks", 1) { it.target?.apply { freezeTicks = it.getNumber(0).toInt() } }
                .function("portalCooldown", 0) { it.target?.portalCooldown }
                .syncFunction("setPortalCooldown", 1) { it.target?.apply { portalCooldown = it.getNumber(0).toInt() } }
                .function("ticksLived", 0) { it.target?.ticksLived }
                .syncFunction("setTicksLived", 1) { it.target?.apply { ticksLived = it.getNumber(0).toInt() } }
                .function("velocity", 0) { it.target?.velocity }
                .syncFunction("setVelocity", 1) { it.target?.apply { velocity = it.getArgument(0) as Vector } }

                // 布尔属性
                .function("gravity", 0) { it.target?.hasGravity() }
                .syncFunction("setGravity", 1) { it.target?.setGravity(it.getBoolean(0)) }
                .function("isCustomNameVisible", 0) { it.target?.isCustomNameVisible }
                .syncFunction("setCustomNameVisible", 1) { it.target?.apply { isCustomNameVisible = it.getBoolean(0) } }
                .function("isDead", 0) { it.target?.isDead }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("isFrozen", 0) { it.target?.isFrozen }
                .function("isGlowing", 0) { it.target?.isGlowing }
                .syncFunction("setGlowing", 1) { it.target?.apply { isGlowing = it.getBoolean(0) } }
                .function("isInsideVehicle", 0) { it.target?.isInsideVehicle }
                .function("isInvulnerable", 0) { it.target?.isInvulnerable }
                .syncFunction("setInvulnerable", 1) { it.target?.apply { isInvulnerable = it.getBoolean(0) } }
                .function("isInWater", 0) { it.target?.isInWater }
                .function("isOnGround", 0) { it.target?.isOnGround }
                .function("isPersistent", 0) { it.target?.isPersistent }
                .syncFunction("setPersistent", 1) { it.target?.apply { isPersistent = it.getBoolean(0) } }
                .function("isSilent", 0) { it.target?.isSilent }
                .syncFunction("setSilent", 1) { it.target?.apply { isSilent = it.getBoolean(0) } }
                .function("isValid", 0) { it.target?.isValid }
                .function("isVisualFire", 0) { it.target?.isVisualFire }
                .syncFunction("setVisualFire", 1) { it.target?.apply { isVisualFire = it.getBoolean(0) } }
                .function("isMoving", 0) { it.target?.velocity?.let { v -> !v.isZero } }
        }
    }
}