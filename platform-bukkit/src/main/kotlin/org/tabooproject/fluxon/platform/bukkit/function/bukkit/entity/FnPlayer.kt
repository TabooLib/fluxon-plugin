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
import java.util.*

object FnPlayer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
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
                .function("kickPlayer", 1) { it.target?.kickPlayer(it.getString(0)) }
                .function("ban", 4) {
                    // BanEntry<PlayerProfile> ban(@Nullable String var1, @Nullable Date var2, @Nullable String var3, boolean var4)
                    // BanEntry<PlayerProfile> ban(@Nullable String var1, @Nullable Instant var2, @Nullable String var3, boolean var4)
                    // BanEntry<PlayerProfile> ban(@Nullable String var1, @Nullable Duration var2, @Nullable String var3, boolean var4)
                    TODO()
                }
                .function("banIp", 4) {
                    // BanEntry<InetAddress> banIp(@Nullable String var1, @Nullable Date var2, @Nullable String var3, boolean var4)
                    // BanEntry<InetAddress> banIp(@Nullable String var1, @Nullable Instant var2, @Nullable String var3, boolean var4)
                    // BanEntry<InetAddress> banIp(@Nullable String var1, @Nullable Duration var2, @Nullable String var3, boolean var4)
                    TODO()
                }
                .function("chat", 1) { it.target?.chat(it.getString(0)!!) }
                .function("performCommand", 1) { it.target?.performCommand(it.getString(0)!!) }
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
                .function("setBedSpawnLocation", 1) { it.target?.setBedSpawnLocation(it.getArgument(0) as Location) }
                .function("setRespawnLocation", 1) { it.target?.setRespawnLocation(it.getArgument(0) as Location) }
                .function("setBedSpawnLocation", 2) {
                    it.target?.setBedSpawnLocation(
                        it.getArgument(0) as Location,
                        it.getBoolean(1)
                    )
                }
                .function("setRespawnLocation", 2) {
                    it.target?.setRespawnLocation(
                        it.getArgument(0) as Location,
                        it.getBoolean(1)
                    )
                }
                .function("playNote", 3) {
                    // void playNote(@NotNull Location var1, byte var2, byte var3)
                    // void playNote(@NotNull Location var1, @NotNull Instrument var2, @NotNull Note var3)
                    TODO()
                }
                .function("playSound", 4) {
                    // void playSound(@NotNull Location var1, @NotNull Sound var2, float var3, float var4)
                    // void playSound(@NotNull Location var1, @NotNull String var2, float var3, float var4)
                    // void playSound(@NotNull Entity var1, @NotNull Sound var2, float var3, float var4)
                    // void playSound(@NotNull Entity var1, @NotNull String var2, float var3, float var4)
                    TODO()
                }
                .function("playSound", 5) {
                    // void playSound(@NotNull Location var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5)
                    // void playSound(@NotNull Location var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5)
                    // void playSound(@NotNull Entity var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5)
                    // void playSound(@NotNull Entity var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5)
                    TODO()
                }
                .function("playSound", 6) {
                    // void playSound(@NotNull Location var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    // void playSound(@NotNull Location var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    // void playSound(@NotNull Entity var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    // void playSound(@NotNull Entity var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                    TODO()
                }
                .function("stopSound", 1) {
                    // void stopSound(@NotNull Sound var1)
                    // void stopSound(@NotNull String var1)
                    // void stopSound(@NotNull SoundCategory var1)
                    TODO()
                }
                .function("stopSound", 2) {
                    // void stopSound(@NotNull Sound var1, @Nullable SoundCategory var2)
                    // void stopSound(@NotNull String var1, @Nullable SoundCategory var2)
                    TODO()
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
                .function("sendBlockChange", 3) {
                    it.target?.sendBlockChange(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Material,
                        it.getNumber(2).toByte()
                    )
                }
                .function("sendBlockChange", 2) {
                    it.target?.sendBlockChange(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as BlockData
                    )
                }
                .function(
                    "sendBlockChanges",
                    1
                ) { it.target?.sendBlockChanges(it.getArgument(0) as Collection<BlockState>) }
                .function(
                    "sendBlockChanges",
                    2
                ) { it.target?.sendBlockChanges(it.getArgument(0) as Collection<BlockState>, it.getBoolean(1)) }
                .function("sendBlockDamage", 2) {
                    it.target?.sendBlockDamage(
                        it.getArgument(0) as Location,
                        it.getNumber(1).toFloat()
                    )
                }
                .function("sendBlockDamage", 3) {
                    // void sendBlockDamage(@NotNull Location var1, float var2, @NotNull Entity var3)
                    // void sendBlockDamage(@NotNull Location var1, float var2, int var3)
                    TODO()
                }
                .function("sendEquipmentChange", 3) {
                    it.target?.sendEquipmentChange(
                        it.getArgument(0) as LivingEntity,
                        it.getArgument(1) as EquipmentSlot,
                        it.getArgument(2) as ItemStack
                    )
                }
                .function("sendEquipmentChange", 2) {
                    it.target?.sendEquipmentChange(
                        it.getArgument(0) as LivingEntity,
                        it.getArgument(1) as Map<EquipmentSlot, ItemStack>
                    )
                }
                .function("sendSignChange", 2) {
                    it.target?.sendSignChange(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Array<String>
                    )
                }
                .function("sendSignChange", 3) {
                    it.target?.sendSignChange(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Array<String>,
                        it.getArgument(2) as DyeColor
                    )
                }
                .function("sendSignChange", 4) {
                    it.target?.sendSignChange(
                        it.getArgument(0) as Location,
                        it.getArgument(1) as Array<String>,
                        it.getArgument(2) as DyeColor,
                        it.getBoolean(3)
                    )
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
                .function("setPlayerTime", 2) { it.target?.setPlayerTime(it.getNumber(0).toLong(), it.getBoolean(1)) }
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
                .function("sendExperienceChange", 1) { it.target?.sendExperienceChange(it.getNumber(0).toFloat()) }
                .function("sendExperienceChange", 2) {
                    it.target?.sendExperienceChange(
                        it.getNumber(0).toFloat(),
                        it.getNumber(1).toInt()
                    )
                }
                .function("allowFlight", 0) { it.target?.allowFlight }
                .function("setAllowFlight", 1) { it.target?.setAllowFlight(it.getBoolean(0)) }
                .function("hidePlayer", 1) { it.target?.hidePlayer(it.getArgument(0) as Player) }
                .function("hidePlayer", 2) {
                    it.target?.hidePlayer(
                        it.getArgument(0) as Plugin,
                        it.getArgument(1) as Player
                    )
                }
                .function("showPlayer", 1) { it.target?.showPlayer(it.getArgument(0) as Player) }
                .function("showPlayer", 2) {
                    it.target?.showPlayer(
                        it.getArgument(0) as Plugin,
                        it.getArgument(1) as Player
                    )
                }
                .function("canSee", 1) {
                    // boolean canSee(@NotNull Player var1)
                    // boolean canSee(@NotNull Entity var1)
                    TODO()
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
                .function("setResourcePack", 1) { it.target?.setResourcePack(it.getString(0)!!) }
                .function("setResourcePack", 2) {
                    it.target?.setResourcePack(
                        it.getString(0)!!,
                        it.getArgument(1) as ByteArray
                    )
                }
                .function("setResourcePack", 3) {
                    // void setResourcePack(@NotNull String var1, @Nullable byte[] var2, @Nullable String var3)
                    // void setResourcePack(@NotNull String var1, @Nullable byte[] var2, boolean var3)
                    TODO()
                }
                .function("setResourcePack", 4) {
                    it.target?.setResourcePack(
                        it.getString(0)!!,
                        it.getArgument(1) as ByteArray,
                        it.getString(2),
                        it.getBoolean(3)
                    )
                }
                .function("setResourcePack", 5) {
                    it.target?.setResourcePack(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)!!,
                        it.getArgument(2) as ByteArray,
                        it.getString(3),
                        it.getBoolean(4)
                    )
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
                .function("sendHealthUpdate", 3) {
                    it.target?.sendHealthUpdate(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toFloat()
                    )
                }
                .function("sendHealthUpdate", 0) { it.target?.sendHealthUpdate() }
                .function("isHealthScaled", 0) { it.target?.isHealthScaled }
                .function("setHealthScaled", 1) { it.target?.setHealthScaled(it.getBoolean(0)) }
                .function("setHealthScale", 1) { it.target?.setHealthScale(it.getNumber(0).toDouble()) }
                .function("healthScale", 0) { it.target?.healthScale }
                .function("spectatorTarget", 0) { it.target?.spectatorTarget }
                .function("setSpectatorTarget", 1) { it.target?.setSpectatorTarget(it.getArgument(0) as Entity) }
                .function("sendTitle", 2) { it.target?.sendTitle(it.getString(0), it.getString(1)) }
                .function("sendTitle", 5) {
                    it.target?.sendTitle(
                        it.getString(0),
                        it.getString(1),
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getNumber(4).toInt()
                    )
                }
                .function("resetTitle", 0) { it.target?.resetTitle() }
                .function("spawnParticle", 3) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getArgument(1) as Location,
                        it.getNumber(2).toInt()
                    )
                }
                .function("spawnParticle", 5) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toInt()
                    )
                }
                .function("spawnParticle", 6) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getArgument(1) as Location,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble()
                    )
                }
                .function("spawnParticle", 8) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toInt(),
                        it.getNumber(5).toDouble(),
                        it.getNumber(6).toDouble(),
                        it.getNumber(7).toDouble()
                    )
                }
                .function("spawnParticle", 7) {
                    it.target?.spawnParticle(
                        it.getArgument(0) as Particle,
                        it.getArgument(1) as Location,
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble(),
                        it.getNumber(6).toDouble()
                    )
                }
                .function("spawnParticle", 9) {
                    it.target?.spawnParticle(
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
                }
                .function(
                    "advancementProgress",
                    1
                ) { it.target?.getAdvancementProgress(it.getArgument(0) as Advancement) }
                .function("clientViewDistance", 0) { it.target?.clientViewDistance }
                .function("ping", 0) { it.target?.ping }
                .function("locale", 0) { it.target?.locale }
                .function("updateCommands", 0) { it.target?.updateCommands() }
                .function("openBook", 1) { it.target?.openBook(it.getArgument(0) as ItemStack) }
                .function("openSign", 1) { it.target?.openSign(it.getArgument(0) as Sign) }
                .function("openSign", 2) { it.target?.openSign(it.getArgument(0) as Sign, it.getArgument(1) as Side) }
                .function("showDemoScreen", 0) { it.target?.showDemoScreen() }
                .function("isAllowingServerListings", 0) { it.target?.isAllowingServerListings }
        }
    }
}
