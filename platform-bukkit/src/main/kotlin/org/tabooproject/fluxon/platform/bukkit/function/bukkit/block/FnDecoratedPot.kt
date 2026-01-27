package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.Material
import org.bukkit.block.DecoratedPot
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.DecoratedPot"])
@PlatformSide(Platform.BUKKIT)
object FnDecoratedPot {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DecoratedPot::class.java)
                .function("setSherd", 2) {
                    it.target?.setSherd(
                        it.getArgument(0) as DecoratedPot.Side,
                        it.getArgument(1) as Material
                    )
                }
                .function("getSherd", 1) { it.target?.getSherd(it.getArgument(0) as DecoratedPot.Side) }
                .function("shards", 0) { it.target?.shards }
                .function("inventory", 0) { it.target?.inventory }
                .function("snapshotInventory", 0) { it.target?.snapshotInventory }
        }
    }
}
