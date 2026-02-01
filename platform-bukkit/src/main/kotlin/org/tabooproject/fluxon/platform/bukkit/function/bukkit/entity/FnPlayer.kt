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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.platform.util.onlinePlayers
import java.time.Duration
import java.time.Instant
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Player"])
@PlatformSide(Platform.BUKKIT)
object FnPlayer {

    val TYPE = Type.fromClass(Player::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerFunction("player", returnsObject().params(Type.OBJECT)) {
                it.setReturnRef(when (val id = it.getRef(0)) {
                    is UUID -> Bukkit.getPlayer(id)
                    is String -> Bukkit.getPlayerExact(id)
                    else -> null
                })
            }
            registerFunction("players", returns(Type.LIST).noParams()) { it.setReturnRef(onlinePlayers) }

            registerExtension(Player::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsVoid().params(Type.STRING)) { it.target?.setDisplayName(it.getString(0)) }
                .function("playerListName", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListName) }
                .function("setPlayerListName", returnsVoid().params(Type.STRING)) { it.target?.setPlayerListName(it.getString(0)) }
                .function("playerListHeader", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListHeader) }
                .function("playerListFooter", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListFooter) }
                .function("setPlayerListHeader", returnsVoid().params(Type.STRING)) { it.target?.setPlayerListHeader(it.getString(0)) }
                .function("setPlayerListFooter", returnsVoid().params(Type.STRING)) { it.target?.setPlayerListFooter(it.getString(0)) }
                .function("setPlayerListHeaderFooter", returnsVoid().params(Type.STRING, Type.STRING)) {
                    it.target?.setPlayerListHeaderFooter(
                        it.getString(0),
                        it.getString(1)
                    )
                }
                .function("setCompassTarget", returnsVoid().params(Type.OBJECT)) { it.target?.setCompassTarget(it.getRef(0) as Location) }
                .function("compassTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.compassTarget) }
                .function("address", returnsObject().noParams()) { it.setReturnRef(it.target?.address) }
                .function("isTransferred", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTransferred ?: false) }
                .function("sendRawMessage", returnsVoid().params(Type.STRING)) { it.target?.sendRawMessage(it.getString(0)!!) }
                .syncFunction("kickPlayer", returnsVoid().params(Type.STRING)) { it.target?.kickPlayer(it.getString(0)) }
                .function("ban", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is Date -> it.target?.ban(it.getString(0), var2, it.getString(2), it.getBool(3))
                        is Instant -> it.target?.ban(it.getString(0), var2, it.getString(2), it.getBool(3))
                        is Duration -> it.target?.ban(it.getString(0), var2, it.getString(2), it.getBool(3))
                        else -> throw IllegalArgumentException("参数 2 必须是 Date, Instant, 或 Duration 类型")
                    })
                }
                .function("banIp", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is Date -> it.target?.banIp(it.getString(0), var2, it.getString(2), it.getBool(3))
                        is Instant -> it.target?.banIp(it.getString(0), var2, it.getString(2), it.getBool(3))
                        is Duration -> it.target?.banIp(it.getString(0), var2, it.getString(2), it.getBool(3))
                        else -> throw IllegalArgumentException("参数 2 必须是 Date, Instant, 或 Duration 类型")
                    })
                }
                .syncFunction("chat", returnsVoid().params(Type.STRING)) { it.target?.chat(it.getString(0)!!) }
                .syncFunction("performCommand", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.performCommand(it.getString(0)!!) ?: false)
                }
                .function("isOnGround", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOnGround ?: false) }
                .function("isSneaking", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSneaking ?: false) }
                .function("setSneaking", returnsVoid().params(Type.Z)) { it.target?.setSneaking(it.getBool(0)) }
                .function("isSprinting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSprinting ?: false) }
                .function("setSprinting", returnsVoid().params(Type.Z)) { it.target?.setSprinting(it.getBool(0)) }
                .function("saveData", returnsVoid().noParams()) { it.target?.saveData() }
                .function("loadData", returnsVoid().noParams()) { it.target?.loadData() }
                .function("setSleepingIgnored", returnsVoid().params(Type.Z)) { it.target?.setSleepingIgnored(it.getBool(0)) }
                .function("isSleepingIgnored", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSleepingIgnored ?: false) }
                .function("bedSpawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.bedSpawnLocation) }
                .function("respawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.respawnLocation) }
                .function("setBedSpawnLocation", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setBedSpawnLocation(it.getRef(0) as Location)
                }
                .function("setBedSpawnLocation", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.setBedSpawnLocation(it.getRef(0) as Location, it.getBool(1))
                }
                .function("setRespawnLocation", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setRespawnLocation(it.getRef(0) as Location)
                }
                .function("setRespawnLocation", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.setRespawnLocation(it.getRef(0) as Location, it.getBool(1))
                }
                .function("playNote", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var2 = it.getRef(1)) {
                        is Byte -> it.target?.playNote(it.getRef(0) as Location, var2, it.getInt(2).toByte())
                        is Instrument -> it.target?.playNote(
                            it.getRef(0) as Location,
                            var2,
                            it.getRef(2) as Note
                        )

                        else -> throw IllegalArgumentException("参数 2 必须是 Byte 或 Instrument 类型")
                    })
                }
                .function("playSound", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.F, Type.F)) {
                    when (val var1 = it.getRef(0)) {
                        is Location -> when (val var2 = it.getRef(1)) {
                            is Sound -> it.target?.playSound(var1, var2, it.getFloat(2), it.getFloat(3))
                            is String -> it.target?.playSound(var1, var2, it.getFloat(2), it.getFloat(3))
                            else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                        }

                        is Entity -> when (val var2 = it.getRef(1)) {
                            is Sound -> it.target?.playSound(var1, var2, it.getFloat(2), it.getFloat(3))
                            is String -> it.target?.playSound(var1, var2, it.getFloat(2), it.getFloat(3))
                            else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                        }

                        else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                    }
                }
                .function("playSound", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.F, Type.F)) {
                    when (val var1 = it.getRef(0)) {
                        is Location -> when (val var2 = it.getRef(1)) {
                            is Sound -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4)
                            )

                            is String -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4)
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                        }

                        is Entity -> when (val var2 = it.getRef(1)) {
                            is Sound -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4)
                            )

                            is String -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4)
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                        }

                        else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                    }
                }
                .function("playSound", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.F, Type.F, Type.J)) {
                    when (val var1 = it.getRef(0)) {
                        is Location -> when (val var2 = it.getRef(1)) {
                            is Sound -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4),
                                it.getLong(5)
                            )

                            is String -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4),
                                it.getLong(5)
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                        }

                        is Entity -> when (val var2 = it.getRef(1)) {
                            is Sound -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4),
                                it.getLong(5)
                            )

                            is String -> it.target?.playSound(
                                var1,
                                var2,
                                it.getRef(2) as SoundCategory,
                                it.getFloat(3),
                                it.getFloat(4),
                                it.getLong(5)
                            )

                            else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                        }

                        else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                    }
                }
                .function("stopSound", returnsVoid().params(Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Sound -> it.target?.stopSound(var1)
                        is String -> it.target?.stopSound(var1)
                        is SoundCategory -> it.target?.stopSound(var1)
                        else -> throw IllegalArgumentException("参数必须是 Sound, String, 或 SoundCategory 类型")
                    }
                }
                .function("stopSound", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    when (val var1 = it.getRef(0)) {
                        is Sound -> it.target?.stopSound(var1, it.getRef(1) as? SoundCategory)
                        is String -> it.target?.stopSound(var1, it.getRef(1) as? SoundCategory)
                        else -> throw IllegalArgumentException("参数 1 必须是 Sound 或 String 类型")
                    }
                }
                .function("stopAllSounds", returnsVoid().noParams()) { it.target?.stopAllSounds() }
                .function("playEffect", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I)) {
                    it.target?.playEffect(
                        it.getRef(0) as Location,
                        it.getRef(1) as Effect,
                        it.getInt(2)
                    )
                }
                .function("breakBlock", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.breakBlock(it.getRef(0) as Block) ?: false)
                }
                .function("sendBlockChange", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendBlockChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as BlockData
                    )
                }
                .function("sendBlockChange", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I)) {
                    it.target?.sendBlockChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Material,
                        it.getInt(2).toByte()
                    )
                }
                .function("sendBlockChanges", returnsVoid().params(Type.OBJECT)) {
                    it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>)
                }
                .function("sendBlockChanges", returnsVoid().params(Type.OBJECT, Type.Z)) {
                    it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>, it.getBool(1))
                }
                .function("sendBlockDamage", returnsVoid().params(Type.OBJECT, Type.F)) {
                    it.target?.sendBlockDamage(
                        it.getRef(0) as Location,
                        it.getFloat(1)
                    )
                }
                .function("sendBlockDamage", returnsVoid().params(Type.OBJECT, Type.F, Type.OBJECT)) {
                    when (val var3 = it.getRef(2)) {
                        is Entity -> it.target?.sendBlockDamage(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            var3
                        )
                        is Int -> it.target?.sendBlockDamage(
                            it.getRef(0) as Location,
                            it.getFloat(1),
                            var3
                        )
                        else -> throw IllegalArgumentException("参数 3 必须是 Entity 或 Int 类型")
                    }
                }
                .function("sendEquipmentChange", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendEquipmentChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as Map<EquipmentSlot, ItemStack>
                    )
                }
                .function("sendEquipmentChange", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendEquipmentChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as EquipmentSlot,
                        it.getRef(2) as ItemStack
                    )
                }
                .function("sendSignChange", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendSignChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Array<String>
                    )
                }
                .function("sendSignChange", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendSignChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Array<String>,
                        it.getRef(2) as DyeColor
                    )
                }
                .function("sendSignChange", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.Z)) {
                    it.target?.sendSignChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Array<String>,
                        it.getRef(2) as DyeColor,
                        it.getBool(3)
                    )
                }
                .function("sendPotionEffectChange", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendPotionEffectChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as PotionEffect
                    )
                }
                .function("sendPotionEffectChangeRemove", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.sendPotionEffectChangeRemove(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as PotionEffectType
                    )
                }
                .function("sendMap", returnsVoid().params(Type.OBJECT)) { it.target?.sendMap(it.getRef(0) as MapView) }
                .function("sendHurtAnimation", returnsVoid().params(Type.F)) { it.target?.sendHurtAnimation(it.getFloat(0)) }
                .function("addCustomChatCompletions", returnsVoid().params(Type.OBJECT)) { it.target?.addCustomChatCompletions(it.getRef(0) as Collection<String>) }
                .function("removeCustomChatCompletions", returnsVoid().params(Type.OBJECT)) { it.target?.removeCustomChatCompletions(it.getRef(0) as Collection<String>) }
                .function("setCustomChatCompletions", returnsVoid().params(Type.OBJECT)) { it.target?.setCustomChatCompletions(it.getRef(0) as Collection<String>) }
                .function("previousGameMode", returnsObject().noParams()) { it.setReturnRef(it.target?.previousGameMode) }
                .function("setPlayerTime", returnsVoid().params(Type.J)) {
                    it.target?.setPlayerTime(it.getLong(0), false)
                }
                .function("setPlayerTime", returnsVoid().params(Type.J, Type.Z)) {
                    it.target?.setPlayerTime(it.getLong(0), it.getBool(1))
                }
                .function("playerTime", returns(Type.J).noParams()) { it.setReturnLong(it.target?.playerTime ?: 0) }
                .function("playerTimeOffset", returns(Type.J).noParams()) { it.setReturnLong(it.target?.playerTimeOffset ?: 0) }
                .function("isPlayerTimeRelative", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlayerTimeRelative ?: false) }
                .function("resetPlayerTime", returnsVoid().noParams()) { it.target?.resetPlayerTime() }
                .function("setPlayerWeather", returnsVoid().params(Type.OBJECT)) { it.target?.setPlayerWeather(it.getRef(0) as WeatherType) }
                .function("playerWeather", returnsObject().noParams()) { it.setReturnRef(it.target?.playerWeather) }
                .function("resetPlayerWeather", returnsVoid().noParams()) { it.target?.resetPlayerWeather() }
                .function("expCooldown", returns(Type.I).noParams()) { it.setReturnInt(it.target?.expCooldown ?: 0) }
                .function("setExpCooldown", returnsVoid().params(Type.I)) { it.target?.setExpCooldown(it.getInt(0)) }
                .function("giveExp", returnsVoid().params(Type.I)) { it.target?.giveExp(it.getInt(0)) }
                .function("giveExpLevels", returnsVoid().params(Type.I)) { it.target?.giveExpLevels(it.getInt(0)) }
                .function("exp", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.exp ?: 0f) }
                .function("setExp", returnsVoid().params(Type.F)) { it.target?.setExp(it.getFloat(0)) }
                .function("level", returns(Type.I).noParams()) { it.setReturnInt(it.target?.level ?: 0) }
                .function("setLevel", returnsVoid().params(Type.I)) { it.target?.setLevel(it.getInt(0)) }
                .function("totalExperience", returns(Type.I).noParams()) { it.setReturnInt(it.target?.totalExperience ?: 0) }
                .function("setTotalExperience", returnsVoid().params(Type.I)) { it.target?.setTotalExperience(it.getInt(0)) }
                .function("sendExperienceChange", returnsVoid().params(Type.F)) {
                    it.target?.sendExperienceChange(it.getFloat(0))
                }
                .function("sendExperienceChange", returnsVoid().params(Type.F, Type.I)) {
                    it.target?.sendExperienceChange(it.getFloat(0), it.getInt(1))
                }
                .function("allowFlight", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowFlight ?: false) }
                .function("setAllowFlight", returnsVoid().params(Type.Z)) { it.target?.setAllowFlight(it.getBool(0)) }
                .function("hidePlayer", returnsVoid().params(Type.OBJECT)) {
                    it.target?.hidePlayer(it.getRef(0) as Player)
                }
                .function("hidePlayer", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.hidePlayer(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Player
                    )
                }
                .function("showPlayer", returnsVoid().params(Type.OBJECT)) {
                    it.target?.showPlayer(it.getRef(0) as Player)
                }
                .function("showPlayer", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.showPlayer(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Player
                    )
                }
                .function("canSee", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool((when (val var1 = it.getRef(0)) {
                        is Player -> it.target?.canSee(var1)
                        is Entity -> it.target?.canSee(var1)
                        else -> throw IllegalArgumentException("参数必须是 Player 或 Entity 类型")
                    }) ?: false)
                }
                .function("hideEntity", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.hideEntity(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Entity
                    )
                }
                .function("showEntity", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.showEntity(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Entity
                    )
                }
                .function("setFlying", returnsVoid().params(Type.Z)) { it.target?.setFlying(it.getBool(0)) }
                .function("setFlySpeed", returnsVoid().params(Type.F)) { it.target?.setFlySpeed(it.getFloat(0)) }
                .function("setWalkSpeed", returnsVoid().params(Type.F)) { it.target?.setWalkSpeed(it.getFloat(0)) }
                .function("flySpeed", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.flySpeed ?: 0f) }
                .function("walkSpeed", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.walkSpeed ?: 0f) }
                .function("setTexturePack", returnsVoid().params(Type.STRING)) { it.target?.setTexturePack(it.getString(0)!!) }
                .function("setResourcePack", returnsVoid().params(Type.STRING)) {
                    it.target?.setResourcePack(it.getString(0)!!)
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.setResourcePack(
                        it.getString(0)!!,
                        it.getRef(1) as ByteArray
                    )
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.OBJECT, Type.OBJECT)) {
                    when (val var3 = it.getRef(2)) {
                        is String -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as? ByteArray,
                            var3
                        )

                        is Boolean -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as? ByteArray,
                            var3
                        )

                        else -> throw IllegalArgumentException("参数 3 必须是 String 或 Boolean 类型")
                    }
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.OBJECT, Type.STRING, Type.Z)) {
                    it.target?.setResourcePack(
                        it.getString(0)!!,
                        it.getRef(1) as ByteArray,
                        it.getString(2),
                        it.getBool(3)
                    )
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.STRING, Type.OBJECT, Type.STRING, Type.Z)) {
                    it.target?.setResourcePack(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray,
                        it.getString(3),
                        it.getBool(4)
                    )
                }
                .function("addResourcePack", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.addResourcePack(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray,
                        it.getString(3),
                        it.getBool(4)
                    )
                }
                .function("removeResourcePack", returnsVoid().params(Type.STRING)) { it.target?.removeResourcePack(UUID.fromString(it.getString(0))) }
                .function("removeResourcePacks", returnsVoid().noParams()) { it.target?.removeResourcePacks() }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("setScoreboard", returnsVoid().params(Type.OBJECT)) { it.target?.setScoreboard(it.getRef(0) as Scoreboard) }
                .function("worldBorder", returnsObject().noParams()) { it.setReturnRef(it.target?.worldBorder) }
                .function("setWorldBorder", returnsVoid().params(Type.OBJECT)) { it.target?.setWorldBorder(it.getRef(0) as WorldBorder) }
                .function("sendHealthUpdate", returnsVoid().noParams()) {
                    it.target?.sendHealthUpdate()
                }
                .function("sendHealthUpdate", returnsVoid().params(Type.D, Type.I, Type.F)) {
                    it.target?.sendHealthUpdate(
                        it.getDouble(0),
                        it.getInt(1),
                        it.getFloat(2)
                    )
                }
                .function("setHealthScaled", returnsVoid().params(Type.Z)) { it.target?.setHealthScaled(it.getBool(0)) }
                .function("setHealthScale", returnsVoid().params(Type.D)) { it.target?.setHealthScale(it.getDouble(0)) }
                .function("healthScale", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.healthScale ?: 0.0) }
                .function("spectatorTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.spectatorTarget) }
                .function("setSpectatorTarget", returnsVoid().params(Type.OBJECT)) { it.target?.setSpectatorTarget(it.getRef(0) as Entity) }
                .function("sendTitle", returnsVoid().params(Type.STRING, Type.STRING)) {
                    it.target?.sendTitle(it.getString(0), it.getString(1))
                }
                .function("sendTitle", returnsVoid().params(Type.STRING, Type.STRING, Type.I, Type.I, Type.I)) {
                    it.target?.sendTitle(
                        it.getString(0),
                        it.getString(1),
                        it.getInt(2),
                        it.getInt(3),
                        it.getInt(4)
                    )
                }
                .function("resetTitle", returnsVoid().noParams()) { it.target?.resetTitle() }
                .function("spawnParticle", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getRef(1) as Location,
                        it.getInt(2).toInt()
                    )
                }
                .function("spawnParticle", returnsVoid().params(Type.OBJECT, Type.D, Type.D, Type.D, Type.I)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getInt(4).toInt()
                    )
                }
                .function("spawnParticle", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getRef(1) as Location,
                        it.getInt(2).toInt(),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getDouble(5)
                    )
                }
                .function("spawnParticle", returnsVoid().params(Type.OBJECT, Type.OBJECT, Type.I, Type.D, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getRef(1) as Location,
                        it.getInt(2).toInt(),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getDouble(5),
                        it.getDouble(6)
                    )
                }
                .function("spawnParticle", returnsVoid().params(Type.OBJECT, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getInt(4).toInt(),
                        it.getDouble(5),
                        it.getDouble(6),
                        it.getDouble(7)
                    )
                }
                .function("spawnParticle", returnsVoid().params(Type.OBJECT, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getInt(4).toInt(),
                        it.getDouble(5),
                        it.getDouble(6),
                        it.getDouble(7),
                        it.getDouble(8)
                    )
                }
                .function("getAdvancementProgress", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAdvancementProgress(it.getRef(0) as Advancement)) }
                .function("clientViewDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.clientViewDistance ?: 0) }
                .function("ping", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ping ?: 0) }
                .function("locale", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.locale) }
                .function("updateCommands", returnsVoid().noParams()) { it.target?.updateCommands() }
                .function("openBook", returnsVoid().params(Type.OBJECT)) { it.target?.openBook(it.getRef(0) as ItemStack) }
                .function("openSign", returnsVoid().params(Type.OBJECT)) {
                    it.target?.openSign(it.getRef(0) as Sign)
                }
                .function("openSign", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.openSign(it.getRef(0) as Sign, it.getRef(1) as Side)
                }
                .function("showDemoScreen", returnsVoid().noParams()) { it.target?.showDemoScreen() }
                .function("isAllowingServerListings", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAllowingServerListings ?: false) }
//                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName()) }
//                .function("locale", returnsObject().noParams()) { it.setReturnRef(it.target?.locale()) }
//                .function("playerListFooter", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListFooter()) }
//                .function("playerListHeader", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListHeader()) }
//                .function("playerListName", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListName()) }
        }
    }
}
