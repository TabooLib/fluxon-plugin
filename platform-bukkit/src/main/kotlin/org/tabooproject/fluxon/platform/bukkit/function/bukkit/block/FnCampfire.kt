package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Campfire
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnCampfire {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Campfire::class.java)
                .function("size", 0) { it.target?.size }
                .function("getItem", 1) { it.target?.getItem(it.getNumber(0).toInt()) }
                .function("setItem", 2) { it.target?.setItem(it.getNumber(0).toInt(), it.getArgument(1) as ItemStack) }
                .function("getCookTime", 1) { it.target?.getCookTime(it.getNumber(0).toInt()) }
                .function("setCookTime", 2) { it.target?.setCookTime(it.getNumber(0).toInt(), it.getNumber(1).toInt()) }
                .function("getCookTimeTotal", 1) { it.target?.getCookTimeTotal(it.getNumber(0).toInt()) }
                .function("setCookTimeTotal", 2) {
                    it.target?.setCookTimeTotal(
                        it.getNumber(0).toInt(),
                        it.getNumber(1).toInt()
                    )
                }
        }
    }
}
