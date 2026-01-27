package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractSkeleton
import org.bukkit.entity.Skeleton
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.AbstractSkeleton"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractSkeleton {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractSkeleton::class.java)
                .function(
                    "setSkeletonType",
                    1
                ) { it.target?.setSkeletonType(it.getArgument(0) as Skeleton.SkeletonType) }
        }
    }
}
