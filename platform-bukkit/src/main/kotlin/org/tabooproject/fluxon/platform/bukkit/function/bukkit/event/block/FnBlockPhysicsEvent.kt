package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.BlockPhysicsEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.BlockPhysicsEvent"])
@PlatformSide(Platform.BUKKIT)
object FnBlockPhysicsEvent {

    val TYPE = Type.fromClass(BlockPhysicsEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockPhysicsEvent::class.java)
                .function("sourceBlock", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.sourceBlock) }
                .function("changedType", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.changedType) }
        }
    }
}
