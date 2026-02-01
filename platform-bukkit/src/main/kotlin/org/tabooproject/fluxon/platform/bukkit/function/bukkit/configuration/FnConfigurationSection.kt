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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.configuration.ConfigurationSection"])
@PlatformSide(Platform.BUKKIT)
object FnConfigurationSection {

    val TYPE = Type.fromClass(ConfigurationSection::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ConfigurationSection::class.java)
                .function("getKeys", returnsObject().params(Type.Z)) { it.setReturnRef(it.target?.getKeys(it.getBool(0))) }
                .function("contains", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.contains(it.getString(0)!!) ?: false)
                }
                .function("contains", returns(Type.Z).params(Type.STRING, Type.Z)) {
                    it.setReturnBool(it.target?.contains(it.getString(0)!!, it.getBool(1)) ?: false)
                }
                .function("isSet", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isSet(it.getString(0)!!) ?: false) }
                .function("currentPath", returnsObject().noParams()) { it.setReturnRef(it.target?.currentPath) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("root", returnsObject().noParams()) { it.setReturnRef(it.target?.root) }
                .function("parent", returnsObject().noParams()) { it.setReturnRef(it.target?.parent) }
                .function("get", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.get(it.getString(0)!!))
                }
                .function("get", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.get(it.getString(0)!!, it.getRef(1)))
                }
                .function("set", returnsVoid().params(Type.STRING, Type.OBJECT)) { it.target?.set(it.getString(0)!!, it.getRef(1)) }
                .function("createSection", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.createSection(it.getString(0)!!))
                }
                .function("createSection", returnsObject().params(Type.STRING, Type.MAP)) {
                    it.setReturnRef(it.target?.createSection(it.getString(0)!!, it.getRef(1) as Map<*, *>))
                }
                .function("getString", returns(Type.STRING).params(Type.STRING)) {
                    it.setReturnRef(it.target?.getString(it.getString(0)!!))
                }
                .function("getString", returns(Type.STRING).params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(it.target?.getString(it.getString(0)!!, it.getString(1)))
                }
                .function("isString", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isString(it.getString(0)!!) ?: false) }
                .function("getInt", returns(Type.I).params(Type.STRING)) {
                    it.setReturnInt(it.target?.getInt(it.getString(0)!!) ?: 0)
                }
                .function("getInt", returns(Type.I).params(Type.STRING, Type.I)) {
                    it.setReturnInt(it.target?.getInt(it.getString(0)!!, it.getInt(1)) ?: 0)
                }
                .function("isInt", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isInt(it.getString(0)!!) ?: false) }
                .function("getBoolean", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.getBoolean(it.getString(0)!!) ?: false)
                }
                .function("getBoolean", returns(Type.Z).params(Type.STRING, Type.Z)) {
                    it.setReturnBool(it.target?.getBoolean(it.getString(0)!!, it.getBool(1)) ?: false)
                }
                .function("isBoolean", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isBoolean(it.getString(0)!!) ?: false) }
                .function("getDouble", returns(Type.D).params(Type.STRING)) {
                    it.setReturnDouble(it.target?.getDouble(it.getString(0)!!) ?: 0.0)
                }
                .function("getDouble", returns(Type.D).params(Type.STRING, Type.D)) {
                    it.setReturnDouble(it.target?.getDouble(it.getString(0)!!, it.getDouble(1)) ?: 0.0)
                }
                .function("isDouble", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isDouble(it.getString(0)!!) ?: false) }
                .function("getLong", returns(Type.J).params(Type.STRING)) {
                    it.setReturnLong(it.target?.getLong(it.getString(0)!!) ?: 0L)
                }
                .function("getLong", returns(Type.J).params(Type.STRING, Type.J)) {
                    it.setReturnLong(it.target?.getLong(it.getString(0)!!, it.getLong(1)) ?: 0L)
                }
                .function("isLong", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isLong(it.getString(0)!!) ?: false) }
                .function("isList", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isList(it.getString(0)!!) ?: false) }
                .function("getStringList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getStringList(it.getString(0)!!)) }
                .function("getIntegerList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getIntegerList(it.getString(0)!!)) }
                .function("getBooleanList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getBooleanList(it.getString(0)!!)) }
                .function("getDoubleList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getDoubleList(it.getString(0)!!)) }
                .function("getFloatList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getFloatList(it.getString(0)!!)) }
                .function("getLongList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getLongList(it.getString(0)!!)) }
                .function("getByteList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getByteList(it.getString(0)!!)) }
                .function("getCharacterList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getCharacterList(it.getString(0)!!)) }
                .function("getShortList", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getShortList(it.getString(0)!!)) }
                .function("getVector", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.getVector(it.getString(0)!!))
                }
                .function("getVector", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getVector(it.getString(0)!!, it.getRef(1) as Vector))
                }
                .function("isVector", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isVector(it.getString(0)!!) ?: false) }
                .function("getOfflinePlayer", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.getOfflinePlayer(it.getString(0)!!))
                }
                .function("getOfflinePlayer", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getOfflinePlayer(it.getString(0)!!, it.getRef(1) as OfflinePlayer))
                }
                .function("isOfflinePlayer", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isOfflinePlayer(it.getString(0)!!) ?: false) }
                .function("getItemStack", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.getItemStack(it.getString(0)!!))
                }
                .function("getItemStack", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getItemStack(it.getString(0)!!, it.getRef(1) as ItemStack))
                }
                .function("isItemStack", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isItemStack(it.getString(0)!!) ?: false) }
                .function("getColor", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.getColor(it.getString(0)!!))
                }
                .function("getColor", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getColor(it.getString(0)!!, it.getRef(1) as Color))
                }
                .function("isColor", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isColor(it.getString(0)!!) ?: false) }
                .function("getLocation", returnsObject().params(Type.STRING)) {
                    it.setReturnRef(it.target?.getLocation(it.getString(0)!!))
                }
                .function("getLocation", returnsObject().params(Type.STRING, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getLocation(it.getString(0)!!, it.getRef(1) as Location))
                }
                .function("isLocation", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isLocation(it.getString(0)!!) ?: false) }
                .function("getConfigurationSection", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getConfigurationSection(it.getString(0)!!)) }
                .function("isConfigurationSection", returns(Type.Z).params(Type.STRING)) { it.setReturnBool(it.target?.isConfigurationSection(it.getString(0)!!) ?: false) }
                .function("defaultSection", returnsObject().noParams()) { it.setReturnRef(it.target?.defaultSection) }
                .function("addDefault", returnsVoid().params(Type.STRING, Type.OBJECT)) { it.target?.addDefault(it.getString(0)!!, it.getRef(1)) }
                .function("getComments", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getComments(it.getString(0)!!)) }
                .function("getInlineComments", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getInlineComments(it.getString(0)!!)) }
                .function("setComments", returnsVoid().params(Type.STRING, Type.LIST)) {
                    it.target?.setComments(
                        it.getString(0)!!,
                        it.getRef(1) as List<String>
                    )
                }
                .function("setInlineComments", returnsVoid().params(Type.STRING, Type.LIST)) {
                    it.target?.setInlineComments(
                        it.getString(0)!!,
                        it.getRef(1) as List<String>
                    )
                }
        }
    }
}
