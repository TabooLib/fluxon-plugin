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
                .function("dataFolder", returnsObject().noParams()) { it.setReturnRef(it.target?.dataFolder) }
                .function("description", returnsObject().noParams()) { it.setReturnRef(it.target?.description) }
                .function("config", returnsObject().noParams()) { it.setReturnRef(it.target?.config) }
                .function("getResource", returnsObject().params(Type.STRING)) { it.setReturnRef(it.target?.getResource(it.getString(0)!!)) }
                .function("saveConfig", returnsVoid().noParams()) { it.target?.saveConfig() }
                .function("saveDefaultConfig", returnsVoid().noParams()) { it.target?.saveDefaultConfig() }
                .function("saveResource", returnsVoid().params(Type.STRING, Type.Z)) { it.target?.saveResource(it.getString(0)!!, it.getBool(1)) }
                .function("reloadConfig", returnsVoid().noParams()) { it.target?.reloadConfig() }
                .function("pluginLoader", returnsObject().noParams()) { it.setReturnRef(it.target?.pluginLoader) }
                .function("server", returnsObject().noParams()) { it.setReturnRef(it.target?.server) }
                .function("isEnabled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEnabled ?: false) }
                .function("onDisable", returnsVoid().noParams()) { it.target?.onDisable() }
                .function("onLoad", returnsVoid().noParams()) { it.target?.onLoad() }
                .function("onEnable", returnsVoid().noParams()) { it.target?.onEnable() }
                .function("isNaggable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isNaggable ?: false) }
                .function("setNaggable", returnsVoid().params(Type.Z)) { it.target?.setNaggable(it.getBool(0)) }
                .function("getDefaultWorldGenerator", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getDefaultWorldGenerator(
                        it.getString(0)!!,
                        it.getString(1)
                    ))
                }
                .function("getDefaultBiomeProvider", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.getDefaultBiomeProvider(
                        it.getString(0)!!,
                        it.getString(1)
                    ))
                }
                .function("logger", returnsObject().noParams()) { it.setReturnRef(it.target?.logger) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
        }
    }
}
