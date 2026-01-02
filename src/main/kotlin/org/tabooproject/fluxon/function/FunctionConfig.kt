package org.tabooproject.fluxon.function

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.index.IndexAccessor
import org.tabooproject.fluxon.runtime.index.IndexAccessorRegistry
import org.tabooproject.fluxon.runtime.java.Export
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
            registerFunction("yaml", 0) { YamlApi }
            registerExtension(Configuration::class.java)
                .function("file", 0) {
                    it.target?.file
                }
                .function("save", 0) {
                    it.target?.saveToFile()
                }
                .function("saveToFile", 1) {
                    it.target?.saveToFile(it.getArgument(0) as File)
                }
            registerExtension(ConfigurationSection::class.java)
                .function("primitiveConfig", 0) {
                    it.target?.primitiveConfig
                }
                .function("parent", 0) {
                    it.target?.parent
                }
                .function("name", 0) {
                    it.target?.name
                }
                .function("type", 0) {
                    it.target?.type?.name
                }
                .function("keys", listOf(0, 1)) {
                    it.target?.getKeys(it.getBoolean(0))
                }
                .function("values", listOf(0, 1)) {
                    it.target?.getValues(it.getBoolean(0))
                }
                .function("contains", listOf(1)) {
                    it.target?.contains(it.getArgument(0)!!.toString())
                }
                .function("get", listOf(1, 1)) {
                    it.target?.get(
                        it.getArgument(0)!!.toString(),
                        it.getArgument(1)
                    )
                }
                .function("set", listOf(1, 1)) {
                    it.target?.set(
                        it.getArgument(0)!!.toString(),
                        it.getArgument(1)
                    )
                }
                .function("toMap", 0) {
                    it.target?.toMap()
                }
                .function("clear", 0) {
                    it.target?.clear()
                }
        }
    }

    object YamlApi {

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