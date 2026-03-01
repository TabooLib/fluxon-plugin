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
            registerFunction("player", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnRef(Bukkit.getPlayer(it.getRef(0) as UUID)) }
            registerFunction("player", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE).params(Type.STRING)) { it.setReturnRef(Bukkit.getPlayerExact(it.getString(0)!!)) }
            registerFunction("players", returns(Type.LIST).noParams()) { it.setReturnRef(onlinePlayers) }

            registerExtension(Player::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("displayName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsVoid().params(Type.STRING)) { it.target?.setDisplayName(it.getString(0)) }
                .function("playerListName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.playerListName) }
                .function("setPlayerListName", returnsVoid().params(Type.STRING)) { it.target?.setPlayerListName(it.getString(0)) }
                .function("playerListHeader", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.playerListHeader) }
                .function("playerListFooter", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.playerListFooter) }
                .function("setPlayerListHeader", returnsVoid().params(Type.STRING)) { it.target?.setPlayerListHeader(it.getString(0)) }
                .function("setPlayerListFooter", returnsVoid().params(Type.STRING)) { it.target?.setPlayerListFooter(it.getString(0)) }
                .function("setPlayerListHeaderFooter", returnsVoid().params(Type.STRING, Type.STRING)) {
                    it.target?.setPlayerListHeaderFooter(
                        it.getString(0),
                        it.getString(1)
                    )
                }
                .function("setCompassTarget",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.target?.setCompassTarget(it.getRef(0) as Location) }
                .function("compassTarget", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.compassTarget) }
                .function("address", returns(Type.fromClass(java.net.InetSocketAddress::class.java)).noParams()) { it.setReturnRef(it.target?.address) }
                .function("isTransferred", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTransferred ?: false) }
                .function("sendRawMessage", returnsVoid().params(Type.STRING)) { it.target?.sendRawMessage(it.getString(0)!!) }
                .syncFunction("kickPlayer", returnsVoid().params(Type.STRING)) { it.target?.kickPlayer(it.getString(0)) }
                .function("ban",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, org.tabooproject.fluxon.util.StandardTypes.DATE, Type.STRING, Type.Z)) { it.setReturnRef(it.target?.ban(it.getString(0), it.getRef(1) as Date, it.getString(2), it.getBool(3))) }
                .function("ban",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.fromClass(Instant::class.java), Type.STRING, Type.Z)) { it.setReturnRef(it.target?.ban(it.getString(0), it.getRef(1) as Instant, it.getString(2), it.getBool(3))) }
                .function("ban",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.fromClass(Duration::class.java), Type.STRING, Type.Z)) { it.setReturnRef(it.target?.ban(it.getString(0), it.getRef(1) as Duration, it.getString(2), it.getBool(3))) }
                .function("banIp",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, org.tabooproject.fluxon.util.StandardTypes.DATE, Type.STRING, Type.Z)) { it.setReturnRef(it.target?.banIp(it.getString(0), it.getRef(1) as Date, it.getString(2), it.getBool(3))) }
                .function("banIp",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.fromClass(Instant::class.java), Type.STRING, Type.Z)) { it.setReturnRef(it.target?.banIp(it.getString(0), it.getRef(1) as Instant, it.getString(2), it.getBool(3))) }
                .function("banIp",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry.TYPE).params(Type.STRING, Type.fromClass(Duration::class.java), Type.STRING, Type.Z)) { it.setReturnRef(it.target?.banIp(it.getString(0), it.getRef(1) as Duration, it.getString(2), it.getBool(3))) }
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
                .function("bedSpawnLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.bedSpawnLocation) }
                .function("respawnLocation", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.respawnLocation) }
                .function("setBedSpawnLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.target?.setBedSpawnLocation(it.getRef(0) as Location)
                }
                .function("setBedSpawnLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z)) {
                    it.target?.setBedSpawnLocation(it.getRef(0) as Location, it.getBool(1))
                }
                .function("setRespawnLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.target?.setRespawnLocation(it.getRef(0) as Location)
                }
                .function("setRespawnLocation",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.Z)) {
                    it.target?.setRespawnLocation(it.getRef(0) as Location, it.getBool(1))
                }
                .function("playNote",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.I)) { it.target?.playNote(it.getRef(0) as Location, it.getInt(1).toByte(), it.getInt(2).toByte()) }
                .function("playNote",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnInstrument.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE)) { it.target?.playNote(it.getRef(0) as Location, it.getRef(1) as Instrument, it.getRef(2) as Note) }
                .function("playNote",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNote.TYPE)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnInstrument.enumValue(it.getString(1))?.let { p1 ->
                        it.target?.playNote(it.getRef(0) as Location, p1, it.getRef(2) as Note)
                    }
                }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Location, it.getRef(1) as Sound, it.getFloat(2), it.getFloat(3)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Location, it.getString(1), it.getFloat(2), it.getFloat(3)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Entity, it.getRef(1) as Sound, it.getFloat(2), it.getFloat(3)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.STRING, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Entity, it.getString(1), it.getFloat(2), it.getFloat(3)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Location, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Location, it.getString(1), it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Entity, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F)) { it.target?.playSound(it.getRef(0) as Entity, it.getString(1), it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) { it.target?.playSound(it.getRef(0) as Location, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) { it.target?.playSound(it.getRef(0) as Location, it.getString(1), it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) { it.target?.playSound(it.getRef(0) as Entity, it.getRef(1) as Sound, it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5)) }
                .function("playSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE, Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE, Type.F, Type.F, Type.J)) { it.target?.playSound(it.getRef(0) as Entity, it.getString(1), it.getRef(2) as SoundCategory, it.getFloat(3), it.getFloat(4), it.getLong(5)) }
                .function("stopSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE)) { it.target?.stopSound(it.getRef(0) as Sound) }
                .function("stopSound", returnsVoid().params(Type.STRING)) { it.target?.stopSound(it.getString(0)) }
                .function("stopSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE)) { it.target?.stopSound(it.getRef(0) as SoundCategory) }
                .function("stopSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE)) { it.target?.stopSound(it.getRef(0) as Sound, it.getRef(1) as SoundCategory) }
                .function("stopSound", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSound.TYPE, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.enumValue(it.getString(1))?.let { p1 ->
                        it.target?.stopSound(
                            it.getRef(0) as Sound,
                            p1
                        )
                    }
                }
                .function("stopSound", returnsVoid().params(Type.STRING, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.TYPE)) { it.target?.stopSound(it.getString(0), it.getRef(1) as SoundCategory) }
                .function("stopSound", returnsVoid().params(Type.STRING, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnSoundCategory.enumValue(it.getString(1))?.let { p1 ->
                        it.target?.stopSound(
                            it.getString(0),
                            p1
                        )
                    }
                }
                .function("stopAllSounds", returnsVoid().noParams()) { it.target?.stopAllSounds() }
                .function("playEffect",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnEffect.TYPE, Type.I)) {
                    it.target?.playEffect(
                        it.getRef(0) as Location,
                        it.getRef(1) as Effect,
                        it.getInt(2)
                    )
                }
                .function("breakBlock",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE)) {
                    it.setReturnBool(it.target?.breakBlock(it.getRef(0) as Block) ?: false)
                }
                .function("sendBlockChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) {
                    it.target?.sendBlockChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as BlockData
                    )
                }
                .function("sendBlockChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE, Type.I)) {
                    it.target?.sendBlockChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Material,
                        it.getInt(2).toByte()
                    )
                }
                .function("sendBlockChanges",returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) {
                    it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>)
                }
                .function("sendBlockChanges",returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION, Type.Z)) {
                    it.target?.sendBlockChanges(it.getRef(0) as Collection<BlockState>, it.getBool(1))
                }
                .function("sendBlockDamage",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.F)) {
                    it.target?.sendBlockDamage(
                        it.getRef(0) as Location,
                        it.getFloat(1)
                    )
                }
                .function("sendBlockDamage",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.F, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.sendBlockDamage(it.getRef(0) as Location, it.getFloat(1), it.getRef(2) as Entity) }
                .function("sendBlockDamage",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.F, Type.I)) { it.target?.sendBlockDamage(it.getRef(0) as Location, it.getFloat(1), it.getInt(2)) }
                .function("sendEquipmentChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE, Type.MAP)) {
                    it.target?.sendEquipmentChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as Map<EquipmentSlot, ItemStack>
                    )
                }
                .function("sendEquipmentChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) {
                    it.target?.sendEquipmentChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as EquipmentSlot,
                        it.getRef(2) as ItemStack
                    )
                }
                .function("sendSignChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) {
                    it.target?.sendSignChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Array<String>
                    )
                }
                .function("sendSignChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE)) {
                    it.target?.sendSignChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Array<String>,
                        it.getRef(2) as DyeColor
                    )
                }
                .function("sendSignChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.TYPE, Type.Z)) {
                    it.target?.sendSignChange(
                        it.getRef(0) as Location,
                        it.getRef(1) as Array<String>,
                        it.getRef(2) as DyeColor,
                        it.getBool(3)
                    )
                }
                .function("sendSignChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY, Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.enumValue(it.getString(2))?.let { p2 ->
                        it.target?.sendSignChange(it.getRef(0) as Location, it.getRef(1) as Array<String>, p2)
                    }
                }
                .function("sendSignChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY, Type.STRING, Type.Z)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor.enumValue(it.getString(2))?.let { p2 ->
                        it.target?.sendSignChange(it.getRef(0) as Location, it.getRef(1) as Array<String>, p2, it.getBool(3))
                    }
                }
                .function("sendPotionEffectChange",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffect.TYPE)) {
                    it.target?.sendPotionEffectChange(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as PotionEffect
                    )
                }
                .function("sendPotionEffectChangeRemove",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnLivingEntity.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.potion.FnPotionEffectType.TYPE)) {
                    it.target?.sendPotionEffectChangeRemove(
                        it.getRef(0) as LivingEntity,
                        it.getRef(1) as PotionEffectType
                    )
                }
                .function("sendMap",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.map.FnMapView.TYPE)) { it.target?.sendMap(it.getRef(0) as MapView) }
                .function("sendHurtAnimation", returnsVoid().params(Type.F)) { it.target?.sendHurtAnimation(it.getFloat(0)) }
                .function("addCustomChatCompletions",returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) { it.target?.addCustomChatCompletions(it.getRef(0) as Collection<String>) }
                .function("removeCustomChatCompletions",returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) { it.target?.removeCustomChatCompletions(it.getRef(0) as Collection<String>) }
                .function("setCustomChatCompletions",returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) { it.target?.setCustomChatCompletions(it.getRef(0) as Collection<String>) }
                .function("previousGameMode", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameMode.TYPE).noParams()) { it.setReturnRef(it.target?.previousGameMode) }
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
                .function("setPlayerWeather", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWeatherType.TYPE)) { it.target?.setPlayerWeather(it.getRef(0) as WeatherType) }
                .function("setPlayerWeather", returnsVoid().params(Type.STRING)) {
                    org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWeatherType.enumValue(it.getString(0))?.let { p0 -> it.target?.setPlayerWeather(p0) }
                }
                .function("playerWeather", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWeatherType.TYPE).noParams()) { it.setReturnRef(it.target?.playerWeather) }
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
                .function("hidePlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.target?.hidePlayer(it.getRef(0) as Player)
                }
                .function("hidePlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.target?.hidePlayer(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Player
                    )
                }
                .function("showPlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.target?.showPlayer(it.getRef(0) as Player)
                }
                .function("showPlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) {
                    it.target?.showPlayer(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Player
                    )
                }
                .function("canSee", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) { it.setReturnBool(it.target?.canSee(it.getRef(0) as Player) ?: false) }
                .function("canSee", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.setReturnBool(it.target?.canSee(it.getRef(0) as Entity) ?: false) }
                .function("hideEntity",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) {
                    it.target?.hideEntity(
                        it.getRef(0) as Plugin,
                        it.getRef(1) as Entity
                    )
                }
                .function("showEntity",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) {
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
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.fromClass(ByteArray::class.java))) {
                    it.target?.setResourcePack(
                        it.getString(0)!!,
                        it.getRef(1) as ByteArray
                    )
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.fromClass(ByteArray::class.java), Type.STRING)) {
                    it.target?.setResourcePack(it.getString(0)!!, it.getRef(1) as ByteArray, it.getString(2))
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.fromClass(ByteArray::class.java), Type.Z)) {
                    it.target?.setResourcePack(it.getString(0)!!, it.getRef(1) as ByteArray, it.getBool(2))
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.fromClass(ByteArray::class.java), Type.STRING, Type.Z)) {
                    it.target?.setResourcePack(
                        it.getString(0)!!,
                        it.getRef(1) as ByteArray,
                        it.getString(2),
                        it.getBool(3)
                    )
                }
                .function("setResourcePack", returnsVoid().params(Type.STRING, Type.STRING, Type.fromClass(ByteArray::class.java), Type.STRING, Type.Z)) {
                    it.target?.setResourcePack(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)!!,
                        it.getRef(2) as ByteArray,
                        it.getString(3),
                        it.getBool(4)
                    )
                }
                .function("addResourcePack",returnsVoid().params(Type.STRING, Type.STRING, Type.fromClass(ByteArray::class.java), Type.STRING, Type.Z)) {
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
                .function("scoreboard", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScoreboard.TYPE).noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("setScoreboard",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScoreboard.TYPE)) { it.target?.setScoreboard(it.getRef(0) as Scoreboard) }
                .function("worldBorder", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldBorder.TYPE).noParams()) { it.setReturnRef(it.target?.worldBorder) }
                .function("setWorldBorder",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorldBorder.TYPE)) { it.target?.setWorldBorder(it.getRef(0) as WorldBorder) }
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
                .function("spectatorTarget", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.spectatorTarget) }
                .function("setSpectatorTarget",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.setSpectatorTarget(it.getRef(0) as Entity) }
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
                .function("spawnParticle",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getRef(1) as Location,
                        it.getInt(2).toInt()
                    )
                }
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, Type.D, Type.D, Type.D, Type.I)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getInt(4).toInt()
                    )
                }
                .function("spawnParticle",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.D, Type.D, Type.D)) {
                    it.target?.spawnParticle(
                        it.getRef(0) as Particle,
                        it.getRef(1) as Location,
                        it.getInt(2).toInt(),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getDouble(5)
                    )
                }
                .function("spawnParticle",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.I, Type.D, Type.D, Type.D, Type.D)) {
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
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D)) {
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
                .function("spawnParticle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnParticle.TYPE, Type.D, Type.D, Type.D, Type.I, Type.D, Type.D, Type.D, Type.D)) {
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
                .function("getAdvancementProgress",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement.FnAdvancementProgress.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement.FnAdvancement.TYPE)) { it.setReturnRef(it.target?.getAdvancementProgress(it.getRef(0) as Advancement)) }
                .function("clientViewDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.clientViewDistance ?: 0) }
                .function("ping", returns(Type.I).noParams()) { it.setReturnInt(it.target?.ping ?: 0) }
                .function("locale", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.locale) }
                .function("updateCommands", returnsVoid().noParams()) { it.target?.updateCommands() }
                .function("openBook",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.openBook(it.getRef(0) as ItemStack) }
                .function("openSign",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnSign.TYPE)) {
                    it.target?.openSign(it.getRef(0) as Sign)
                }
                .function("openSign",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnSign.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign.FnSide.TYPE)) {
                    it.target?.openSign(it.getRef(0) as Sign, it.getRef(1) as Side)
                }
                .function("showDemoScreen", returnsVoid().noParams()) { it.target?.showDemoScreen() }
                .function("isAllowingServerListings", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAllowingServerListings ?: false) }
//                .function("displayName", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.displayName()) }
//                .function("locale", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.locale()) }
//                .function("playerListFooter", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.playerListFooter()) }
//                .function("playerListHeader", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.playerListHeader()) }
//                .function("playerListName", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.playerListName()) }
        }
    }
}
