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
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.configuration.ConfigurationSection"])
@PlatformSide(Platform.BUKKIT)
object FnConfigurationSection {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ConfigurationSection::class.java)
                .function("getKeys", returnsObject().params(Type.OBJECT)) { it.target?.getKeys(it.getBool(0)) }
                .function("contains", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.contains(it.getString(0)!!)
                    } else {
                        it.target?.contains(it.getString(0)!!, it.getBool(1))
                    }
                }
                .function("contains", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.contains(it.getString(0)!!)
                    } else {
                        it.target?.contains(it.getString(0)!!, it.getBool(1))
                    }
                }
                .function("isSet", returns(Type.Z).params(Type.OBJECT)) { it.target?.isSet(it.getString(0)!!) }
                .function("currentPath", returnsObject().noParams()) { it.target?.currentPath }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("root", returnsObject().noParams()) { it.target?.root }
                .function("parent", returnsObject().noParams()) { it.target?.parent }
                .function("get", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.get(it.getString(0)!!)
                    } else {
                        it.target?.get(it.getString(0)!!, it.getRef(1))
                    }
                }
                .function("get", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.get(it.getString(0)!!)
                    } else {
                        it.target?.get(it.getString(0)!!, it.getRef(1))
                    }
                }
                .function("set", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.set(it.getString(0)!!, it.getRef(1)) }
                .function("createSection", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.createSection(it.getString(0)!!)
                    } else {
                        it.target?.createSection(
                            it.getString(0)!!,
                            it.getRef(1) as Map<*, *>
                        )
                    }
                }
                .function("createSection", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.createSection(it.getString(0)!!)
                    } else {
                        it.target?.createSection(
                            it.getString(0)!!,
                            it.getRef(1) as Map<*, *>
                        )
                    }
                }
                .function("getString", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getString(it.getString(0)!!)
                    } else {
                        it.target?.getString(it.getString(0)!!, it.getString(1))
                    }
                }
                .function("getString", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getString(it.getString(0)!!)
                    } else {
                        it.target?.getString(it.getString(0)!!, it.getString(1))
                    }
                }
                .function("isString", returns(Type.Z).params(Type.OBJECT)) { it.target?.isString(it.getString(0)!!) }
                .function("getInt", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getInt(it.getString(0)!!)
                    } else {
                        it.target?.getInt(it.getString(0)!!, it.getInt(1).toInt())
                    }
                }
                .function("getInt", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getInt(it.getString(0)!!)
                    } else {
                        it.target?.getInt(it.getString(0)!!, it.getInt(1).toInt())
                    }
                }
                .function("isInt", returns(Type.Z).params(Type.OBJECT)) { it.target?.isInt(it.getString(0)!!) }
                .function("getBoolean", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBoolean(it.getString(0)!!)
                    } else {
                        it.target?.getBoolean(it.getString(0)!!, it.getBool(1))
                    }
                }
                .function("getBoolean", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getBoolean(it.getString(0)!!)
                    } else {
                        it.target?.getBoolean(it.getString(0)!!, it.getBool(1))
                    }
                }
                .function("isBoolean", returns(Type.Z).params(Type.OBJECT)) { it.target?.isBoolean(it.getString(0)!!) }
                .function("getDouble", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getDouble(it.getString(0)!!)
                    } else {
                        it.target?.getDouble(it.getString(0)!!, it.getAsDouble(1))
                    }
                }
                .function("getDouble", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getDouble(it.getString(0)!!)
                    } else {
                        it.target?.getDouble(it.getString(0)!!, it.getAsDouble(1))
                    }
                }
                .function("isDouble", returns(Type.Z).params(Type.OBJECT)) { it.target?.isDouble(it.getString(0)!!) }
                .function("getLong", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getLong(it.getString(0)!!)
                    } else {
                        it.target?.getLong(it.getString(0)!!, it.getInt(1).toLong())
                    }
                }
                .function("getLong", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getLong(it.getString(0)!!)
                    } else {
                        it.target?.getLong(it.getString(0)!!, it.getInt(1).toLong())
                    }
                }
                .function("isLong", returns(Type.Z).params(Type.OBJECT)) { it.target?.isLong(it.getString(0)!!) }
                .function("isList", returns(Type.Z).params(Type.OBJECT)) { it.target?.isList(it.getString(0)!!) }
                .function("getStringList", returnsObject().params(Type.OBJECT)) { it.target?.getStringList(it.getString(0)!!) }
                .function("getIntegerList", returnsObject().params(Type.OBJECT)) { it.target?.getIntegerList(it.getString(0)!!) }
                .function("getBooleanList", returnsObject().params(Type.OBJECT)) { it.target?.getBooleanList(it.getString(0)!!) }
                .function("getDoubleList", returnsObject().params(Type.OBJECT)) { it.target?.getDoubleList(it.getString(0)!!) }
                .function("getFloatList", returnsObject().params(Type.OBJECT)) { it.target?.getFloatList(it.getString(0)!!) }
                .function("getLongList", returnsObject().params(Type.OBJECT)) { it.target?.getLongList(it.getString(0)!!) }
                .function("getByteList", returnsObject().params(Type.OBJECT)) { it.target?.getByteList(it.getString(0)!!) }
                .function("getCharacterList", returnsObject().params(Type.OBJECT)) { it.target?.getCharacterList(it.getString(0)!!) }
                .function("getShortList", returnsObject().params(Type.OBJECT)) { it.target?.getShortList(it.getString(0)!!) }
                .function("getVector", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getVector(it.getString(0)!!)
                    } else {
                        it.target?.getVector(it.getString(0)!!, it.getRef(1) as Vector)
                    }
                }
                .function("getVector", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getVector(it.getString(0)!!)
                    } else {
                        it.target?.getVector(it.getString(0)!!, it.getRef(1) as Vector)
                    }
                }
                .function("isVector", returns(Type.Z).params(Type.OBJECT)) { it.target?.isVector(it.getString(0)!!) }
                .function("getOfflinePlayer", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getOfflinePlayer(it.getString(0)!!)
                    } else {
                        it.target?.getOfflinePlayer(
                            it.getString(0)!!,
                            it.getRef(1) as OfflinePlayer
                        )
                    }
                }
                .function("getOfflinePlayer", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getOfflinePlayer(it.getString(0)!!)
                    } else {
                        it.target?.getOfflinePlayer(
                            it.getString(0)!!,
                            it.getRef(1) as OfflinePlayer
                        )
                    }
                }
                .function("isOfflinePlayer", returns(Type.Z).params(Type.OBJECT)) { it.target?.isOfflinePlayer(it.getString(0)!!) }
                .function("getItemStack", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getItemStack(it.getString(0)!!)
                    } else {
                        it.target?.getItemStack(it.getString(0)!!, it.getRef(1) as ItemStack)
                    }
                }
                .function("getItemStack", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getItemStack(it.getString(0)!!)
                    } else {
                        it.target?.getItemStack(it.getString(0)!!, it.getRef(1) as ItemStack)
                    }
                }
                .function("isItemStack", returns(Type.Z).params(Type.OBJECT)) { it.target?.isItemStack(it.getString(0)!!) }
                .function("getColor", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getColor(it.getString(0)!!)
                    } else {
                        it.target?.getColor(it.getString(0)!!, it.getRef(1) as Color)
                    }
                }
                .function("getColor", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getColor(it.getString(0)!!)
                    } else {
                        it.target?.getColor(it.getString(0)!!, it.getRef(1) as Color)
                    }
                }
                .function("isColor", returns(Type.Z).params(Type.OBJECT)) { it.target?.isColor(it.getString(0)!!) }
                .function("getLocation", returnsObject().params(Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getLocation(it.getString(0)!!)
                    } else {
                        it.target?.getLocation(it.getString(0)!!, it.getRef(1) as Location)
                    }
                }
                .function("getLocation", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 1) {
                        it.target?.getLocation(it.getString(0)!!)
                    } else {
                        it.target?.getLocation(it.getString(0)!!, it.getRef(1) as Location)
                    }
                }
                .function("isLocation", returns(Type.Z).params(Type.OBJECT)) { it.target?.isLocation(it.getString(0)!!) }
                .function("getConfigurationSection", returnsObject().params(Type.OBJECT)) { it.target?.getConfigurationSection(it.getString(0)!!) }
                .function("isConfigurationSection", returns(Type.Z).params(Type.OBJECT)) { it.target?.isConfigurationSection(it.getString(0)!!) }
                .function("defaultSection", returnsObject().noParams()) { it.target?.defaultSection }
                .function("addDefault", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.addDefault(it.getString(0)!!, it.getRef(1)) }
                .function("getComments", returnsObject().params(Type.OBJECT)) { it.target?.getComments(it.getString(0)!!) }
                .function("getInlineComments", returnsObject().params(Type.OBJECT)) { it.target?.getInlineComments(it.getString(0)!!) }
                .function("setComments", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setComments(
                        it.getString(0)!!,
                        it.getRef(1) as List<String>
                    )
                }
                .function("setInlineComments", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setInlineComments(
                        it.getString(0)!!,
                        it.getRef(1) as List<String>
                    )
                }
        }
    }
}
