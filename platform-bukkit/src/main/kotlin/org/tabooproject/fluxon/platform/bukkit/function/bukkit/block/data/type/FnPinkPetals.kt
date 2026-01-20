package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.PinkPetals
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPinkPetals {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PinkPetals::class.java)
                .function("flowerAmount", 0) { it.target?.flowerAmount }
                .function("setFlowerAmount", 1) { it.target?.setFlowerAmount(it.getNumber(0).toInt()) }
                .function("maximumFlowerAmount", 0) { it.target?.maximumFlowerAmount }
        }
    }
}
