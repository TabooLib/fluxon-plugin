package org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.java

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.plugin.java.JavaPlugin"])
@PlatformSide(Platform.BUKKIT)
object FnJavaPlugin {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(JavaPlugin::class.java)
                .function("dataFolder", returnsObject().noParams()) { it.target?.dataFolder }
                .function("pluginLoader", returnsObject().noParams()) { it.target?.pluginLoader }
                .function("server", returnsObject().noParams()) { it.target?.server }
                .function("isEnabled", returns(Type.Z).noParams()) { it.target?.isEnabled }
                .function("description", returnsObject().noParams()) { it.target?.description }
                .function("config", returnsObject().noParams()) { it.target?.config }
                .function("reloadConfig", returnsObject().noParams()) { it.target?.reloadConfig() }
                .function("saveConfig", returnsObject().noParams()) { it.target?.saveConfig() }
                .function("saveDefaultConfig", returnsObject().noParams()) { it.target?.saveDefaultConfig() }
                .function("saveResource", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.saveResource(it.getString(0)!!, it.getBool(1)) }
                .function("getResource", returnsObject().params(Type.OBJECT)) { it.target?.getResource(it.getString(0)!!) }
                .function("onCommand", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.onCommand(
                        it.getRef(0) as CommandSender,
                        it.getRef(1) as Command,
                        it.getString(2)!!,
                        it.getRef(3) as Array<String>
                    )
                }
                .function("onTabComplete", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.onTabComplete(
                        it.getRef(0) as CommandSender,
                        it.getRef(1) as Command,
                        it.getString(2)!!,
                        it.getRef(3) as Array<String>
                    )
                }
                .function("getCommand", returnsObject().params(Type.OBJECT)) { it.target?.getCommand(it.getString(0)!!) }
                .function("onLoad", returnsObject().noParams()) { it.target?.onLoad() }
                .function("onDisable", returnsObject().noParams()) { it.target?.onDisable() }
                .function("onEnable", returnsObject().noParams()) { it.target?.onEnable() }
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
                .function("isNaggable", returns(Type.Z).noParams()) { it.target?.isNaggable }
                .function("setNaggable", returnsObject().params(Type.OBJECT)) { it.target?.setNaggable(it.getBool(0)) }
                .function("logger", returnsObject().noParams()) { it.target?.logger }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                // static
                .function("getProvidingPlugin", returnsObject().params(Type.OBJECT)) { JavaPlugin.getProvidingPlugin(it.getRef(0) as Class<*>) }
        }
    }
}
