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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EulerAngle::class.java)
                .function("x", returnsObject().noParams()) { it.target?.x }
                .function("y", returnsObject().noParams()) { it.target?.y }
                .function("z", returnsObject().noParams()) { it.target?.z }
                .function("setX", returnsObject().params(Type.OBJECT)) { it.target?.setX(it.getAsDouble(0)) }
                .function("setY", returnsObject().params(Type.OBJECT)) { it.target?.setY(it.getAsDouble(0)) }
                .function("setZ", returnsObject().params(Type.OBJECT)) { it.target?.setZ(it.getAsDouble(0)) }
                .function("add", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.add(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2)
                    )
                }
                .function("subtract", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.target?.subtract(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2)
                    )
                }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.target?.equals(it.getRef(0)) }
                .function("hashCode", returns(Type.I).noParams()) { it.target?.hashCode() }
        }
    }
}
