package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.GrassSpecies
import org.bukkit.material.LongGrass
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.material.LongGrass"])
@PlatformSide(Platform.BUKKIT)
object FnLongGrass {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LongGrass::class.java)
                .function("species", 0) { it.target?.species }
                .function("setSpecies", 1) { it.target?.setSpecies(it.getArgument(0) as GrassSpecies) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
