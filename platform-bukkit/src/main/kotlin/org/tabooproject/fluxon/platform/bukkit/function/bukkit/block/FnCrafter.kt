package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Crafter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCrafter {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Crafter::class.java)
                .function("craftingTicks", 0) { it.target?.craftingTicks }
                .function("setCraftingTicks", 1) { it.target?.setCraftingTicks(it.getNumber(0).toInt()) }
                .function("isSlotDisabled", 1) { it.target?.isSlotDisabled(it.getNumber(0).toInt()) }
                .function("setSlotDisabled", 2) {
                    it.target?.setSlotDisabled(
                        it.getNumber(0).toInt(),
                        it.getBoolean(1)
                    )
                }
                .function("isTriggered", 0) { it.target?.isTriggered }
                .function("setTriggered", 1) { it.target?.setTriggered(it.getBoolean(0)) }
        }
    }
}
