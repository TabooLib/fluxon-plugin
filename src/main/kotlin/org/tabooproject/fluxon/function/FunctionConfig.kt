package org.tabooproject.fluxon.function

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.index.IndexAccessor
import org.tabooproject.fluxon.runtime.index.IndexAccessorRegistry
import org.tabooproject.fluxon.runtime.java.Export
import org.tabooproject.fluxon.util.StandardTypes
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.library.configuration.ConfigurationSection
import taboolib.module.configuration.Configuration
import java.io.File

object FunctionConfig {

    @Awake(LifeCycle.INIT)
    fun init() {
        IndexAccessorRegistry.getInstance().registerAccessor(ConfigIndexAccessor)
        with(FluxonRuntime.getInstance()) {
            exportRegistry.registerClass(YamlApi::class.java)
            registerFunction("yaml", returns(YamlApi.TYPE).noParams()) { it.setReturnRef(YamlApi) }
            registerExtension(Configuration::class.java)
                .function("file", returns(Type.FILE).noParams()) { it.setReturnRef(it.target?.file) }
                .function("save", returnsVoid().noParams()) {
                    it.target?.saveToFile()
                }
                .function("saveToFile", returnsVoid().params(Type.FILE)) {
                    it.target?.saveToFile(it.getRef(0) as File)
                }
            registerExtension(ConfigurationSection::class.java)
                .function("primitiveConfig", returns(StandardTypes.CONFIGURATION_SECTION).noParams()) { it.setReturnRef(it.target?.primitiveConfig) }
                .function("parent", returns(StandardTypes.CONFIGURATION_SECTION).noParams()) { it.setReturnRef(it.target?.parent) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("type", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.type?.name) }
                .function("keys", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.getKeys(false)) }
                .function("keys", returns(Type.LIST).params(Type.Z)) { it.setReturnRef(it.target?.getKeys(it.getBool(0))) }
                .function("values", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.getValues(false)) }
                .function("values", returns(Type.MAP).params(Type.Z)) { it.setReturnRef(it.target?.getValues(it.getBool(0))) }
                .function("contains", returns(Type.Z).params(Type.STRING)) { it.setReturnRef(it.target?.contains(it.getString(0)!!)) }
                .function("get", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.get(it.getString(0)!!)) }
                .function("get", returnsObject().params(Type.STRING, Type.OBJECT)) { it.setReturnRef(it.target?.get(it.getString(0)!!, it.getRef(1))) }
                .function("set", returnsVoid().params(Type.STRING, Type.OBJECT)) {
                    it.target?.set(it.getString(0)!!, it.getRef(1))
                }
                .function("toMap", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.toMap()) }
                .function("clear", returnsVoid().noParams()) {
                    it.target?.clear()
                }
        }
    }

    object YamlApi {

        val TYPE = Type.fromClass(YamlApi::class.java)!!

        @Export
        fun load(file: File): Configuration {
            return Configuration.loadFromFile(file, concurrent = false)
        }
    }

    object ConfigIndexAccessor : IndexAccessor {

        override fun supports(type: Any?): Boolean {
            return type is ConfigurationSection
        }

        override fun get(target: Any?, index: Any?): Any? {
            target as ConfigurationSection
            return target[index.toString()]
        }

        override fun set(target: Any?, index: Any?, value: Any?) {
            target as ConfigurationSection
            target[index.toString()] = value
        }
    }
}