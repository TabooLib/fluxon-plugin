package org.tabooproject.fluxon.platform.bukkit.function.bukkit.command

import org.bukkit.command.BlockCommandSender
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.command.BlockCommandSender"])
@PlatformSide(Platform.BUKKIT)
object FnBlockCommandSender {

    val TYPE = Type.fromClass(BlockCommandSender::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockCommandSender::class.java)
                .function("block", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
        }
    }
}
