package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.HangingSign"])
@PlatformSide(Platform.BUKKIT)
object FnHangingSign {

    val TYPE = Type.fromClass(org.bukkit.block.HangingSign::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.block.HangingSign::class.java)
                // static
        }
    }
}
