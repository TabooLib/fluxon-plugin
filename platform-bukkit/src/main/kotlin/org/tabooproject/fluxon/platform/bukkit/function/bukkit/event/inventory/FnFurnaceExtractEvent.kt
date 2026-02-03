package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceExtractEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.FurnaceExtractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceExtractEvent {

    val TYPE = Type.fromClass(FurnaceExtractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceExtractEvent::class.java)
                .function("player", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.player) }
                .function("itemType", returns(FnMaterial.TYPE).noParams()) { it.setReturnRef(it.target?.itemType) }
                .function("itemAmount", returns(Type.I).noParams()) { it.setReturnRef(it.target?.itemAmount) }
        }
    }
}
