package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.Transformation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnTransformation {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Transformation::class.java)
//                .function("translation", 0) { it.target?.translation }
//                .function("leftRotation", 0) { it.target?.leftRotation }
//                .function("scale", 0) { it.target?.scale }
//                .function("rightRotation", 0) { it.target?.rightRotation }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
        }
    }
}
