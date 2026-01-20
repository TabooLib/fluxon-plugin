package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BlockVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnBlockVector {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockVector::class.java)
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("clone", 0) { it.target?.clone() }
                // static
                .function("deserialize", 1) { BlockVector.deserialize(it.getArgument(0) as Map<String, Any>) }
        }
    }
}
