package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.plugin.Plugin"])
@PlatformSide(Platform.BUKKIT)
object FnPlugin {

    val TYPE = Type.fromClass(Plugin::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Plugin::class.java)
                .function("dataFolder", returns(Type.FILE).noParams()) { it.setReturnRef(it.target?.dataFolder) }
                .function("description", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginDescriptionFile.TYPE).noParams()) { it.setReturnRef(it.target?.description) }
                .function("config", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.configuration.file.FnFileConfiguration.TYPE).noParams()) { it.setReturnRef(it.target?.config) }
                .function("getResource", returns(Type.fromClass(java.io.InputStream::class.java)).params(Type.STRING)) { it.setReturnRef(it.target?.getResource(it.getString(0)!!)) }
                .function("saveConfig", returnsVoid().noParams()) { it.target?.saveConfig() }
                .function("saveDefaultConfig", returnsVoid().noParams()) { it.target?.saveDefaultConfig() }
                .function("saveResource", returnsVoid().params(Type.STRING, Type.Z)) { it.target?.saveResource(it.getString(0)!!, it.getBool(1)) }
                .function("reloadConfig", returnsVoid().noParams()) { it.target?.reloadConfig() }
                .function("pluginLoader", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPluginLoader.TYPE).noParams()) { it.setReturnRef(it.target?.pluginLoader) }
                .function("server", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnServer.TYPE).noParams()) { it.setReturnRef(it.target?.server) }
                .function("isEnabled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEnabled ?: false) }
                .function("onDisable", returnsVoid().noParams()) { it.target?.onDisable() }
                .function("onLoad", returnsVoid().noParams()) { it.target?.onLoad() }
                .function("onEnable", returnsVoid().noParams()) { it.target?.onEnable() }
                .function("isNaggable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isNaggable ?: false) }
                .function("setNaggable", returnsVoid().params(Type.Z)) { it.target?.setNaggable(it.getBool(0)) }
                .function("getDefaultWorldGenerator",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnChunkGenerator.TYPE).params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(it.target?.getDefaultWorldGenerator(
                        it.getString(0)!!,
                        it.getString(1)
                    ))
                }
                .function("getDefaultBiomeProvider",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.generator.FnBiomeProvider.TYPE).params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(it.target?.getDefaultBiomeProvider(
                        it.getString(0)!!,
                        it.getString(1)
                    ))
                }
                .function("logger", returns(Type.fromClass(java.util.logging.Logger::class.java)).noParams()) { it.setReturnRef(it.target?.logger) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
        }
    }
}
