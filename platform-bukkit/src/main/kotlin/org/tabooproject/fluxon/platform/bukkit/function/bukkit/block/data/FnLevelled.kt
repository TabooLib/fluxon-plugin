package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Levelled
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.Levelled"])
@PlatformSide(Platform.BUKKIT)
object FnLevelled {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Levelled::class.java)
                .function("level", 0) { it.target?.level }
                .function("setLevel", 1) { it.target?.setLevel(it.getNumber(0).toInt()) }
                .function("maximumLevel", 0) { it.target?.maximumLevel }
        }
    }
}
