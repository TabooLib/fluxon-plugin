package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin

import org.bukkit.plugin.Plugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.Plugin"])
@PlatformSide(Platform.BUKKIT)
object FnPlugin {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Plugin::class.java)
                .function("dataFolder", returnsObject().noParams()) { it.target?.dataFolder }
                .function("description", returnsObject().noParams()) { it.target?.description }
                .function("config", returnsObject().noParams()) { it.target?.config }
                .function("getResource", returnsObject().params(Type.OBJECT)) { it.target?.getResource(it.getString(0)!!) }
                .function("saveConfig", returnsObject().noParams()) { it.target?.saveConfig() }
                .function("saveDefaultConfig", returnsObject().noParams()) { it.target?.saveDefaultConfig() }
                .function("saveResource", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.saveResource(it.getString(0)!!, it.getBool(1)) }
                .function("reloadConfig", returnsObject().noParams()) { it.target?.reloadConfig() }
                .function("pluginLoader", returnsObject().noParams()) { it.target?.pluginLoader }
                .function("server", returnsObject().noParams()) { it.target?.server }
                .function("isEnabled", returns(Type.Z).noParams()) { it.target?.isEnabled }
                .function("onDisable", returnsObject().noParams()) { it.target?.onDisable() }
                .function("onLoad", returnsObject().noParams()) { it.target?.onLoad() }
                .function("onEnable", returnsObject().noParams()) { it.target?.onEnable() }
                .function("isNaggable", returns(Type.Z).noParams()) { it.target?.isNaggable }
                .function("setNaggable", returnsObject().params(Type.OBJECT)) { it.target?.setNaggable(it.getBool(0)) }
                .function("getDefaultWorldGenerator", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.getDefaultWorldGenerator(
                        it.getString(0)!!,
                        it.getString(1)
                    )
                }
                .function("getDefaultBiomeProvider", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.getDefaultBiomeProvider(
                        it.getString(0)!!,
                        it.getString(1)
                    )
                }
                .function("logger", returnsObject().noParams()) { it.target?.logger }
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
        }
    }
}
