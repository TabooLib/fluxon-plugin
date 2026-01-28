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
                .function("setDisplayName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplayName(it.getString(0))) }
                .function("playerListName", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListName) }
                .function("setPlayerListName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPlayerListName(it.getString(0))) }
                .function("playerListHeader", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListHeader) }
                .function("playerListFooter", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListFooter) }
                .function("setPlayerListHeader", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPlayerListHeader(it.getString(0))) }
                .function("setPlayerListFooter", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPlayerListFooter(it.getString(0))) }
                .function("setPlayerListHeaderFooter", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setPlayerListHeaderFooter(
                        it.getString(0),
                        it.getString(1)
                    ))
                }
                .function("setCompassTarget", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCompassTarget(it.getRef(0) as Location)) }
                .function("compassTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.compassTarget) }
                .function("address", returnsObject().noParams()) { it.setReturnRef(it.target?.address) }
                .function("isTransferred", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isTransferred) }
                .function("sendRawMessage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.sendRawMessage(it.getString(0)!!)) }
                .syncFunction("kickPlayer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.kickPlayer(it.getString(0))) }
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
                .syncFunction("chat", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.chat(it.getString(0)!!)) }
                .syncFunction("performCommand", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.performCommand(it.getString(0)!!)) }
                .function("isOnGround", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isOnGround) }
                .function("isSneaking", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSneaking) }
                .function("setSneaking", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSneaking(it.getBool(0))) }
                .function("isSprinting", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSprinting) }
                .function("setSprinting", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSprinting(it.getBool(0))) }
                .function("saveData", returnsObject().noParams()) { it.setReturnRef(it.target?.saveData()) }
                .function("loadData", returnsObject().noParams()) { it.setReturnRef(it.target?.loadData()) }
                .function("setSleepingIgnored", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSleepingIgnored(it.getBool(0))) }
                .function("isSleepingIgnored", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSleepingIgnored) }
                .function("bedSpawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.bedSpawnLocation) }
                .function("respawnLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.respawnLocation) }
                .function("setBedSpawnLocation", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setBedSpawnLocation(it.getRef(0) as Location)
                    } else {
                        it.target?.setBedSpawnLocation(
                            it.getRef(0) as Location,
                            it.getBool(1)
                        )
                    })
                }
                .function("setBedSpawnLocation", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setBedSpawnLocation(it.getRef(0) as Location)
                    } else {
                        it.target?.setBedSpawnLocation(
                            it.getRef(0) as Location,
                            it.getBool(1)
                        )
                    })
                }
                .function("setRespawnLocation", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setRespawnLocation(it.getRef(0) as Location)
                    } else {
                        it.target?.setRespawnLocation(
                            it.getRef(0) as Location,
                            it.getBool(1)
                        )
                    })
                }
                .function("setRespawnLocation", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setRespawnLocation(it.getRef(0) as Location)
                    } else {
                        it.target?.setRespawnLocation(
                            it.getRef(0) as Location,
                            it.getBool(1)
                        )
                    })
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
                .function("playSound", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        4 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
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

                        6 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
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
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }
                        else -> error("Player#playSound 函数参数数量错误: ${"args"}")
                    })
                }
                .function("playSound", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        4 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
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

                        6 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
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
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }
                        else -> error("Player#playSound 函数参数数量错误: ${"args"}")
                    })
                }
                .function("playSound", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        4 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            is Entity -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getFloat(2),
                                    it.getFloat(3)
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }

                        5 -> when (val var1 = it.getRef(0)) {
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

                        6 -> when (val var1 = it.getRef(0)) {
                            is Location -> when (val var2 = it.getRef(1)) {
                                is Sound -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
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
                                    it.getInt(5).toLong()
                                )

                                is String -> it.target?.playSound(
                                    var1,
                                    var2,
                                    it.getRef(2) as SoundCategory,
                                    it.getFloat(3),
                                    it.getFloat(4),
                                    it.getInt(5).toLong()
                                )

                                else -> throw IllegalArgumentException("参数 2 必须是 Sound 或 String 类型")
                            }

                            else -> throw IllegalArgumentException("参数 1 必须是 Location 或 Entity 类型")
                        }
                        else -> error("Player#playSound 函数参数数量错误: ${"args"}")
                    })
                }
                .function("stopSound", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Sound -> it.target?.stopSound(var1)
                            is String -> it.target?.stopSound(var1)
                            is SoundCategory -> it.target?.stopSound(var1)
                            else -> throw IllegalArgumentException("参数必须是 Sound, String, 或 SoundCategory 类型")
                        }
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Sound -> it.target?.stopSound(var1, it.getRef(1) as? SoundCategory)
                            is String -> it.target?.stopSound(var1, it.getRef(1) as? SoundCategory)
                            else -> throw IllegalArgumentException("参数 1 必须是 Sound 或 String 类型")
                        }
                    })
                }
                .function("stopSound", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Sound -> it.target?.stopSound(var1)
                            is String -> it.target?.stopSound(var1)
                            is SoundCategory -> it.target?.stopSound(var1)
                            else -> throw IllegalArgumentException("参数必须是 Sound, String, 或 SoundCategory 类型")
                        }
                    } else {
                        when (val var1 = it.getRef(0)) {
                            is Sound -> it.target?.stopSound(var1, it.getRef(1) as? SoundCategory)
                            is String -> it.target?.stopSound(var1, it.getRef(1) as? SoundCategory)
                            else -> throw IllegalArgumentException("参数 1 必须是 Sound 或 String 类型")
                        }
                    })
                }
                .function("stopAllSounds", returnsObject().noParams()) { it.setReturnRef(it.target?.stopAllSounds()) }
                .function("playEffect", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.playEffect(
                        it.getRef(0) as Location,
                        it.getRef(1) as Effect,
                        it.getInt(2).toInt()
                    ))
                }
                .function("breakBlock", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.breakBlock(it.getRef(0) as Block)) }
                .function("sendBlockChange", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendBlockChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as BlockData
                        )
                    } else {
                        it.target?.sendBlockChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Material,
                            it.getInt(2).toByte()
                        )
                    })
                }
                .function("sendBlockChange", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendBlockChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as BlockData
                        )
                    } else {
                        it.target?.sendBlockChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Material,
                            it.getInt(2).toByte()
                        )
                    })
                }
                .function("sendBlockChanges", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>)
                    } else {
                        it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>, it.getBool(1))
                    })
                }
                .function("sendBlockChanges", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>)
                    } else {
                        it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>, it.getBool(1))
                    })
                }
                .function("sendBlockDamage", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendBlockDamage(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )
                    } else {
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
                    })
                }
                .function("sendBlockDamage", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendBlockDamage(
                            it.getRef(0) as Location,
                            it.getFloat(1)
                        )
                    } else {
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
                    })
                }
                .function("sendEquipmentChange", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendEquipmentChange(
                            it.getRef(0) as LivingEntity,
                            it.getRef(1) as Map<EquipmentSlot, ItemStack>
                        )
                    } else {
                        it.target?.sendEquipmentChange(
                            it.getRef(0) as LivingEntity,
                            it.getRef(1) as EquipmentSlot,
                            it.getRef(2) as ItemStack
                        )
                    })
                }
                .function("sendEquipmentChange", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendEquipmentChange(
                            it.getRef(0) as LivingEntity,
                            it.getRef(1) as Map<EquipmentSlot, ItemStack>
                        )
                    } else {
                        it.target?.sendEquipmentChange(
                            it.getRef(0) as LivingEntity,
                            it.getRef(1) as EquipmentSlot,
                            it.getRef(2) as ItemStack
                        )
                    })
                }
                .function("sendSignChange", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>
                        )

                        3 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>,
                            it.getRef(2) as DyeColor
                        )

                        4 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>,
                            it.getRef(2) as DyeColor,
                            it.getBool(3)
                        )
                        else -> error("Player#sendSignChange 函数参数数量错误: ${"args"}")
                    })
                }
                .function("sendSignChange", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>
                        )

                        3 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>,
                            it.getRef(2) as DyeColor
                        )

                        4 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>,
                            it.getRef(2) as DyeColor,
                            it.getBool(3)
                        )
                        else -> error("Player#sendSignChange 函数参数数量错误: ${"args"}")
                    })
                }
                .function("sendSignChange", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        2 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>
                        )

                        3 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>,
                            it.getRef(2) as DyeColor
                        )

                        4 -> it.target?.sendSignChange(
                            it.getRef(0) as Location,
                            it.getRef(1) as Array<String>,
                            it.getRef(2) as DyeColor,
                            it.getBool(3)
                        )
                        else -> error("Player#sendSignChange 函数参数数量错误: ${"args"}")
                    })
                }
                .function("sendPotionEffectChange", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.sendPotionEffectChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as PotionEffect
                    ))
                }
                .function("sendPotionEffectChangeRemove", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.sendPotionEffectChangeRemove(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as PotionEffectType
                    ))
                }
                .function("sendMap", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.sendMap(it.getRef(0) as MapView)) }
                .function("sendHurtAnimation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.sendHurtAnimation(it.getFloat(0))) }
                .function("addCustomChatCompletions", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addCustomChatCompletions(it.getRef(0) as Collection<String>)) }
                .function("removeCustomChatCompletions", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeCustomChatCompletions(it.getRef(0) as Collection<String>)) }
                .function("setCustomChatCompletions", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCustomChatCompletions(it.getRef(0) as Collection<String>)) }
                .function("previousGameMode", returnsObject().noParams()) { it.setReturnRef(it.target?.previousGameMode) }
                .function("setPlayerTime", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setPlayerTime(it.getInt(0).toLong(), false)
                    } else {
                        it.target?.setPlayerTime(it.getInt(0).toLong(), it.getBool(1))
                    })
                }
                .function("setPlayerTime", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.setPlayerTime(it.getInt(0).toLong(), false)
                    } else {
                        it.target?.setPlayerTime(it.getInt(0).toLong(), it.getBool(1))
                    })
                }
                .function("playerTime", returnsObject().noParams()) { it.setReturnRef(it.target?.playerTime) }
                .function("playerTimeOffset", returnsObject().noParams()) { it.setReturnRef(it.target?.playerTimeOffset) }
                .function("isPlayerTimeRelative", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPlayerTimeRelative) }
                .function("resetPlayerTime", returnsObject().noParams()) { it.setReturnRef(it.target?.resetPlayerTime()) }
                .function("setPlayerWeather", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPlayerWeather(it.getRef(0) as WeatherType)) }
                .function("playerWeather", returnsObject().noParams()) { it.setReturnRef(it.target?.playerWeather) }
                .function("resetPlayerWeather", returnsObject().noParams()) { it.setReturnRef(it.target?.resetPlayerWeather()) }
                .function("expCooldown", returnsObject().noParams()) { it.setReturnRef(it.target?.expCooldown) }
                .function("setExpCooldown", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExpCooldown(it.getInt(0).toInt())) }
                .function("giveExp", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.giveExp(it.getInt(0).toInt())) }
                .function("giveExpLevels", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.giveExpLevels(it.getInt(0).toInt())) }
                .function("exp", returnsObject().noParams()) { it.setReturnRef(it.target?.exp) }
                .function("setExp", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExp(it.getFloat(0))) }
                .function("level", returnsObject().noParams()) { it.setReturnRef(it.target?.level) }
                .function("setLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLevel(it.getInt(0).toInt())) }
                .function("totalExperience", returnsObject().noParams()) { it.setReturnRef(it.target?.totalExperience) }
                .function("setTotalExperience", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTotalExperience(it.getInt(0).toInt())) }
                .function("sendExperienceChange", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.sendExperienceChange(it.getFloat(0))
                    } else {
                        it.target?.sendExperienceChange(
                            it.getFloat(0),
                            it.getInt(1).toInt()
                        )
                    })
                }
                .function("sendExperienceChange", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.sendExperienceChange(it.getFloat(0))
                    } else {
                        it.target?.sendExperienceChange(
                            it.getFloat(0),
                            it.getInt(1).toInt()
                        )
                    })
                }
                .function("allowFlight", returnsObject().noParams()) { it.setReturnRef(it.target?.allowFlight) }
                .function("setAllowFlight", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAllowFlight(it.getBool(0))) }
                .function("hidePlayer", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.hidePlayer(it.getRef(0) as Player)
                    } else {
                        it.target?.hidePlayer(
                            it.getRef(0) as Plugin,
                            it.getRef(1) as Player
                        )
                    })
                }
                .function("hidePlayer", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.hidePlayer(it.getRef(0) as Player)
                    } else {
                        it.target?.hidePlayer(
                            it.getRef(0) as Plugin,
                            it.getRef(1) as Player
                        )
                    })
                }
                .function("showPlayer", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.showPlayer(it.getRef(0) as Player)
                    } else {
                        it.target?.showPlayer(
                            it.getRef(0) as Plugin,
                            it.getRef(1) as Player
                        )
                    })
                }
                .function("showPlayer", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.showPlayer(it.getRef(0) as Player)
                    } else {
                        it.target?.showPlayer(
                            it.getRef(0) as Plugin,
                            it.getRef(1) as Player
                        )
                    })
                }
                .function("canSee", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Player -> it.target?.canSee(var1)
                        is Entity -> it.target?.canSee(var1)
                        else -> throw IllegalArgumentException("参数必须是 Player 或 Entity 类型")
                    })
                }
                .function("hideEntity", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.hideEntity(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Entity
                    ))
                }
                .function("showEntity", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.showEntity(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Entity
                    ))
                }
                .function("isFlying", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFlying) }
                .function("setFlying", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFlying(it.getBool(0))) }
                .function("setFlySpeed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFlySpeed(it.getFloat(0))) }
                .function("setWalkSpeed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWalkSpeed(it.getFloat(0))) }
                .function("flySpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.flySpeed) }
                .function("walkSpeed", returnsObject().noParams()) { it.setReturnRef(it.target?.walkSpeed) }
                .function("setTexturePack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTexturePack(it.getString(0)!!)) }
                .function("setResourcePack", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setResourcePack(it.getString(0)!!)
                        2 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray
                        )

                        3 -> when (val var3 = it.getRef(2)) {
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

                        4 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray,
                            it.getString(2),
                            it.getBool(3)
                        )

                        5 -> it.target?.setResourcePack(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)!!,
                            it.getRef(2) as ByteArray,
                            it.getString(3),
                            it.getBool(4)
                        )
                        else -> error("Player#setResourcePack 函数参数数量错误: ${"args"}")
                    })
                }
                .function("setResourcePack", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setResourcePack(it.getString(0)!!)
                        2 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray
                        )

                        3 -> when (val var3 = it.getRef(2)) {
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

                        4 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray,
                            it.getString(2),
                            it.getBool(3)
                        )

                        5 -> it.target?.setResourcePack(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)!!,
                            it.getRef(2) as ByteArray,
                            it.getString(3),
                            it.getBool(4)
                        )
                        else -> error("Player#setResourcePack 函数参数数量错误: ${"args"}")
                    })
                }
                .function("setResourcePack", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setResourcePack(it.getString(0)!!)
                        2 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray
                        )

                        3 -> when (val var3 = it.getRef(2)) {
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

                        4 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray,
                            it.getString(2),
                            it.getBool(3)
                        )

                        5 -> it.target?.setResourcePack(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)!!,
                            it.getRef(2) as ByteArray,
                            it.getString(3),
                            it.getBool(4)
                        )
                        else -> error("Player#setResourcePack 函数参数数量错误: ${"args"}")
                    })
                }
                .function("setResourcePack", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setResourcePack(it.getString(0)!!)
                        2 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray
                        )

                        3 -> when (val var3 = it.getRef(2)) {
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

                        4 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray,
                            it.getString(2),
                            it.getBool(3)
                        )

                        5 -> it.target?.setResourcePack(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)!!,
                            it.getRef(2) as ByteArray,
                            it.getString(3),
                            it.getBool(4)
                        )
                        else -> error("Player#setResourcePack 函数参数数量错误: ${"args"}")
                    })
                }
                .function("setResourcePack", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> it.target?.setResourcePack(it.getString(0)!!)
                        2 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray
                        )

                        3 -> when (val var3 = it.getRef(2)) {
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

                        4 -> it.target?.setResourcePack(
                            it.getString(0)!!,
                            it.getRef(1) as ByteArray,
                            it.getString(2),
                            it.getBool(3)
                        )

                        5 -> it.target?.setResourcePack(
                            UUID.fromString(it.getString(0)),
                            it.getString(1)!!,
                            it.getRef(2) as ByteArray,
                            it.getString(3),
                            it.getBool(4)
                        )
                        else -> error("Player#setResourcePack 函数参数数量错误: ${"args"}")
                    })
                }
                .function("addResourcePack", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addResourcePack(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray,
                        it.getString(3),
                        it.getBool(4)
                    ))
                }
                .function("removeResourcePack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeResourcePack(UUID.fromString(it.getString(0)))) }
                .function("removeResourcePacks", returnsObject().noParams()) { it.setReturnRef(it.target?.removeResourcePacks()) }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("setScoreboard", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setScoreboard(it.getRef(0) as Scoreboard)) }
                .function("worldBorder", returnsObject().noParams()) { it.setReturnRef(it.target?.worldBorder) }
                .function("setWorldBorder", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setWorldBorder(it.getRef(0) as WorldBorder)) }
                .function("sendHealthUpdate", returnsObject().noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.sendHealthUpdate()
                    } else {
                        it.target?.sendHealthUpdate(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getFloat(2)
                        )
                    })
                }
                .function("sendHealthUpdate", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.sendHealthUpdate()
                    } else {
                        it.target?.sendHealthUpdate(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getFloat(2)
                        )
                    })
                }
                .function("isHealthScaled", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isHealthScaled) }
                .function("setHealthScaled", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHealthScaled(it.getBool(0))) }
                .function("setHealthScale", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHealthScale(it.getAsDouble(0))) }
                .function("healthScale", returnsObject().noParams()) { it.setReturnRef(it.target?.healthScale) }
                .function("spectatorTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.spectatorTarget) }
                .function("setSpectatorTarget", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpectatorTarget(it.getRef(0) as Entity)) }
                .function("sendTitle", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendTitle(it.getString(0), it.getString(1))
                    } else {
                        it.target?.sendTitle(
                            it.getString(0),
                            it.getString(1),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getInt(4).toInt()
                        )
                    })
                }
                .function("sendTitle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 2) {
                        it.target?.sendTitle(it.getString(0), it.getString(1))
                    } else {
                        it.target?.sendTitle(
                            it.getString(0),
                            it.getString(1),
                            it.getInt(2).toInt(),
                            it.getInt(3).toInt(),
                            it.getInt(4).toInt()
                        )
                    })
                }
                .function("resetTitle", returnsObject().noParams()) { it.setReturnRef(it.target?.resetTitle()) }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("spawnParticle", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt()
                        )

                        5 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt()
                        )

                        6 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )

                        7 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getRef(1) as Location,
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getAsDouble(6)
                        )

                        8 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7)
                        )

                        9 -> it.target?.spawnParticle(
                            it.getRef(0) as Particle,
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getInt(4).toInt(),
                            it.getAsDouble(5),
                            it.getAsDouble(6),
                            it.getAsDouble(7),
                            it.getAsDouble(8)
                        )
                        else -> error("Player#spawnParticle 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getAdvancementProgress", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getAdvancementProgress(it.getRef(0) as Advancement)) }
                .function("clientViewDistance", returnsObject().noParams()) { it.setReturnRef(it.target?.clientViewDistance) }
                .function("ping", returnsObject().noParams()) { it.setReturnRef(it.target?.ping) }
                .function("locale", returnsObject().noParams()) { it.setReturnRef(it.target?.locale) }
                .function("updateCommands", returnsObject().noParams()) { it.setReturnRef(it.target?.updateCommands()) }
                .function("openBook", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.openBook(it.getRef(0) as ItemStack)) }
                .function("openSign", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.openSign(it.getRef(0) as Sign)
                    } else {
                        it.target?.openSign(it.getRef(0) as Sign, it.getRef(1) as Side)
                    })
                }
                .function("openSign", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.openSign(it.getRef(0) as Sign)
                    } else {
                        it.target?.openSign(it.getRef(0) as Sign, it.getRef(1) as Side)
                    })
                }
                .function("showDemoScreen", returnsObject().noParams()) { it.setReturnRef(it.target?.showDemoScreen()) }
                .function("isAllowingServerListings", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAllowingServerListings) }
//                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName()) }
//                .function("locale", returnsObject().noParams()) { it.setReturnRef(it.target?.locale()) }
//                .function("playerListFooter", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListFooter()) }
//                .function("playerListHeader", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListHeader()) }
//                .function("playerListName", returnsObject().noParams()) { it.setReturnRef(it.target?.playerListName()) }
        }
    }
}
