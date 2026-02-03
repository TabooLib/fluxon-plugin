package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockShearEntityEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockShearEntityEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockShearEntityEvent {

    val TYPE = Type.fromClass(BlockShearEntityEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockShearEntityEvent::class.java)
                .function("entity", returns(FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
                .function("tool", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.tool) }
        }
    }
}
