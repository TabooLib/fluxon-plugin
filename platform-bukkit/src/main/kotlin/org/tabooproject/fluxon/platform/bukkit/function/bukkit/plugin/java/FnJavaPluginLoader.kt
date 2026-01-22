package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.java

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPluginLoader
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnJavaPluginLoader {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(JavaPluginLoader::class.java)
                .function("loadPlugin", 1) { it.target?.loadPlugin(it.getArgument(0) as File) }
                .function("getPluginDescription", 1) { it.target?.getPluginDescription(it.getArgument(0) as File) }
                .function("pluginFileFilters", 0) { it.target?.pluginFileFilters }
                .function("enablePlugin", 1) { it.target?.enablePlugin(it.getArgument(0) as Plugin) }
                .function("disablePlugin", 1) { it.target?.disablePlugin(it.getArgument(0) as Plugin) }
        }
    }
}
