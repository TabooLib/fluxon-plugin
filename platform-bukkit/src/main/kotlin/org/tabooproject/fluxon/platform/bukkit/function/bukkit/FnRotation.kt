package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Rotation
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Rotation"])
@PlatformSide(Platform.BUKKIT)
object FnRotation : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.Rotation>() {

    override val enumClass: Class<org.bukkit.Rotation> = org.bukkit.Rotation::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rotation::class.java)
                .function("rotateClockwise", returns(Type.fromClass(Rotation::class.java)).noParams()) { it.setReturnRef(it.target?.rotateClockwise()) }
                .function("rotateCounterClockwise", returns(Type.fromClass(Rotation::class.java)).noParams()) { it.setReturnRef(it.target?.rotateCounterClockwise()) }
        }
    }
}
