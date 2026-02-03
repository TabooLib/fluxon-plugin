package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockReceiveGameEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnGameEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockReceiveGameEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockReceiveGameEvent {

    val TYPE = Type.fromClass(BlockReceiveGameEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockReceiveGameEvent::class.java)
                .function("event", returns(FnGameEvent.TYPE).noParams()) { it.setReturnRef(it.target?.event) }
                .function("entity", returns(FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
        }
    }
}
