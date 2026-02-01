package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.PluginLoader
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.PluginLoader"])
@PlatformSide(Platform.BUKKIT)
object FnPluginLoader {

    val TYPE = Type.fromClass(PluginLoader::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PluginLoader::class.java)
                .function("loadPlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.loadPlugin(it.getRef(0) as File)) }
                .function("getPluginDescription", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getPluginDescription(it.getRef(0) as File)) }
                .function("pluginFileFilters", returnsObject().noParams()) { it.setReturnRef(it.target?.pluginFileFilters) }
                .function("enablePlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.enablePlugin(it.getRef(0) as Plugin)) }
                .function("disablePlugin", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.disablePlugin(it.getRef(0) as Plugin)) }
        }
    }
}
