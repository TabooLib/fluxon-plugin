package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.EntityEffect
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Entity::class.java)
                .function("isMoving", 0) { it.target?.velocity?.let { v -> !v.isZero } }
                .function("location", 0) { it.target?.location }
                .function("getLocation", 1) { it.target?.getLocation(it.getArgument(0) as Location) }
                .function("setVelocity", 1) { it.target?.setVelocity(it.getArgument(0) as Vector) }
                .function("velocity", 0) { it.target?.velocity }
                .function("height", 0) { it.target?.height }
                .function("width", 0) { it.target?.width }
                .function("boundingBox", 0) { it.target?.boundingBox }
                .function("isOnGround", 0) { it.target?.isOnGround }
                .function("isInWater", 0) { it.target?.isInWater }
                .function("world", 0) { it.target?.world }
                .function("setRotation", 2) {
                    it.target?.setRotation(
                        it.getNumber(0).toFloat(),
                        it.getNumber(1).toFloat()
                    )
                }
                .syncFunction("teleport", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Location -> it.target?.teleport(var1)
                            is Entity -> it.target?.teleport(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                        }
                    } else {
                        when (val var1 = it.getArgument(0)) {
                            is Location -> it.target?.teleport(
                                var1,
                                it.getArgument(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                            )

                            is Entity -> it.target?.teleport(
                                var1,
                                it.getArgument(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                            )

                            else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                        }
                    }
                }
                .syncFunction("getNearbyEntities", 3) {
                    it.target?.getNearbyEntities(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("entityId", 0) { it.target?.entityId }
                .function("fireTicks", 0) { it.target?.fireTicks }
                .function("maxFireTicks", 0) { it.target?.maxFireTicks }
                .function("setFireTicks", 1) { it.target?.setFireTicks(it.getNumber(0).toInt()) }
                .function("setVisualFire", 1) { it.target?.setVisualFire(it.getBoolean(0)) }
                .function("isVisualFire", 0) { it.target?.isVisualFire }
                .function("freezeTicks", 0) { it.target?.freezeTicks }
                .function("maxFreezeTicks", 0) { it.target?.maxFreezeTicks }
                .function("setFreezeTicks", 1) { it.target?.setFreezeTicks(it.getNumber(0).toInt()) }
                .function("isFrozen", 0) { it.target?.isFrozen }
                .function("remove", 0) { it.target?.remove() }
                .function("isDead", 0) { it.target?.isDead }
                .function("isValid", 0) { it.target?.isValid }
                .function("server", 0) { it.target?.server }
                .function("isPersistent", 0) { it.target?.isPersistent }
                .function("setPersistent", 1) { it.target?.setPersistent(it.getBoolean(0)) }
                .function("passenger", 0) { it.target?.passenger }
                .function("setPassenger", 1) { it.target?.setPassenger(it.getArgument(0) as Entity) }
                .function("passengers", 0) { it.target?.passengers }
                .function("addPassenger", 1) { it.target?.addPassenger(it.getArgument(0) as Entity) }
                .function("removePassenger", 1) { it.target?.removePassenger(it.getArgument(0) as Entity) }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("eject", 0) { it.target?.eject() }
                .function("fallDistance", 0) { it.target?.fallDistance }
                .function("setFallDistance", 1) { it.target?.setFallDistance(it.getNumber(0).toFloat()) }
                .function(
                    "setLastDamageCause",
                    1
                ) {
                    @Suppress("removal")
                    it.target?.setLastDamageCause(it.getArgument(0) as EntityDamageEvent)
                }
                .function("lastDamageCause", 0) { it.target?.lastDamageCause }
                .function("uniqueId", 0) { it.target?.uniqueId }
                .function("ticksLived", 0) { it.target?.ticksLived }
                .function("setTicksLived", 1) { it.target?.setTicksLived(it.getNumber(0).toInt()) }
                .function("playEffect", 1) { it.target?.playEffect(it.getArgument(0) as EntityEffect) }
                .function("type", 0) { it.target?.type }
                .function("swimSound", 0) { it.target?.swimSound }
                .function("swimSplashSound", 0) { it.target?.swimSplashSound }
                .function("swimHighSpeedSplashSound", 0) { it.target?.swimHighSpeedSplashSound }
                .function("isInsideVehicle", 0) { it.target?.isInsideVehicle }
                .function("leaveVehicle", 0) { it.target?.leaveVehicle() }
                .function("vehicle", 0) { it.target?.vehicle }
                .function("setCustomNameVisible", 1) { it.target?.setCustomNameVisible(it.getBoolean(0)) }
                .function("isCustomNameVisible", 0) { it.target?.isCustomNameVisible }
                .function("setVisibleByDefault", 1) { it.target?.setVisibleByDefault(it.getBoolean(0)) }
                .function("isVisibleByDefault", 0) { it.target?.isVisibleByDefault }
                .function("trackedBy", 0) { it.target?.trackedBy }
                .function("setGlowing", 1) { it.target?.setGlowing(it.getBoolean(0)) }
                .function("isGlowing", 0) { it.target?.isGlowing }
                .function("setInvulnerable", 1) { it.target?.setInvulnerable(it.getBoolean(0)) }
                .function("isInvulnerable", 0) { it.target?.isInvulnerable }
                .function("isSilent", 0) { it.target?.isSilent }
                .function("setSilent", 1) { it.target?.setSilent(it.getBoolean(0)) }
                .function("hasGravity", 0) { it.target?.hasGravity() }
                .function("setGravity", 1) { it.target?.setGravity(it.getBoolean(0)) }
                .function("portalCooldown", 0) { it.target?.portalCooldown }
                .function("setPortalCooldown", 1) { it.target?.setPortalCooldown(it.getNumber(0).toInt()) }
                .function("scoreboardTags", 0) { it.target?.scoreboardTags }
                .function("addScoreboardTag", 1) { it.target?.addScoreboardTag(it.getString(0)!!) }
                .function("removeScoreboardTag", 1) { it.target?.removeScoreboardTag(it.getString(0)!!) }
                .function("pistonMoveReaction", 0) { it.target?.pistonMoveReaction }
                .function("facing", 0) { it.target?.facing }
                .function("pose", 0) { it.target?.pose }
                .function("spawnCategory", 0) { it.target?.spawnCategory }
                .function("isInWorld", 0) { it.target?.isInWorld }
        }
    }
}
