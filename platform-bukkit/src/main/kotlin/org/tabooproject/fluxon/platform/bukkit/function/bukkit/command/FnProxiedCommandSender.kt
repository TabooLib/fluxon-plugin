package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.ProxiedCommandSender
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.command.ProxiedCommandSender"])
@PlatformSide(Platform.BUKKIT)
object FnProxiedCommandSender {

    val TYPE = Type.fromClass(ProxiedCommandSender::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ProxiedCommandSender::class.java)
                .function("caller", returns(FnCommandSender.TYPE).noParams()) { it.setReturnRef(it.target?.caller) }
                .function("callee", returns(FnCommandSender.TYPE).noParams()) { it.setReturnRef(it.target?.callee) }
        }
    }
}
