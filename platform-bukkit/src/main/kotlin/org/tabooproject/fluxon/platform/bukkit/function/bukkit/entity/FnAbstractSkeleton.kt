package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import Skeleton.SkeletonType
import org.bukkit.entity.AbstractSkeleton
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

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
