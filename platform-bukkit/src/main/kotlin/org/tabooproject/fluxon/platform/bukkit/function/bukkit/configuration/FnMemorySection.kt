package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration

import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.MemorySection
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnMemorySection {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MemorySection::class.java)
                .function("getKeys", 1) { it.target?.getKeys(it.getBoolean(0)) }
                .function("contains", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.contains(it.getString(0)!!)
                    } else {
                        it.target?.contains(it.getString(0)!!, it.getBoolean(1))
                    }
                }
                .function("isSet", 1) { it.target?.isSet(it.getString(0)!!) }
                .function("currentPath", 0) { it.target?.currentPath }
                .function("name", 0) { it.target?.name }
                .function("root", 0) { it.target?.root }
                .function("parent", 0) { it.target?.parent }
                .function("addDefault", 2) { it.target?.addDefault(it.getString(0)!!, it.getArgument(1)) }
                .function("defaultSection", 0) { it.target?.defaultSection }
                .function("set", 2) { it.target?.set(it.getString(0)!!, it.getArgument(1)) }
                .function("get", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.get(it.getString(0)!!)
                    } else {
                        it.target?.get(it.getString(0)!!, it.getArgument(1))
                    }
                }
                .function("createSection", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.createSection(it.getString(0)!!)
                    } else {
                        it.target?.createSection(
                            it.getString(0)!!,
                            it.getArgument(1) as Map<*, *>
                        )
                    }
                }
                .function("getString", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getString(it.getString(0)!!)
                    } else {
                        it.target?.getString(it.getString(0)!!, it.getString(1))
                    }
                }
                .function("isString", 1) { it.target?.isString(it.getString(0)!!) }
                .function("getInt", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getInt(it.getString(0)!!)
                    } else {
                        it.target?.getInt(it.getString(0)!!, it.getNumber(1).toInt())
                    }
                }
                .function("isInt", 1) { it.target?.isInt(it.getString(0)!!) }
                .function("getBoolean", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getBoolean(it.getString(0)!!)
                    } else {
                        it.target?.getBoolean(it.getString(0)!!, it.getBoolean(1))
                    }
                }
                .function("isBoolean", 1) { it.target?.isBoolean(it.getString(0)!!) }
                .function("getDouble", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getDouble(it.getString(0)!!)
                    } else {
                        it.target?.getDouble(it.getString(0)!!, it.getNumber(1).toDouble())
                    }
                }
                .function("isDouble", 1) { it.target?.isDouble(it.getString(0)!!) }
                .function("getLong", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getLong(it.getString(0)!!)
                    } else {
                        it.target?.getLong(it.getString(0)!!, it.getNumber(1).toLong())
                    }
                }
                .function("isLong", 1) { it.target?.isLong(it.getString(0)!!) }
                .function("isList", 1) { it.target?.isList(it.getString(0)!!) }
                .function("getStringList", 1) { it.target?.getStringList(it.getString(0)!!) }
                .function("getIntegerList", 1) { it.target?.getIntegerList(it.getString(0)!!) }
                .function("getBooleanList", 1) { it.target?.getBooleanList(it.getString(0)!!) }
                .function("getDoubleList", 1) { it.target?.getDoubleList(it.getString(0)!!) }
                .function("getFloatList", 1) { it.target?.getFloatList(it.getString(0)!!) }
                .function("getLongList", 1) { it.target?.getLongList(it.getString(0)!!) }
                .function("getByteList", 1) { it.target?.getByteList(it.getString(0)!!) }
                .function("getCharacterList", 1) { it.target?.getCharacterList(it.getString(0)!!) }
                .function("getShortList", 1) { it.target?.getShortList(it.getString(0)!!) }
                .function("getVector", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getVector(it.getString(0)!!)
                    } else {
                        it.target?.getVector(it.getString(0)!!, it.getArgument(1) as Vector)
                    }
                }
                .function("isVector", 1) { it.target?.isVector(it.getString(0)!!) }
                .function("getOfflinePlayer", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getOfflinePlayer(it.getString(0)!!)
                    } else {
                        it.target?.getOfflinePlayer(
                            it.getString(0)!!,
                            it.getArgument(1) as OfflinePlayer
                        )
                    }
                }
                .function("isOfflinePlayer", 1) { it.target?.isOfflinePlayer(it.getString(0)!!) }
                .function("getItemStack", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getItemStack(it.getString(0)!!)
                    } else {
                        it.target?.getItemStack(it.getString(0)!!, it.getArgument(1) as ItemStack)
                    }
                }
                .function("isItemStack", 1) { it.target?.isItemStack(it.getString(0)!!) }
                .function("getColor", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getColor(it.getString(0)!!)
                    } else {
                        it.target?.getColor(it.getString(0)!!, it.getArgument(1) as Color)
                    }
                }
                .function("isColor", 1) { it.target?.isColor(it.getString(0)!!) }
                .function("getLocation", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.getLocation(it.getString(0)!!)
                    } else {
                        it.target?.getLocation(it.getString(0)!!, it.getArgument(1) as Location)
                    }
                }
                .function("isLocation", 1) { it.target?.isLocation(it.getString(0)!!) }
                .function("getConfigurationSection", 1) { it.target?.getConfigurationSection(it.getString(0)!!) }
                .function("isConfigurationSection", 1) { it.target?.isConfigurationSection(it.getString(0)!!) }
                // static
                .function("createPath", listOf(2, 3)) {
                    if (it.arguments.size == 2) {
                        MemorySection.createPath(
                            it.getArgument(0) as ConfigurationSection,
                            it.getString(1)
                        )
                    } else {
                        MemorySection.createPath(
                            it.getArgument(0) as ConfigurationSection,
                            it.getString(1),
                            it.getArgument(2) as ConfigurationSection
                        )
                    }
                }
                .function("getComments", 1) { it.target?.getComments(it.getString(0)!!) }
                .function("getInlineComments", 1) { it.target?.getInlineComments(it.getString(0)!!) }
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
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
