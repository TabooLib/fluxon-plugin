package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.entity.Entity
import org.bukkit.generator.LimitedRegion
import org.bukkit.util.EntityTransformer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.util.EntityTransformer"])
@PlatformSide(Platform.BUKKIT)
object FnEntityTransformer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityTransformer::class.java)
                .function("transform", 6) {
                    it.target?.transform(
                        it.getArgument(0) as LimitedRegion,
                        it.getNumber(1).toInt(),
                        it.getNumber(2).toInt(),
                        it.getNumber(3).toInt(),
                        it.getArgument(4) as Entity,
                        it.getBoolean(5)
                    )
                }
        }
    }
}
