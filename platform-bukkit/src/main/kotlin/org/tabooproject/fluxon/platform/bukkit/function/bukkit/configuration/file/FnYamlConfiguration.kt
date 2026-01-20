package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.bukkit.configuration.file.YamlConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import java.io.Reader
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnYamlConfiguration {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(YamlConfiguration::class.java)
                .function("saveToString", 0) { it.target?.saveToString() }
                .function("loadFromString", 1) { it.target?.loadFromString(it.getString(0)!!) }
                // static
                .function("loadConfiguration", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is File -> YamlConfiguration.loadConfiguration(var1)
                        is Reader -> YamlConfiguration.loadConfiguration(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 Reader 类型")
                    }
                }
        }
    }
}
