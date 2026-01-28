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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Entity"])
@PlatformSide(Platform.BUKKIT)
object FnEntity {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Entity::class.java)
                .function("isMoving", returns(Type.Z).noParams()) { it.target?.velocity?.let { v -> !v.isZero } }
                .function("location", returnsObject().noParams()) { it.target?.location }
                .function("getLocation", returnsObject().params(Type.OBJECT)) { it.target?.getLocation(it.getRef(0) as Location) }
                .function("setVelocity", returnsObject().params(Type.OBJECT)) { it.target?.setVelocity(it.getRef(0) as Vector) }
                .function("velocity", returnsObject().noParams()) { it.target?.velocity }
                .function("height", returnsObject().noParams()) { it.target?.height }
                .function("width", returnsObject().noParams()) { it.target?.width }
                .function("boundingBox", returnsObject().noParams()) { it.target?.boundingBox }
                .function("isOnGround", returns(Type.Z).noParams()) { it.target?.isOnGround }
                .function("isInWater", returns(Type.Z).noParams()) { it.target?.isInWater }
                .function("world", returnsObject().noParams()) { it.target?.world }
                .function("setRotation", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setRotation(
                        it.getFloat(0),
                        it.getFloat(1)
                    )
                }
                .syncFunction("teleport", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.teleport(var1)
                            is Entity -> it.target?.teleport(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                        }
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.teleport(
                                var1,
                                it.getRef(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                            )

                            is Entity -> it.target?.teleport(
                                var1,
                                it.getRef(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                            )

                            else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                        }
                    }
                }
                .syncFunction("teleport", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.teleport(var1)
                            is Entity -> it.target?.teleport(var1)
                            else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                        }
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Location -> it.target?.teleport(
                                var1,
                                it.getRef(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                            )

                            is Entity -> it.target?.teleport(
                                var1,
                                it.getRef(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                            )

                            else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                        }
                    }
                }
                .function("getNearbyEntities", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.getNearbyEntities(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2)
                    )
                }
                .function("entityId", returnsObject().noParams()) { it.target?.entityId }
                .function("fireTicks", returnsObject().noParams()) { it.target?.fireTicks }
                .function("maxFireTicks", returnsObject().noParams()) { it.target?.maxFireTicks }
                .function("setFireTicks", returnsObject().params(Type.OBJECT)) { it.target?.setFireTicks(it.getInt(0).toInt()) }
                .function("setVisualFire", returnsObject().params(Type.OBJECT)) { it.target?.setVisualFire(it.getBool(0)) }
                .function("isVisualFire", returns(Type.Z).noParams()) { it.target?.isVisualFire }
                .function("freezeTicks", returnsObject().noParams()) { it.target?.freezeTicks }
                .function("maxFreezeTicks", returnsObject().noParams()) { it.target?.maxFreezeTicks }
                .function("setFreezeTicks", returnsObject().params(Type.OBJECT)) { it.target?.setFreezeTicks(it.getInt(0).toInt()) }
                .function("isFrozen", returns(Type.Z).noParams()) { it.target?.isFrozen }
                .function("remove", returnsObject().noParams()) { it.target?.remove() }
                .function("isDead", returns(Type.Z).noParams()) { it.target?.isDead }
                .function("isValid", returns(Type.Z).noParams()) { it.target?.isValid }
                .function("server", returnsObject().noParams()) { it.target?.server }
                .function("isPersistent", returns(Type.Z).noParams()) { it.target?.isPersistent }
                .function("setPersistent", returnsObject().params(Type.OBJECT)) { it.target?.setPersistent(it.getBool(0)) }
                .function("passenger", returnsObject().noParams()) { it.target?.passenger }
                .function("setPassenger", returnsObject().params(Type.OBJECT)) { it.target?.setPassenger(it.getRef(0) as Entity) }
                .function("passengers", returnsObject().noParams()) { it.target?.passengers }
                .function("addPassenger", returnsObject().params(Type.OBJECT)) { it.target?.addPassenger(it.getRef(0) as Entity) }
                .function("removePassenger", returnsObject().params(Type.OBJECT)) { it.target?.removePassenger(it.getRef(0) as Entity) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.target?.isEmpty }
                .function("eject", returnsObject().noParams()) { it.target?.eject() }
                .function("fallDistance", returnsObject().noParams()) { it.target?.fallDistance }
                .function("setFallDistance", returnsObject().params(Type.OBJECT)) { it.target?.setFallDistance(it.getFloat(0)) }
                .function("setLastDamageCause", returnsObject().params(Type.OBJECT)) {
                    @Suppress("removal")
                    it.target?.setLastDamageCause(it.getRef(0) as EntityDamageEvent)
                }
                .function("lastDamageCause", returnsObject().noParams()) { it.target?.lastDamageCause }
                .function("uniqueId", returnsObject().noParams()) { it.target?.uniqueId }
                .function("ticksLived", returnsObject().noParams()) { it.target?.ticksLived }
                .function("setTicksLived", returnsObject().params(Type.OBJECT)) { it.target?.setTicksLived(it.getInt(0).toInt()) }
                .function("playEffect", returnsObject().params(Type.OBJECT)) { it.target?.playEffect(it.getRef(0) as EntityEffect) }
                .function("type", returnsObject().noParams()) { it.target?.type }
                .function("swimSound", returnsObject().noParams()) { it.target?.swimSound }
                .function("swimSplashSound", returnsObject().noParams()) { it.target?.swimSplashSound }
                .function("swimHighSpeedSplashSound", returnsObject().noParams()) { it.target?.swimHighSpeedSplashSound }
                .function("isInsideVehicle", returns(Type.Z).noParams()) { it.target?.isInsideVehicle }
                .function("leaveVehicle", returnsObject().noParams()) { it.target?.leaveVehicle() }
                .function("vehicle", returnsObject().noParams()) { it.target?.vehicle }
                .function("setCustomNameVisible", returnsObject().params(Type.OBJECT)) { it.target?.setCustomNameVisible(it.getBool(0)) }
                .function("isCustomNameVisible", returns(Type.Z).noParams()) { it.target?.isCustomNameVisible }
                .function("setVisibleByDefault", returnsObject().params(Type.OBJECT)) { it.target?.setVisibleByDefault(it.getBool(0)) }
                .function("isVisibleByDefault", returns(Type.Z).noParams()) { it.target?.isVisibleByDefault }
                .function("trackedBy", returnsObject().noParams()) { it.target?.trackedBy }
                .function("setGlowing", returnsObject().params(Type.OBJECT)) { it.target?.setGlowing(it.getBool(0)) }
                .function("isGlowing", returns(Type.Z).noParams()) { it.target?.isGlowing }
                .function("setInvulnerable", returnsObject().params(Type.OBJECT)) { it.target?.setInvulnerable(it.getBool(0)) }
                .function("isInvulnerable", returns(Type.Z).noParams()) { it.target?.isInvulnerable }
                .function("isSilent", returns(Type.Z).noParams()) { it.target?.isSilent }
                .function("setSilent", returnsObject().params(Type.OBJECT)) { it.target?.setSilent(it.getBool(0)) }
                .function("hasGravity", returns(Type.Z).noParams()) { it.target?.hasGravity() }
                .function("setGravity", returnsObject().params(Type.OBJECT)) { it.target?.setGravity(it.getBool(0)) }
                .function("portalCooldown", returnsObject().noParams()) { it.target?.portalCooldown }
                .function("setPortalCooldown", returnsObject().params(Type.OBJECT)) { it.target?.setPortalCooldown(it.getInt(0).toInt()) }
                .function("scoreboardTags", returnsObject().noParams()) { it.target?.scoreboardTags }
                .function("addScoreboardTag", returnsObject().params(Type.OBJECT)) { it.target?.addScoreboardTag(it.getString(0)!!) }
                .function("removeScoreboardTag", returnsObject().params(Type.OBJECT)) { it.target?.removeScoreboardTag(it.getString(0)!!) }
                .function("pistonMoveReaction", returnsObject().noParams()) { it.target?.pistonMoveReaction }
                .function("facing", returnsObject().noParams()) { it.target?.facing }
                .function("pose", returnsObject().noParams()) { it.target?.pose }
                .function("spawnCategory", returnsObject().noParams()) { it.target?.spawnCategory }
                .function("isInWorld", returns(Type.Z).noParams()) { it.target?.isInWorld }
        }
    }
}
