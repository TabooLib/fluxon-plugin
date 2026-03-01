package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.bukkit.configuration.file.YamlConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import java.io.Reader
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.configuration.file.YamlConfiguration"])
@PlatformSide(Platform.BUKKIT)
object FnYamlConfiguration {

    val TYPE = Type.fromClass(YamlConfiguration::class.java)
    private val READER = Type.fromClass(Reader::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(YamlConfiguration::class.java)
                .function("saveToString",returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.saveToString()) }
                .function("loadFromString", returnsVoid().params(Type.STRING)) { it.target?.loadFromString(it.getString(0)!!) }
                // static
                .function("loadConfiguration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfiguration.TYPE).params(Type.FILE)) { it.setReturnRef(YamlConfiguration.loadConfiguration(it.getRef(0) as File)) }
                .function("loadConfiguration", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnYamlConfiguration.TYPE).params(READER)) { it.setReturnRef(YamlConfiguration.loadConfiguration(it.getRef(0) as Reader)) }
        }
    }
}
