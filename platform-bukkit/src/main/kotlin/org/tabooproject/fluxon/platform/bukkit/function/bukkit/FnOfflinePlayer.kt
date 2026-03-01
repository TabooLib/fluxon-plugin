package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Material
import org.bukkit.OfflinePlayer
import org.bukkit.Statistic
import org.bukkit.entity.EntityType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.time.Duration
import java.time.Instant
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.OfflinePlayer"])
@PlatformSide(Platform.BUKKIT)
object FnOfflinePlayer {

    val TYPE = Type.fromClass(OfflinePlayer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OfflinePlayer::class.java)
                .function("isOnline", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOnline ?: false) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("uniqueId", returns(org.tabooproject.fluxon.util.StandardTypes.UUID).noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("playerProfile", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile.TYPE).noParams()) { it.setReturnRef(it.target?.playerProfile) }
                .function("isBanned", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBanned ?: false) }
                .function("ban", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, org.tabooproject.fluxon.util.StandardTypes.DATE, Type.STRING)) { it.setReturnRef(it.target?.ban(it.getString(0), it.getRef(1) as Date, it.getString(2))) }
                .function("ban", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.fromClass(Instant::class.java), Type.STRING)) { it.setReturnRef(it.target?.ban(it.getString(0), it.getRef(1) as Instant, it.getString(2))) }
                .function("ban", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.fromClass(Duration::class.java), Type.STRING)) { it.setReturnRef(it.target?.ban(it.getString(0), it.getRef(1) as Duration, it.getString(2))) }
                .function("isWhitelisted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWhitelisted ?: false) }
                .function("setWhitelisted", returnsVoid().params(Type.Z)) { it.target?.setWhitelisted(it.getBool(0)) }
                .function("player", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("firstPlayed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.firstPlayed ?: 0L) }
                .function("lastPlayed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.lastPlayed ?: 0L) }
                .function("hasPlayedBefore", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasPlayedBefore() ?: false) }
                .function("bedSpawnLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.bedSpawnLocation) }
                .function("respawnLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.respawnLocation) }
                .function("incrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE)) {
                    it.target?.incrementStatistic(it.getRef(0) as Statistic)
                }
                .function("incrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, Type.I)) {
                    it.target?.incrementStatistic(it.getRef(0) as Statistic, it.getInt(1).toInt())
                }
                .function("incrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.target?.incrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as Material) }
                .function("incrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.target?.incrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType) }
                .function("incrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) { it.target?.incrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as Material, it.getInt(2).toInt()) }
                .function("incrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE, Type.I)) { it.target?.incrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType, it.getInt(2).toInt()) }
                .function("decrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE)) {
                    it.target?.decrementStatistic(it.getRef(0) as Statistic)
                }
                .function("decrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, Type.I)) {
                    it.target?.decrementStatistic(it.getRef(0) as Statistic, it.getInt(1).toInt())
                }
                .function("decrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.target?.decrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as Material) }
                .function("decrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.target?.decrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType) }
                .function("decrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) { it.target?.decrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as Material, it.getInt(2).toInt()) }
                .function("decrementStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE, Type.I)) { it.target?.decrementStatistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType, it.getInt(2).toInt()) }
                .function("setStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, Type.I)) {
                    it.target?.setStatistic(
                        it.getRef(0) as Statistic,
                        it.getInt(1).toInt()
                    )
                }
                .function("setStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) { it.target?.setStatistic(it.getRef(0) as Statistic, it.getRef(1) as Material, it.getInt(2).toInt()) }
                .function("setStatistic",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE, Type.I)) { it.target?.setStatistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType, it.getInt(2).toInt()) }
                .function("getStatistic",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE)) {
                    it.setReturnInt(it.target?.getStatistic(it.getRef(0) as Statistic) ?: 0)
                }
                .function("getStatistic",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnInt(it.target?.getStatistic(it.getRef(0) as Statistic, it.getRef(1) as Material) ?: 0) }
                .function("getStatistic",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnStatistic.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntityType.TYPE)) { it.setReturnInt(it.target?.getStatistic(it.getRef(0) as Statistic, it.getRef(1) as EntityType) ?: 0) }
                .function("lastDeathLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.lastDeathLocation) }
                .function("location", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
        }
    }
}
