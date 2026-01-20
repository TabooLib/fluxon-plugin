package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.Material
import org.bukkit.material.TexturedMaterial
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTexturedMaterial {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TexturedMaterial::class.java)
                .function("textures", 0) { it.target?.textures }
                .function("material", 0) { it.target?.material }
                .function("setMaterial", 1) { it.target?.setMaterial(it.getArgument(0) as Material) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
