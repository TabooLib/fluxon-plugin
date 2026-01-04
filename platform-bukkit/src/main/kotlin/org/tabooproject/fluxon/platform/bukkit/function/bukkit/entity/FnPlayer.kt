package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.WeatherType
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.platform.util.onlinePlayers
import java.util.UUID

object FnPlayer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("player", 1) {
                when (val id = it.getArgument(0)) {
                    is UUID -> Bukkit.getPlayer(id)
                    is String -> Bukkit.getPlayerExact(id)
                    else -> null
                }
            }
            registerFunction("players", 0) { onlinePlayers }

            registerExtension(Player::class.java)
                // 只读属性
                .function("name", 0) { it.target?.name }
                .function("bedLocation", 0) { it.target?.bedSpawnLocation }
                .function("viewDistance", 0) { it.target?.clientViewDistance }
//                .function("displayName", 0) { it.target?.displayName() }
                .function("level", 0) { it.target?.level }
//                .function("locale", 0) { it.target?.locale() }
                .function("ping", 0) { it.target?.ping }
//                .function("playerListFooter", 0) { it.target?.playerListFooter() }
//                .function("playerListHeader", 0) { it.target?.playerListHeader() }
//                .function("playerListName", 0) { it.target?.playerListName() }
                .function("playerTime", 0) { it.target?.playerTime }
                .function("playerTimeOffset", 0) { it.target?.playerTimeOffset }
                .function("isPlayerTimeRelative", 0) { it.target?.isPlayerTimeRelative }
                .function("playerWeather", 0) { it.target?.playerWeather }
                .function("previousGameMode", 0) { it.target?.previousGameMode }
                .function("isSprinting", 0) { it.target?.isSprinting }

                // 可读写属性
                .function("compassTarget", 0) { it.target?.compassTarget }
                .syncFunction("setCompassTarget", 1) { it.target?.apply { compassTarget = it.getArgument(0) as Location } }
                .function("experience", 0) { it.target?.exp }
                .syncFunction("setExperience", 1) { it.target?.apply { exp = it.getNumber(0).toFloat() } }
                .syncFunction("setLevel", 1) { it.target?.apply { level = it.getNumber(0).toInt() } }
                .function("flySpeed", 0) { it.target?.flySpeed }
                .syncFunction("setFlySpeed", 1) { it.target?.apply { flySpeed = it.getNumber(0).toFloat() } }
                .function("healthScale", 0) { it.target?.healthScale }
                .syncFunction("setHealthScale", 1) { it.target?.apply { healthScale = it.getNumber(0).toDouble() } }

                .syncFunction("setPlayerListFooter", 1) {
                    it.target?.apply {
                        val footer = it.getArgument(0)
                        when (footer) {
                            // is Component -> playerListFooter(footer)
                            else -> playerListFooter = footer?.toString()
                        }
                    }
                }
                .syncFunction("setPlayerListHeader", 1) {
                    it.target?.apply {
                        val header = it.getArgument(0)
                        when (header) {
                            // is Component -> playerListHeader(header)
                            else -> playerListHeader = header?.toString()
                        }
                    }
                }
                .syncFunction("setPlayerTime", 1) { it.target?.setPlayerTime(it.getNumber(0).toLong(), false) }
                .syncFunction("setPlayerWeather", 1) {
                    it.target?.apply {
                        val weather = it.getString(0)?.let { w -> WeatherType.valueOf(w) }
                        if (weather != null) setPlayerWeather(weather)
                    }
                }
                .syncFunction("setSprinting", 1) { it.target?.apply { isSprinting = it.getBoolean(0) } }
        }
    }
}
