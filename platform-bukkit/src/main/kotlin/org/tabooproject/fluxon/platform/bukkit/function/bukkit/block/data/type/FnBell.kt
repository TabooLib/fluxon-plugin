package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bell
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.Bell"])
@PlatformSide(Platform.BUKKIT)
object FnBell {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bell::class.java)
                .function("attachment", 0) { it.target?.attachment }
                .function("setAttachment", 1) { it.target?.setAttachment(it.getArgument(0) as Bell.Attachment) }
        }
    }
}
