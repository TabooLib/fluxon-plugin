package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.EulerAngle
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.EulerAngle"])
@PlatformSide(Platform.BUKKIT)
object FnEulerAngle {

    val TYPE = Type.fromClass(EulerAngle::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EulerAngle::class.java)
                .function("x", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.x ?: 0.0) }
                .function("y", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.y ?: 0.0) }
                .function("z", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.z ?: 0.0) }
                .function("setX",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnEulerAngle.TYPE).params(Type.D)) { it.setReturnRef(it.target?.setX(it.getDouble(0))) }
                .function("setY",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnEulerAngle.TYPE).params(Type.D)) { it.setReturnRef(it.target?.setY(it.getDouble(0))) }
                .function("setZ",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnEulerAngle.TYPE).params(Type.D)) { it.setReturnRef(it.target?.setZ(it.getDouble(0))) }
                .function("add",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnEulerAngle.TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.add(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("subtract",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnEulerAngle.TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.subtract(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
        }
    }
}
