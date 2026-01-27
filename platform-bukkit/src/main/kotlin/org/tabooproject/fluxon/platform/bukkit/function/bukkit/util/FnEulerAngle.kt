package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.EulerAngle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.util.EulerAngle"])
@PlatformSide(Platform.BUKKIT)
object FnEulerAngle {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EulerAngle::class.java)
                .function("x", 0) { it.target?.x }
                .function("y", 0) { it.target?.y }
                .function("z", 0) { it.target?.z }
                .function("setX", 1) { it.target?.setX(it.getNumber(0).toDouble()) }
                .function("setY", 1) { it.target?.setY(it.getNumber(0).toDouble()) }
                .function("setZ", 1) { it.target?.setZ(it.getNumber(0).toDouble()) }
                .function("add", 3) {
                    it.target?.add(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("subtract", 3) {
                    it.target?.subtract(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
        }
    }
}
