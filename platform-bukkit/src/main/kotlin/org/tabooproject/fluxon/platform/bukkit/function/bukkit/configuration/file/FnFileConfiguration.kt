package org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file

import org.bukkit.configuration.file.FileConfiguration
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnFileConfiguration {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FileConfiguration::class.java)
                .function("save", 1) { it.target?.save(it.getString(0)!!) }
                .function("saveToString", 0) { it.target?.saveToString() }
                .function("load", 1) {
                    when (val var1 = it.getArgument(0)) {
                        is File -> it.target?.load(var1)
                        is String -> it.target?.load(var1)
                        else -> throw IllegalArgumentException("参数必须是 File 或 String 类型")
                    }
                }
                .function("loadFromString", 1) { it.target?.loadFromString(it.getString(0)!!) }
        }
    }
}
