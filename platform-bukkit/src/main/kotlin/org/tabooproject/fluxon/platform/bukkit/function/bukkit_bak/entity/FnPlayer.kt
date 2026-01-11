package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Effect
import org.bukkit.Instrument
import org.bukkit.Location
import org.bukkit.NamespacedKey
import org.bukkit.Note
import org.bukkit.Sound
import org.bukkit.SoundCategory
import org.bukkit.block.Block
import org.bukkit.entity.Entity
import org.bukkit.entity.Player

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.Date

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
                .function("setPlayerListHeader", 1) { it.target?.playerListHeader = it.getString(0) }
                .function("setPlayerListFooter", 1) { it.target?.playerListFooter = it.getString(0) }
                .function("setPlayerListHeaderFooter", 2) { it.target?.setPlayerListHeaderFooter(it.getString(0), it.getString(1)) }
                .function("setCompassTarget", 1) { it.target?.compassTarget = it.getArgument(0) as Location }
                .function("compassTarget", 0) { it.target?.compassTarget }
                .function("address", 0) { it.target?.address }
                .function("isTransferred", 0) { it.target?.isTransferred }
                .function("retrieveCookie", 1) { it.target?.retrieveCookie(it.getArgument(0) as NamespacedKey)?.get() }
                .function("storeCookie", 2) { it.target?.storeCookie(it.getArgument(0) as NamespacedKey, it.getArgument(1) as ByteArray)}
                .function("transfer", 2) { it.target?.transfer(it.getString(0)!!, it.getNumber(1).toInt()) }
                .function("sendRawMessage", 1) { it.target?.sendRawMessage(it.getString(0)!!) }
                .function("kickPlayer", 1) { it.target?.kickPlayer(it.getString(0)) }
                .function("ban", 4) {
                    it.target?.ban(it.getString(0), Date(it.getNumber(1).toLong()), it.getString(2), it.getBoolean(4))
                }
                .function("banIp", 4) {
                    it.target?.banIp(it.getString(0), Date(it.getNumber(1).toLong()), it.getString(2), it.getBoolean(4))
                }
                .function("chat", 1) { it.target?.chat(it.getString(0)!!) }
                .function("performCommand", 1) { it.target?.performCommand(it.getString(0)!!) }
                .function("isOnGround", 0) { it.target?.isOnGround }
                .function("isSneaking", 0) { it.target?.isSneaking }
                .function("setSneaking", 1) { it.target?.isSneaking = it.getBoolean(0)}
                .function("isSprinting", 0) { it.target?.isSprinting }
                .function("setSprinting", 1) { it.target?.isSprinting = it.getBoolean(0) }
                .function("saveData", 0) { it.target?.saveData() }
                .function("loadData", 0) { it.target?.loadData() }
                .function("setSleepingIgnored", 1) { it.target?.isSleepingIgnored = it.getBoolean(0) }
                .function("isSleepingIgnored", 0) { it.target?.isSleepingIgnored }
                .function("bedSpawnLocation", 0) { it.target?.bedSpawnLocation }
                .function("respawnLocation", 0) { it.target?.respawnLocation }
                .function("setBedSpawnLocation", 1) { it.target?.bedSpawnLocation = it.getArgument(0) as Location }
                .function("setRespawnLocation", 1) { it.target?.respawnLocation = it.getArgument(0) as Location }
                .function("setBedSpawnLocation", 2) { it.target?.setBedSpawnLocation(it.getArgument(0) as Location, it.getBoolean(1)) }
                .function("setRespawnLocation", 2) { it.target?.setRespawnLocation(it.getArgument(0) as Location, it.getBoolean(1)) }
                .function("playNote", 3) {
                    when (val var2 = it.getArgument(1)) {
                        //  public void playNote(@NotNull Location var1, byte var2, byte var3)
                        is Byte -> it.target?.playNote(it.getArgument(0) as Location, var2, it.getArgument(2) as Byte)

                        //  public void playNote(@NotNull Location var1, @NotNull Instrument var2, @NotNull Note var3)
                        is String -> it.target?.playNote(it.getArgument(0) as Location, Instrument.valueOf(var2), it.getArgument(2) as Note)
                    }
                }
                .function("playSound", 4) {
                    when (val var1 = it.getArgument(0)) {
                        is Location -> {
                            when (val var2 = it.getArgument(1)) {
                                //  public void playSound(@NotNull Location var1, @NotNull Sound var2, float var3, float var4)
                                is Sound -> it.target?.playSound(var1, var2, it.getNumber(2).toFloat(), it.getNumber(3).toFloat())
                                //  public void playSound(@NotNull Location var1, @NotNull String var2, float var3, float var4)
                                is String -> it.target?.playSound(var1, var2, it.getNumber(2).toFloat(), it.getNumber(3).toFloat())
                            }
                        }
                        is Entity -> {
                            when (val var2 = it.getArgument(1)) {
                                //  public void playSound(@NotNull Entity var1, @NotNull Sound var2, float var3, float var4)
                                is Sound -> it.target?.playSound(var1, var2, it.getNumber(2).toFloat(), it.getNumber(3).toFloat())
                                //  public void playSound(@NotNull Entity var1, @NotNull String var2, float var3, float var4)
                                is String -> it.target?.playSound(var1, var2, it.getNumber(2).toFloat(), it.getNumber(3).toFloat())
                            }
                        }
                    }
                }
                .function("playSound", 5) {
                    when (val var1 = it.getArgument(0)) {
                        is Location -> {
                            when (val var2 = it.getArgument(1)) {
                                //  public void playSound(@NotNull Location var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5)
                                is Sound -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat())
                                //  public void playSound(@NotNull Location var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5)
                                is String -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat())
                            }
                        }
                        is Entity -> {
                            when (val var2 = it.getArgument(1)) {
                                //  public void playSound(@NotNull Entity var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5)
                                is Sound -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat())
                                //  public void playSound(@NotNull Entity var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5)
                                is String -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat())
                            }
                        }
                    }
                }
                .function("playSound", 6) {
                    when (val var1 = it.getArgument(0)) {
                        is Location -> {
                            when (val var2 = it.getArgument(1)) {
                                //  public void playSound(@NotNull Location var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                                is Sound -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat(), it.getNumber(5).toLong())
                                //  public void playSound(@NotNull Location var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                                is String -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat(), it.getNumber(5).toLong())
                            }
                        }
                        is Entity -> {
                            when (val var2 = it.getArgument(1)) {
                                //  public void playSound(@NotNull Entity var1, @NotNull Sound var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                                is Sound -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat(), it.getNumber(5).toLong())
                                //  public void playSound(@NotNull Entity var1, @NotNull String var2, @NotNull SoundCategory var3, float var4, float var5, long var6)
                                is String -> it.target?.playSound(var1, var2, it.getArgument(2) as SoundCategory, it.getNumber(3).toFloat(), it.getNumber(4).toFloat(), it.getNumber(5).toLong())
                            }
                        }
                    }
                }
                .function("stopSound", 1) {
                    when (val var1 = it.getArgument(0)) {
                        //  public void stopSound(@NotNull Sound var1)
                        is Sound -> it.target?.stopSound(var1)
                        //  public void stopSound(@NotNull String var1)
                        is String -> it.target?.stopSound(var1)
                        //  public void stopSound(@NotNull SoundCategory var1)
                        is SoundCategory -> it.target?.stopSound(var1)
                    }
                }
                .function("stopSound", 2) {
                    when (val var1 = it.getArgument(0)) {
                        //  public void stopSound(@NotNull Sound var1, @Nullable SoundCategory var2)
                        is Sound -> it.target?.stopSound(var1, it.getArgument(1) as SoundCategory)
                        //  public void stopSound(@NotNull String var1, @Nullable SoundCategory var2)
                        is String -> it.target?.stopSound(var1, it.getArgument(1) as SoundCategory)
                    }
                }
                .function("stopAllSounds", 0) { it.target?.stopAllSounds() }
                .function("playEffect", 3) { it.target?.playEffect(it.getArgument(0) as Location, it.getArgument(1) as Effect, it.getNumber(2).toInt()) }
                .function("breakBlock", 1) { it.target?.breakBlock(it.getArgument(0) as Block) }
                .function("sendBlockChange", 3) { TODO() }
                .function("sendBlockChange", 2) { TODO() }
                .function("sendBlockChanges", 2) { TODO() }
                .function("sendBlockChanges", 3) { TODO() }
                .function("sendBlockDamage", 2) { TODO() }
                .function("sendBlockDamage", 3) {
                    //  public void sendBlockDamage(@NotNull Location var1, float var2, @NotNull Entity var3)
                    //  public void sendBlockDamage(@NotNull Location var1, float var2, int var3)
                    TODO()
                }
                .function("sendEquipmentChange", 3) {
                    //  public void sendEquipmentChange(@NotNull LivingEntity var1, @NotNull EquipmentSlot var2, @Nullable ItemStack var3)
                    //  public void sendEquipmentChange(@NotNull LivingEntity var1, @NotNull Map<EquipmentSlot, ItemStack> var2)
                    TODO()
                }
                .function("sendSignChange", 3) { TODO() }
                .function("sendSignChange", 4) { TODO() }
                .function("sendSignChange", 5) { TODO() }
                .function("sendBlockUpdate", 2) { TODO() }
                .function("sendPotionEffectChange", 2) { TODO() }
                .function("sendPotionEffectChangeRemove", 2) { TODO() }
                .function("sendMap", 1) { TODO() }
                .function("sendHurtAnimation", 1) { TODO() }
                .function("addCustomChatCompletions", 2) { TODO() }
                .function("removeCustomChatCompletions", 2) { TODO() }
                .function("setCustomChatCompletions", 2) { TODO() }
                .function("updateInventory", 0) { it.target?.updateInventory() }
                .function("previousGameMode", 0) { it.target?.previousGameMode?.name }
                .function("setPlayerTime", 2) { TODO() }
                .function("playerTime", 0) { it.target?.playerTime }
                .function("playerTimeOffset", 0) { it.target?.playerTimeOffset }
                .function("isPlayerTimeRelative", 0) { it.target?.isPlayerTimeRelative() }
                .function("resetPlayerTime", 0) { it.target?.resetPlayerTime() }
                .function("setPlayerWeather", 1) { TODO() }
                .function("playerWeather", 0) { it.target?.playerWeather?.name }
                .function("resetPlayerWeather", 0) { it.target?.resetPlayerWeather() }
                .function("expCooldown", 0) { it.target?.expCooldown }
                .function("setExpCooldown", 1) { TODO() }
                .function("giveExp", 1) { TODO() }
                .function("giveExpLevels", 1) { TODO() }
                .function("exp", 0) { it.target?.exp }
                .function("setExp", 1) { TODO() }
                .function("level", 0) { it.target?.level }
                .function("setLevel", 1) { TODO() }
                .function("totalExperience", 0) { it.target?.totalExperience }
                .function("setTotalExperience", 1) { TODO() }
                .function("sendExperienceChange", 1) { TODO() }
                .function("sendExperienceChange", 2) { TODO() }
                .function("allowFlight", 0) { it.target?.allowFlight }
                .function("setAllowFlight", 1) { TODO() }
                .function("hidePlayer", 1) { TODO() }
                .function("hidePlayer", 2) { TODO() }
                .function("showPlayer", 1) { TODO() }
                .function("showPlayer", 2) { TODO() }
                .function("canSee", 1) {
                    //  public boolean canSee(@NotNull Player var1)
                    //  public boolean canSee(@NotNull Entity var1)
                    TODO()
                }
                .function("hideEntity", 2) { TODO() }
                .function("showEntity", 2) { TODO() }
                .function("isFlying", 0) { it.target?.isFlying() }
                .function("setFlying", 1) { TODO() }
                .function("setFlySpeed", 1) { TODO() }
                .function("setWalkSpeed", 1) { TODO() }
                .function("flySpeed", 0) { it.target?.flySpeed }
                .function("walkSpeed", 0) { it.target?.walkSpeed }
                .function("setTexturePack", 1) { TODO() }
                .function("setResourcePack", 1) { TODO() }
                .function("setResourcePack", 3) { TODO() }
                .function("setResourcePack", 4) {
                    //  public void setResourcePack(@NotNull String var1, @Nullable byte[] var2, @Nullable String var3)
                    //  public void setResourcePack(@NotNull String var1, @Nullable byte[] var2, boolean var3)
                    TODO()
                }
                .function("setResourcePack", 5) { TODO() }
                .function("setResourcePack", 6) { TODO() }
                .function("addResourcePack", 6) { TODO() }
                .function("removeResourcePack", 1) { TODO() }
                .function("removeResourcePacks", 0) { it.target?.removeResourcePacks() }
                .function("scoreboard", 0) { it.target?.scoreboard }
                .function("setScoreboard", 1) { TODO() }
                .function("worldBorder", 0) { it.target?.worldBorder }
                .function("setWorldBorder", 1) { TODO() }
                .function("sendHealthUpdate", 3) { TODO() }
                .function("sendHealthUpdate", 0) { it.target?.sendHealthUpdate() }
                .function("isHealthScaled", 0) { it.target?.isHealthScaled() }
                .function("setHealthScaled", 1) { TODO() }
                .function("setHealthScale", 1) { TODO() }
                .function("healthScale", 0) { it.target?.healthScale }
                .function("spectatorTarget", 0) { it.target?.spectatorTarget }
                .function("setSpectatorTarget", 1) { TODO() }
                .function("sendTitle", 2) { TODO() }
                .function("sendTitle", 5) { TODO() }
                .function("resetTitle", 0) { it.target?.resetTitle() }
                .function("spawnParticle", 3) { TODO() }
                .function("spawnParticle", 5) { TODO() }
                .function("spawnParticle", 6) { TODO() }
                .function("spawnParticle", 8) { TODO() }
                .function("spawnParticle", 7) { TODO() }
                .function("spawnParticle", 9) { TODO() }
                .function("advancementProgress", 1) { TODO() }
                .function("clientViewDistance", 0) { it.target?.clientViewDistance }
                .function("ping", 0) { it.target?.ping }
                .function("locale", 0) { it.target?.locale }
                .function("updateCommands", 0) { it.target?.updateCommands() }
                .function("openBook", 1) { TODO() }
                .function("openSign", 1) { TODO() }
                .function("openSign", 2) { TODO() }
                .function("showDemoScreen", 0) { it.target?.showDemoScreen() }
                .function("isAllowingServerListings", 0) { it.target?.isAllowingServerListings() }
                .function("spigot", 0) { it.target?.spigot() }

            registerExtension(Player.Spigot::class.java)
                .function("rawAddress", 0) { it.target?.rawAddress }
                .function("respawn", 0) { it.target?.respawn() }
                .function("hiddenPlayers", 0) { it.target?.hiddenPlayers }
                .function("sendMessage", 1) {
                    //  public void sendMessage(@NotNull BaseComponent component)
                    //  public void sendMessage(BaseComponent ... components)
                    TODO()
                }
                .function("sendMessage", 2) {
                    //  public void sendMessage(@NotNull ChatMessageType position, @NotNull BaseComponent component)
                    //  public void sendMessage(@NotNull ChatMessageType position, BaseComponent ... components)
                    TODO()
                }
                .function("sendMessage", 3) {
                    //  public void sendMessage(@NotNull ChatMessageType position, @Nullable UUID sender, @NotNull BaseComponent component)
                    //  public void sendMessage(@NotNull ChatMessageType position, @Nullable UUID sender, BaseComponent ... components)
                    TODO()
                };
        }
    }
}
