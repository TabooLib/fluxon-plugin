package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Slab
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.data.type.Slab"])
@PlatformSide(Platform.BUKKIT)
object FnSlab {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Slab::class.java)
                .function("type", 0) { it.target?.type }
                .function("setType", 1) { it.target?.setType(it.getArgument(0) as Slab.Type) }
        }
    }
}
