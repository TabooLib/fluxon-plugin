package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.RemoteConsoleCommandSender"])
@PlatformSide(Platform.BUKKIT)
object FnRemoteConsoleCommandSender {

    val TYPE = Type.fromClass(org.bukkit.command.RemoteConsoleCommandSender::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.command.RemoteConsoleCommandSender::class.java)
                .function("getAddress", returns(Type.fromClass(java.net.SocketAddress::class.java)).noParams()) { it.setReturnRef(it.target?.getAddress()) }
        }
    }
}
