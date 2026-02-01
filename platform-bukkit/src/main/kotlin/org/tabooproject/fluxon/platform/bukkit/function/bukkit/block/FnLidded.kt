package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lidded
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Lidded"])
@PlatformSide(Platform.BUKKIT)
object FnLidded {

    val TYPE = Type.fromClass(Lidded::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lidded::class.java)
                .function("open", returnsVoid().noParams()) { it.target?.open() }
                .function("close", returnsVoid().noParams()) { it.target?.close() }
        }
    }
}
