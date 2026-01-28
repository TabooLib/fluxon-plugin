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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.configuration.file.YamlConfiguration"])
@PlatformSide(Platform.BUKKIT)
object FnYamlConfiguration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(YamlConfiguration::class.java)
                .function("saveToString", returnsObject().noParams()) { it.setReturnRef(it.target?.saveToString()) }
                .function("loadFromString", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.loadFromString(it.getString(0)!!)) }
                // static
                .function("loadConfiguration", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is File -> YamlConfiguration.loadConfiguration(var1)
                        is Reader -> YamlConfiguration.loadConfiguration(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 Reader 类型")
                    })
                }
        }
    }
}
