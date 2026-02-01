package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.FurnaceExtractEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.inventory.FurnaceExtractEvent"])
@PlatformSide(Platform.BUKKIT)
object FnFurnaceExtractEvent {

    val TYPE = Type.fromClass(FurnaceExtractEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(FurnaceExtractEvent::class.java)
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("itemType", returnsObject().noParams()) { it.setReturnRef(it.target?.itemType) }
                .function("itemAmount", returnsObject().noParams()) { it.setReturnRef(it.target?.itemAmount) }
        }
    }
}
