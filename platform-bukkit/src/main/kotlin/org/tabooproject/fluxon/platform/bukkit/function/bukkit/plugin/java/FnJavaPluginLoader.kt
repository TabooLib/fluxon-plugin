package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.java

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPluginLoader
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.io.File
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.java.JavaPluginLoader"])
@PlatformSide(Platform.BUKKIT)
object FnJavaPluginLoader {

    val TYPE = Type.fromClass(JavaPluginLoader::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(JavaPluginLoader::class.java)
                .function("loadPlugin",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE).params(Type.FILE)) { it.setReturnRef(it.target?.loadPlugin(it.getRef(0) as File)) }
                .function("getPluginDescription",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginDescriptionFile.TYPE).params(Type.FILE)) { it.setReturnRef(it.target?.getPluginDescription(it.getRef(0) as File)) }
                .function("pluginFileFilters", returns(Type.fromClass(Array<java.util.regex.Pattern>::class.java)).noParams()) { it.setReturnRef(it.target?.pluginFileFilters) }
                .function("enablePlugin", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.enablePlugin(it.getRef(0) as Plugin) }
                .function("disablePlugin", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE)) { it.target?.disablePlugin(it.getRef(0) as Plugin) }
        }
    }
}
