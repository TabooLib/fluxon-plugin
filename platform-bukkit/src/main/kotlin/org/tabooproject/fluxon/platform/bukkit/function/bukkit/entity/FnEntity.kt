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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Entity"])
@PlatformSide(Platform.BUKKIT)
object FnEntity {

    val TYPE = Type.fromClass(Entity::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Entity::class.java)
                .function("isMoving", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.velocity?.let { v -> !v.isZero } ?: false)
                }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("getLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getLocation(it.getRef(0) as Location)) }
                .function("setVelocity", returnsVoid().params(Type.OBJECT)) { it.target?.setVelocity(it.getRef(0) as Vector) }
                .function("velocity", returnsObject().noParams()) { it.setReturnRef(it.target?.velocity) }
                .function("height", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.height ?: 0.0) }
                .function("width", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.width ?: 0.0) }
                .function("boundingBox", returnsObject().noParams()) { it.setReturnRef(it.target?.boundingBox) }
                .function("isOnGround", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOnGround ?: false) }
                .function("isInWater", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInWater ?: false) }
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("setRotation", returnsVoid().params(Type.F, Type.F)) {
                    it.target?.setRotation(
                        it.getFloat(0),
                        it.getFloat(1)
                    )
                }
                .syncFunction("teleport", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Location -> it.target?.teleport(var1)
                        is Entity -> it.target?.teleport(var1)
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                    } ?: false)
                }
                .syncFunction("teleport", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Location -> it.target?.teleport(
                            var1,
                            it.getRef(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                        )

                        is Entity -> it.target?.teleport(
                            var1,
                            it.getRef(1) as org.bukkit.event.player.PlayerTeleportEvent.TeleportCause
                        )

                        else -> throw IllegalArgumentException("参数必须是 Location 或 Entity 类型")
                    } ?: false)
                }
                .function("getNearbyEntities", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getNearbyEntities(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("entityId", returns(Type.I).noParams()) { it.setReturnInt(it.target?.entityId ?: 0) }
                .function("fireTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fireTicks ?: 0) }
                .function("maxFireTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxFireTicks ?: 0) }
                .function("setFireTicks", returnsVoid().params(Type.I)) { it.target?.setFireTicks(it.getInt(0)) }
                .function("setVisualFire", returnsVoid().params(Type.Z)) { it.target?.setVisualFire(it.getBool(0)) }
                .function("isVisualFire", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisualFire ?: false) }
                .function("freezeTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.freezeTicks ?: 0) }
                .function("maxFreezeTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxFreezeTicks ?: 0) }
                .function("setFreezeTicks", returnsVoid().params(Type.I)) { it.target?.setFreezeTicks(it.getInt(0)) }
                .function("isFrozen", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFrozen ?: false) }
                .function("remove", returnsVoid().noParams()) { it.target?.remove() }
                .function("isDead", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDead ?: false) }
                .function("isValid", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isValid ?: false) }
                .function("server", returnsObject().noParams()) { it.setReturnRef(it.target?.server) }
                .function("isPersistent", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPersistent ?: false) }
                .function("setPersistent", returnsVoid().params(Type.Z)) { it.target?.setPersistent(it.getBool(0)) }
                .function("passenger", returnsObject().noParams()) { it.setReturnRef(it.target?.passenger) }
                .function("setPassenger", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.setPassenger(it.getRef(0) as Entity) ?: false) }
                .function("passengers", returnsObject().noParams()) { it.setReturnRef(it.target?.passengers) }
                .function("addPassenger", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.addPassenger(it.getRef(0) as Entity) ?: false) }
                .function("removePassenger", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.removePassenger(it.getRef(0) as Entity) ?: false) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("eject", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.eject() ?: false) }
                .function("fallDistance", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.fallDistance ?: 0f) }
                .function("setFallDistance", returnsVoid().params(Type.F)) { it.target?.setFallDistance(it.getFloat(0)) }
                .function("setLastDamageCause", returnsVoid().params(Type.OBJECT)) {
                    @Suppress("removal")
                    it.target?.setLastDamageCause(it.getRef(0) as EntityDamageEvent)
                }
                .function("lastDamageCause", returnsObject().noParams()) { it.setReturnRef(it.target?.lastDamageCause) }
                .function("uniqueId", returnsObject().noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("ticksLived", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ticksLived ?: 0) }
                .function("setTicksLived", returnsVoid().params(Type.I)) { it.target?.setTicksLived(it.getInt(0)) }
                .function("playEffect", returnsVoid().params(Type.OBJECT)) { it.target?.playEffect(it.getRef(0) as EntityEffect) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
                .function("swimSound", returnsObject().noParams()) { it.setReturnRef(it.target?.swimSound) }
                .function("swimSplashSound", returnsObject().noParams()) { it.setReturnRef(it.target?.swimSplashSound) }
                .function("swimHighSpeedSplashSound", returnsObject().noParams()) { it.setReturnRef(it.target?.swimHighSpeedSplashSound) }
                .function("isInsideVehicle", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInsideVehicle ?: false) }
                .function("leaveVehicle", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.leaveVehicle() ?: false) }
                .function("vehicle", returnsObject().noParams()) { it.setReturnRef(it.target?.vehicle) }
                .function("setCustomNameVisible", returnsVoid().params(Type.Z)) { it.target?.setCustomNameVisible(it.getBool(0)) }
                .function("isCustomNameVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCustomNameVisible ?: false) }
                .function("setVisibleByDefault", returnsVoid().params(Type.Z)) { it.target?.setVisibleByDefault(it.getBool(0)) }
                .function("isVisibleByDefault", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisibleByDefault ?: false) }
                .function("trackedBy", returnsObject().noParams()) { it.setReturnRef(it.target?.trackedBy) }
                .function("setGlowing", returnsVoid().params(Type.Z)) { it.target?.setGlowing(it.getBool(0)) }
                .function("isGlowing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isGlowing ?: false) }
                .function("setInvulnerable", returnsVoid().params(Type.Z)) { it.target?.setInvulnerable(it.getBool(0)) }
                .function("isInvulnerable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInvulnerable ?: false) }
                .function("isSilent", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSilent ?: false) }
                .function("setSilent", returnsVoid().params(Type.Z)) { it.target?.setSilent(it.getBool(0)) }
                .function("hasGravity", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasGravity() ?: false) }
                .function("setGravity", returnsVoid().params(Type.Z)) { it.target?.setGravity(it.getBool(0)) }
                .function("portalCooldown", returns(Type.I).noParams()) { it.setReturnInt(it.target?.portalCooldown ?: 0) }
                .function("setPortalCooldown", returnsVoid().params(Type.I)) { it.target?.setPortalCooldown(it.getInt(0)) }
                .function("scoreboardTags", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboardTags) }
                .function("addScoreboardTag", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.addScoreboardTag(it.getString(0)!!) ?: false) }
                .function("removeScoreboardTag", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.removeScoreboardTag(it.getString(0)!!) ?: false) }
                .function("pistonMoveReaction", returnsObject().noParams()) { it.setReturnRef(it.target?.pistonMoveReaction) }
                .function("facing", returnsObject().noParams()) { it.setReturnRef(it.target?.facing) }
                .function("pose", returnsObject().noParams()) { it.setReturnRef(it.target?.pose) }
                .function("spawnCategory", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnCategory) }
                .function("isInWorld", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isInWorld ?: false) }
        }
    }
}
