package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.*
import org.bukkit.advancement.Advancement
import org.bukkit.block.Block
import org.bukkit.block.BlockState
import org.bukkit.block.Sign
import org.bukkit.block.data.BlockData
import org.bukkit.block.sign.Side
import org.bukkit.entity.Entity
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.ItemStack
import org.bukkit.map.MapView
import org.bukkit.plugin.Plugin
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.scoreboard.Scoreboard
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.platform.util.onlinePlayers
import java.time.Duration
import java.time.Instant
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
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
                .function("name", 0) { it.target?.name }
                .function("displayName", 0) { it.target?.displayName }
                .function("setDisplayName", 1) { it.target?.setDisplayName(it.getString(0)) }
                .function("playerListName", 0) { it.target?.playerListName }
                .function("setPlayerListName", 1) { it.target?.setPlayerListName(it.getString(0)) }
                .function("playerListHeader", 0) { it.target?.playerListHeader }
                .function("playerListFooter", 0) { it.target?.playerListFooter }
                .function("setPlayerListHeader", 1) { it.target?.setPlayerListHeader(it.getString(0)) }
                .function("setPlayerListFooter", 1) { it.target?.setPlayerListFooter(it.getString(0)) }
                .function("setPlayerListHeaderFooter", 2) {
                    it.target?.setPlayerListHeaderFooter(
                        it.getString(0),
                        it.getString(1)
                    )
                }
                .function("setCompassTarget", 1) { it.target?.setCompassTarget(it.getArgument(0) as Location) }
                .function("compassTarget", 0) { it.target?.compassTarget }
                .function("address", 0) { it.target?.address }
                .function("isTransferred", 0) { it.target?.isTransferred }
                .function("sendRawMessage", 1) { it.target?.sendRawMessage(it.getString(0)!!) }
                .syncFunction("kickPlayer", 1) { it.target?.kickPlayer(it.getString(0)) }
                .function("ban", 4) {
                    when (val var2 = it.getArgument(1)) {
                        is Date -> it.target?.ban(it.getString(0), var2, it.getString(2), it.getBoolean(3))
                        is Instant -> it.target?.ban(it.getString(0), var2, it.getString(2), it.getBoolean(3))
                        is Duration -> it.target?.ban(it.getString(0), var2, it.getString(2), it.getBoolean(3))
                        else -> throw IllegalArgumentException("参数 2 必须是 Date, Instant, 或 Duration 类型")
                    }
                }
                .function("banIp", 4) {
                    when (val var2 = it.getArgument(1)) {
                        is Date -> it.target?.banIp(it.getString(0), var2, it.getString(2), it.getBoolean(3))
                        is Instant -> it.target?.banIp(it.getString(0), var2, it.getString(2), it.getBoolean(3))
                        is Duration -> it.target?.banIp(it.getString(0), var2, it.getString(2), it.getBoolean(3))
                        else -> throw IllegalArgumentException("参数 2 必须是 Date, Instant, 或 Duration 类型")
                    }
                }
                .syncFunction("chat", 1) { it.target?.chat(it.getString(0)!!) }
                .syncFunction("performCommand", 1) { it.target?.performCommand(it.getString(0)!!) }
                .function("isOnGround", 0) { it.target?.isOnGround }
                .function("isSneaking", 0) { it.target?.isSneaking }
                .function("setSneaking", 1) { it.target?.setSneaking(it.getBoolean(0)) }
                .function("isSprinting", 0) { it.target?.isSprinting }
                .function("setSprinting", 1) { it.target?.setSprinting(it.getBoolean(0)) }
                .function("saveData", 0) { it.target?.saveData() }
                .function("loadData", 0) { it.target?.loadData() }
                .function("setSleepingIgnored", 1) { it.target?.setSleepingIgnored(it.getBoolean(0)) }
                .function("isSleepingIgnored", 0) { it.target?.isSleepingIgnored }
                .function("bedSpawnLocation", 0) { it.target?.bedSpawnLocation }
                .function("respawnLocation", 0) { it.target?.respawnLocation }
                .function("setBedSpawnLocation", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setBedSpawnLocation(it.getArgument(0) as Location)
                    } else {
                        it.target?.setBedSpawnLocation(
                            it.getArgument(0) as Location,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("setRespawnLocation", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setRespawnLocation(it.getArgument(0) as Location)
                    } else {
                        it.target?.setRespawnLocation(
                            it.getArgument(0) as Location,
                            it.getBoolean(1)
                        )
                    }
                }
                .function("playNote", 3) {
                    when (val var2 = it.getArgument(1)) {
                        is Byte -> it.target?.playNote(it.getArgument(0) as Location, var2, it.getNumber(2).toByte())
                        is Instrument -> it.target?.playNote(
                            it.getArgument(0) as Location,
                            var2,
                            it.getArgument(2) as Note
                        )

                        else -> throw IllegalArgumentException("参数 2 必须是 Byte 或 Instrument 类型")
                    }
                }
                .function("playSound", listOf(4, 5, 6)) {
                    when (it.arguments.size) {
                        4 -> when (val var1 = it.getArgument(0)) {
                            is Location -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getNumber(2).toFloat(),
                                    it.getNumber(3).toFloat()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getArgument(0)) {
                            is Location -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }

                        6 -> when (val var1 = it.getArgument(0)) {
                            is Location -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getArgument(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getArgument(2) as SoundCategory,
                                    it.getNumber(3).toFloat(),
                                    it.getNumber(4).toFloat(),
                                    it.getNumber(5).toLong()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }
                        else -> error("Player#playSound 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("stopSound", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Sound -> it.target?.stopSound(var1)
                            is String -> it.target?.stopSound(var1)
                            is SoundCategory -> it.target?.stopSound(var1)
                            else -> throw IllegalArgumentException("参数必须是 Sound, String, 或 SoundCategory 类型")
                        }
                    } else {
                        when (val var1 = it.getArgument(0)) {
                            is Sound -> it.target?.stopSound(var1, it.getArgument(1) as? SoundCategory)
                            is String -> it.target?.stopSound(var1, it.getArgument(1) as? SoundCategory)
                            else -> throw IllegalArgumentException("参数 1 必须是 Sound 或 String 类型")
                        }
                    }
                }
                .function("stopAllSounds", 0) { it.target?.stopAllSounds() }
                .function("playEffect", 3) {
                    it.target?.playEffect(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Effect,
                        it.getNumber(2).toInt()
                    )
                }
                .function("breakBlock", 1) { it.target?.breakBlock(it.getArgument(0) as Block) }
                .function("sendBlockChange", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.sendBlockChange(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as BlockData
                        )
                    } else {
                        it.target?.sendBlockChange(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Material,
                            it.getNumber(2).toByte()
                        )
                    }
                }
                .function("sendBlockChanges", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.sendBlockChanges(it.getArgument(0) as Collection<BlockState>)
                    } else {
                        it.target?.sendBlockChanges(it.getArgument(0) as Collection<BlockState>, it.getBoolean(1))
                    }
                }
                .function("sendBlockDamage", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.sendBlockDamage(
                            it.getArgument(0) as Location,
                            it.getNumber(1).toFloat()
                        )
                    } else {
                        when (val var3 = it.getArgument(2)) {
                            is Entity -> it.target?.sendBlockDamage(
                                it.getArgument(0) as Location,
                                it.getNumber(1).toFloat(),
                                var3
                            )

                            is Int -> it.target?.sendBlockDamage(
                                it.getArgument(0) as Location,
                                it.getNumber(1).toFloat(),
                                var3
                            )

                            else -> throw IllegalArgumentException("参数 3 必须是 Entity 或 Int 类型")
                        }
                    }
                }
                .function("sendEquipmentChange", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        it.target?.sendEquipmentChange(
                            it.getArgument(0) as LivingEntity,
                            it.getArgument(1) as Map<EquipmentSlot, ItemStack>
                        )
                    } else {
                        it.target?.sendEquipmentChange(
                            it.getArgument(0) as LivingEntity,
                            it.getArgument(1) as EquipmentSlot,
                            it.getArgument(2) as ItemStack
                        )
                    }
                }
                .function("sendSignChange", listOf(2, 3, 4)) {
                    when (it.arguments.size) {
                        2 -> it.target?.sendSignChange(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Array<String>
                        )

                        3 -> it.target?.sendSignChange(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Array<String>,
                            it.getArgument(2) as DyeColor
                        )

                        4 -> it.target?.sendSignChange(
                            it.getArgument(0) as Location,
                            it.getArgument(1) as Array<String>,
                            it.getArgument(2) as DyeColor,
                            it.getBoolean(3)
                        )
                        else -> error("Player#sendSignChange 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function(
                    "sendPotionEffectChange",
                    2
                ) {
                    it.target?.sendPotionEffectChange(
                        it.getArgument(0) as LivingEntity,
                        it.getArgument(1) as PotionEffect
                    )
                }
                .function(
                    "sendPotionEffectChangeRemove",
                    2
                ) {
                    it.target?.sendPotionEffectChangeRemove(
                        it.getArgument(0) as LivingEntity,
                        it.getArgument(1) as PotionEffectType
                    )
                }
                .function("sendMap", 1) { it.target?.sendMap(it.getArgument(0) as MapView) }
                .function("sendHurtAnimation", 1) { it.target?.sendHurtAnimation(it.getNumber(0).toFloat()) }
                .function(
                    "addCustomChatCompletions",
                    1
                ) { it.target?.addCustomChatCompletions(it.getArgument(0) as Collection<String>) }
                .function(
                    "removeCustomChatCompletions",
                    1
                ) { it.target?.removeCustomChatCompletions(it.getArgument(0) as Collection<String>) }
                .function(
                    "setCustomChatCompletions",
                    1
                ) { it.target?.setCustomChatCompletions(it.getArgument(0) as Collection<String>) }
                .function("previousGameMode", 0) { it.target?.previousGameMode }
                .function("setPlayerTime", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setPlayerTime(it.getNumber(0).toLong(), false)
                    } else {
                        it.target?.setPlayerTime(it.getNumber(0).toLong(), it.getBoolean(1))
                    }
                }
                .function("playerTime", 0) { it.target?.playerTime }
                .function("playerTimeOffset", 0) { it.target?.playerTimeOffset }
                .function("isPlayerTimeRelative", 0) { it.target?.isPlayerTimeRelative }
                .function("resetPlayerTime", 0) { it.target?.resetPlayerTime() }
                .function("setPlayerWeather", 1) { it.target?.setPlayerWeather(it.getArgument(0) as WeatherType) }
                .function("playerWeather", 0) { it.target?.playerWeather }
                .function("resetPlayerWeather", 0) { it.target?.resetPlayerWeather() }
                .function("expCooldown", 0) { it.target?.expCooldown }
                .function("setExpCooldown", 1) { it.target?.setExpCooldown(it.getNumber(0).toInt()) }
                .function("giveExp", 1) { it.target?.giveExp(it.getNumber(0).toInt()) }
                .function("giveExpLevels", 1) { it.target?.giveExpLevels(it.getNumber(0).toInt()) }
                .function("exp", 0) { it.target?.exp }
                .function("setExp", 1) { it.target?.setExp(it.getNumber(0).toFloat()) }
                .function("level", 0) { it.target?.level }
                .function("setLevel", 1) { it.target?.setLevel(it.getNumber(0).toInt()) }
                .function("totalExperience", 0) { it.target?.totalExperience }
                .function("setTotalExperience", 1) { it.target?.setTotalExperience(it.getNumber(0).toInt()) }
                .function("sendExperienceChange", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.sendExperienceChange(it.getNumber(0).toFloat())
                    } else {
                        it.target?.sendExperienceChange(
                            it.getNumber(0).toFloat(),
                            it.getNumber(1).toInt()
                        )
                    }
                }
                .function("allowFlight", 0) { it.target?.allowFlight }
                .function("setAllowFlight", 1) { it.target?.setAllowFlight(it.getBoolean(0)) }
                .function("hidePlayer", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.hidePlayer(it.getArgument(0) as Player)
                    } else {
                        it.target?.hidePlayer(
                            it.getArgument(0) as Plugin,
                            it.getArgument(1) as Player
                        )
                    }
                }
                .function("showPlayer", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.showPlayer(it.getArgument(0) as Player)
                    } else {
                        it.target?.showPlayer(
                            it.getArgument(0) as Plugin,
                            it.getArgument(1) as Player
                        )
                    }
                }
                .function("canSee", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is Player -> it.target?.canSee(var1)
                        is Entity -> it.target?.canSee(var1)
                        else -> throw IllegalArgumentException("参数必须是 Player 或 Entity 类型")
                    }
                }
                .function("hideEntity", 2) {
                    it.target?.hideEntity(
                        it.getArgument(0) as Plugin,
                        it.getArgument(1) as Entity
                    )
                }
                .function("showEntity", 2) {
                    it.target?.showEntity(
                        it.getArgument(0) as Plugin,
                        it.getArgument(1) as Entity
                    )
                }
                .function("isFlying", 0) { it.target?.isFlying }
                .function("setFlying", 1) { it.target?.setFlying(it.getBoolean(0)) }
                .function("setFlySpeed", 1) { it.target?.setFlySpeed(it.getNumber(0).toFloat()) }
                .function("setWalkSpeed", 1) { it.target?.setWalkSpeed(it.getNumber(0).toFloat()) }
                .function("flySpeed", 0) { it.target?.flySpeed }
                .function("walkSpeed", 0) { it.target?.walkSpeed }
                .function("setTexturePack", 1) { it.target?.setTexturePack(it.getString(0)!!) }
                .function("setResourcePack", listOf(1, 2, 3, 4, 5)) {
                    when (it.arguments.size) {
                        1 -> it.target?.setResourcePack(it.getString(0)!!)
                        2 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getArgument(1) as ByteArray
                        )

                        3 -> when (val var3 = it.getArgument(2)) {
                            is String -> it.target?.setResourcePack(
                                it.getString(0)!!,
                                it.getArgument(1) as? ByteArray,
                                var3
                            )

                            is Boolean -> it.target?.setResourcePack(
                                it.getString(0)!!,
                                it.getArgument(1) as? ByteArray,
                                var3
                            )

                            else -> throw IllegalArgumentException("参数 3 必须是 String 或 Boolean 类型")
                        }

                        4 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getArgument(1) as ByteArray,
                            it.getString(2),
                            it.getBoolean(3)
                        )

                        5 -> it.target?.setResourcePack(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)!!,
                            it.getArgument(2) as ByteArray,
                            it.getString(3),
                            it.getBoolean(4)
                        )
                        else -> error("Player#setResourcePack 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("addResourcePack", 5) {
                    it.target?.addResourcePack(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)!!,
                        it.getArgument(2) as ByteArray,
                        it.getString(3),
                        it.getBoolean(4)
                    )
                }
                .function("removeResourcePack", 1) { it.target?.removeResourcePack(UUID.fromString(it.getString(0))) }
                .function("removeResourcePacks", 0) { it.target?.removeResourcePacks() }
                .function("scoreboard", 0) { it.target?.scoreboard }
                .function("setScoreboard", 1) { it.target?.setScoreboard(it.getArgument(0) as Scoreboard) }
                .function("worldBorder", 0) { it.target?.worldBorder }
                .function("setWorldBorder", 1) { it.target?.setWorldBorder(it.getArgument(0) as WorldBorder) }
                .function("sendHealthUpdate", listOf(0, 3)) {
                    if (it.arguments.isEmpty()) {
                        it.target?.sendHealthUpdate()
                    } else {
                        it.target?.sendHealthUpdate(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toInt(),
                            it.getNumber(2).toFloat()
                        )
                    }
                }
                .function("isHealthScaled", 0) { it.target?.isHealthScaled }
                .function("setHealthScaled", 1) { it.target?.setHealthScaled(it.getBoolean(0)) }
                .function("setHealthScale", 1) { it.target?.setHealthScale(it.getNumber(0).toDouble()) }
                .function("healthScale", 0) { it.target?.healthScale }
                .function("spectatorTarget", 0) { it.target?.spectatorTarget }
                .function("setSpectatorTarget", 1) { it.target?.setSpectatorTarget(it.getArgument(0) as Entity) }
                .function("sendTitle", listOf(2, 5)) {
                    if (it.arguments.size == 2) {
                        it.target?.sendTitle(it.getString(0), it.getString(1))
                    } else {
                        it.target?.sendTitle(
                            it.getString(0),
                            it.getString(1),
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toInt(),
                            it.getNumber(4).toInt()
                        )
                    }
                }
                .function("resetTitle", 0) { it.target?.resetTitle() }
                .function("spawnParticle", listOf(3, 5, 6, 7, 8, 9)) {
                    when (it.arguments.size) {
                        3 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getArgument(1) as Location,
                            it.getNumber(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getArgument(1) as Location,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble()
                        )

                        7 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getArgument(1) as Location,
                            it.getNumber(2).toInt(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble(),
                            it.getNumber(6).toDouble()
                        )

                        8 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toDouble(),
                            it.getNumber(6).toDouble(),
                            it.getNumber(7).toDouble()
                        )

                        9 -> it.target?.spawnParticle(
                            it.getArgument(0) as Particle,
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toInt(),
                            it.getNumber(5).toDouble(),
                            it.getNumber(6).toDouble(),
                            it.getNumber(7).toDouble(),
                            it.getNumber(8).toDouble()
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function(
                    "getAdvancementProgress",
                    1
                ) { it.target?.getAdvancementProgress(it.getArgument(0) as Advancement) }
                .function("clientViewDistance", 0) { it.target?.clientViewDistance }
                .function("ping", 0) { it.target?.ping }
                .function("locale", 0) { it.target?.locale }
                .function("updateCommands", 0) { it.target?.updateCommands() }
                .function("openBook", 1) { it.target?.openBook(it.getArgument(0) as ItemStack) }
                .function("openSign", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.openSign(it.getArgument(0) as Sign)
                    } else {
                        it.target?.openSign(it.getArgument(0) as Sign, it.getArgument(1) as Side)
                    }
                }
                .function("showDemoScreen", 0) { it.target?.showDemoScreen() }
                .function("isAllowingServerListings", 0) { it.target?.isAllowingServerListings }
//                .function("displayName", 0) { it.target?.displayName() }
//                .function("locale", 0) { it.target?.locale() }
//                .function("playerListFooter", 0) { it.target?.playerListFooter() }
//                .function("playerListHeader", 0) { it.target?.playerListHeader() }
//                .function("playerListName", 0) { it.target?.playerListName() }
        }
    }
}
