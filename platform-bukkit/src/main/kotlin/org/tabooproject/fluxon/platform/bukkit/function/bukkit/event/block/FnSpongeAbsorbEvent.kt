package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.SpongeAbsorbEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.SpongeAbsorbEvent"])
@PlatformSide(Platform.BUKKIT)
object FnSpongeAbsorbEvent {

    val TYPE = Type.fromClass(SpongeAbsorbEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SpongeAbsorbEvent::class.java)
                .function("blocks", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.blocks) }
        }
    }
}
