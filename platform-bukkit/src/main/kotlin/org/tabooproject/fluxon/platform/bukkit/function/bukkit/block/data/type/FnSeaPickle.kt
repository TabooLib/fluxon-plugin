package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SeaPickle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.SeaPickle"])
@PlatformSide(Platform.BUKKIT)
object FnSeaPickle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SeaPickle::class.java)
                .function("pickles", 0) { it.target?.pickles }
                .function("setPickles", 1) { it.target?.setPickles(it.getNumber(0).toInt()) }
                .function("minimumPickles", 0) { it.target?.minimumPickles }
                .function("maximumPickles", 0) { it.target?.maximumPickles }
        }
    }
}
