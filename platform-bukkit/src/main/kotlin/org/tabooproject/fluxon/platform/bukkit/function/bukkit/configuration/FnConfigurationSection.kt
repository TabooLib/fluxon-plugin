package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnConfigurationSection {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ConfigurationSection::class.java)
                .function("keys", 1) { it.target?.getKeys(it.getBoolean(0)) }
                .function("contains", 1) { it.target?.contains(it.getString(0)!!) }
                .function("contains", 2) { it.target?.contains(it.getString(0)!!, it.getBoolean(1)) }
                .function("isSet", 1) { it.target?.isSet(it.getString(0)!!) }
                .function("currentPath", 0) { it.target?.currentPath }
                .function("name", 0) { it.target?.name }
                .function("root", 0) { it.target?.root }
                .function("parent", 0) { it.target?.parent }
                .function("get", 1) { it.target?.get(it.getString(0)!!) }
                .function("get", 2) { it.target?.get(it.getString(0)!!, it.getArgument(1)) }
                .function("set", 2) { it.target?.set(it.getString(0)!!, it.getArgument(1)) }
                .function("createSection", 1) { it.target?.createSection(it.getString(0)!!) }
                .function("createSection", 2) {
                    it.target?.createSection(
                        it.getString(0)!!,
                        it.getArgument(1) as Map<*, *>
                    )
                }
                .function("string", 1) { it.target?.getString(it.getString(0)!!) }
                .function("string", 2) { it.target?.getString(it.getString(0)!!, it.getString(1)) }
                .function("isString", 1) { it.target?.isString(it.getString(0)!!) }
                .function("int", 1) { it.target?.getInt(it.getString(0)!!) }
                .function("int", 2) { it.target?.getInt(it.getString(0)!!, it.getNumber(1).toInt()) }
                .function("isInt", 1) { it.target?.isInt(it.getString(0)!!) }
                .function("boolean", 1) { it.target?.getBoolean(it.getString(0)!!) }
                .function("boolean", 2) { it.target?.getBoolean(it.getString(0)!!, it.getBoolean(1)) }
                .function("isBoolean", 1) { it.target?.isBoolean(it.getString(0)!!) }
                .function("double", 1) { it.target?.getDouble(it.getString(0)!!) }
                .function("double", 2) { it.target?.getDouble(it.getString(0)!!, it.getNumber(1).toDouble()) }
                .function("isDouble", 1) { it.target?.isDouble(it.getString(0)!!) }
                .function("long", 1) { it.target?.getLong(it.getString(0)!!) }
                .function("long", 2) { it.target?.getLong(it.getString(0)!!, it.getNumber(1).toLong()) }
                .function("isLong", 1) { it.target?.isLong(it.getString(0)!!) }
                .function("isList", 1) { it.target?.isList(it.getString(0)!!) }
                .function("stringList", 1) { it.target?.getStringList(it.getString(0)!!) }
                .function("integerList", 1) { it.target?.getIntegerList(it.getString(0)!!) }
                .function("booleanList", 1) { it.target?.getBooleanList(it.getString(0)!!) }
                .function("doubleList", 1) { it.target?.getDoubleList(it.getString(0)!!) }
                .function("floatList", 1) { it.target?.getFloatList(it.getString(0)!!) }
                .function("longList", 1) { it.target?.getLongList(it.getString(0)!!) }
                .function("byteList", 1) { it.target?.getByteList(it.getString(0)!!) }
                .function("characterList", 1) { it.target?.getCharacterList(it.getString(0)!!) }
                .function("shortList", 1) { it.target?.getShortList(it.getString(0)!!) }
                .function("vector", 1) { it.target?.getVector(it.getString(0)!!) }
                .function("vector", 2) { it.target?.getVector(it.getString(0)!!, it.getArgument(1) as Vector) }
                .function("isVector", 1) { it.target?.isVector(it.getString(0)!!) }
                .function("offlinePlayer", 1) { it.target?.getOfflinePlayer(it.getString(0)!!) }
                .function("offlinePlayer", 2) {
                    it.target?.getOfflinePlayer(
                        it.getString(0)!!,
                        it.getArgument(1) as OfflinePlayer
                    )
                }
                .function("isOfflinePlayer", 1) { it.target?.isOfflinePlayer(it.getString(0)!!) }
                .function("itemStack", 1) { it.target?.getItemStack(it.getString(0)!!) }
                .function("itemStack", 2) { it.target?.getItemStack(it.getString(0)!!, it.getArgument(1) as ItemStack) }
                .function("isItemStack", 1) { it.target?.isItemStack(it.getString(0)!!) }
                .function("color", 1) { it.target?.getColor(it.getString(0)!!) }
                .function("color", 2) { it.target?.getColor(it.getString(0)!!, it.getArgument(1) as Color) }
                .function("isColor", 1) { it.target?.isColor(it.getString(0)!!) }
                .function("location", 1) { it.target?.getLocation(it.getString(0)!!) }
                .function("location", 2) { it.target?.getLocation(it.getString(0)!!, it.getArgument(1) as Location) }
                .function("isLocation", 1) { it.target?.isLocation(it.getString(0)!!) }
                .function("configurationSection", 1) { it.target?.getConfigurationSection(it.getString(0)!!) }
                .function("isConfigurationSection", 1) { it.target?.isConfigurationSection(it.getString(0)!!) }
                .function("defaultSection", 0) { it.target?.defaultSection }
                .function("addDefault", 2) { it.target?.addDefault(it.getString(0)!!, it.getArgument(1)) }
                .function("comments", 1) { it.target?.getComments(it.getString(0)!!) }
                .function("inlineComments", 1) { it.target?.getInlineComments(it.getString(0)!!) }
                .function("setComments", 2) {
                    it.target?.setComments(
                        it.getString(0)!!,
                        it.getArgument(1) as List<String>
                    )
                }
                .function("setInlineComments", 2) {
                    it.target?.setInlineComments(
                        it.getString(0)!!,
                        it.getArgument(1) as List<String>
                    )
                }
        }
    }
}
