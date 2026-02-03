package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.CommandSender
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnServer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.platform.function.adaptCommandSender
import java.util.*

@Requires(classes = ["org.bukkit.command.CommandSender"])
@PlatformSide(Platform.BUKKIT)
object FnCommandSender {

    val TYPE = Type.fromClass(CommandSender::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CommandSender::class.java)
                .syncFunction("performCommand", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(adaptCommandSender(it.target!!).performCommand(it.getString(0)!!) ?: false)
                }
                .function("sendMessage", returnsVoid().params(Type.STRING)) { it.target?.sendMessage(it.getString(0)) }
                .function("sendMessage", returnsVoid().params(Type.STRING, Type.STRING)) {
                    it.target?.sendMessage(
                        UUID.fromString(it.getString(0)),
                        it.getString(1)
                    )
                }
                .function("server", returns(FnServer.TYPE).noParams()) { it.setReturnRef(it.target?.server) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
        }
    }
}
