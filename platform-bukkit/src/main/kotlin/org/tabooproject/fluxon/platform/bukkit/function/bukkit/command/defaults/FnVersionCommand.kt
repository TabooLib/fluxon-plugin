package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.defaults

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.defaults.VersionCommand"])
@PlatformSide(Platform.BUKKIT)
object FnVersionCommand {

    val TYPE = Type.fromClass(org.bukkit.command.defaults.VersionCommand::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.command.defaults.VersionCommand::class.java)
                // static getDistance
                // .function("getVersionFetcher", returns(Type.fromClass(com.destroystokyo.paper.util.VersionFetcher::class.java)).noParams()) { it.setReturnRef(it.target?.getVersionFetcher()) }
                .function("execute", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE, Type.STRING, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) { it.setReturnBool(it.target?.execute(it.getRef(0) as org.bukkit.command.CommandSender, it.getString(1), it.getRef(2) as Array<String>) ?: false) }
                // .function("describeToSender", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.plugin.FnPlugin.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE)) { it.target?.describeToSender(it.getRef(0) as org.bukkit.plugin.Plugin, it.getRef(1) as org.bukkit.command.CommandSender) }
                // .function("getNameList", returns(Type.STRING).params(Type.LIST)) { it.setReturnRef(it.target?.getNameList(it.getRef(0) as java.util.List)) }
                .function("tabComplete", returns(Type.LIST).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE, Type.STRING, org.tabooproject.fluxon.util.StandardTypes.STRING_ARRAY)) { it.setReturnRef(it.target?.tabComplete(it.getRef(0) as org.bukkit.command.CommandSender, it.getString(1), it.getRef(2) as Array<String>)) }
                // .function("sendVersion", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.command.FnCommandSender.TYPE)) { it.target?.sendVersion(it.getRef(0) as org.bukkit.command.CommandSender) }
                // .function("obtainVersion", returnsVoid().noParams()) { it.target?.obtainVersion() }
                // .function("setVersionMessage", returnsVoid().params(Type.fromClass(net.kyori.adventure.text.Component::class.java))) { it.target?.setVersionMessage(it.getRef(0) as net.kyori.adventure.text.Component) }
        }
    }
}
