package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ComplexLivingEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnComplexLivingEntity {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ComplexLivingEntity::class.java)
                .function("parts", 0) { it.target?.parts }
        }
    }
}
