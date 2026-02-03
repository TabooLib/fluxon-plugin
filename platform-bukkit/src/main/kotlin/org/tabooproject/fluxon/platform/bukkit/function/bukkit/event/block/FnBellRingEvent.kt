package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BellRingEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BellRingEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBellRingEvent {

    val TYPE = Type.fromClass(BellRingEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BellRingEvent::class.java)
                .function("direction", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.direction) }
                .function("entity", returns(FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
        }
    }
}
