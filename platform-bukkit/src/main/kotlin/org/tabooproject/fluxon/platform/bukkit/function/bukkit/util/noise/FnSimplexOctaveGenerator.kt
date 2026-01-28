package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexOctaveGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.SimplexOctaveGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnSimplexOctaveGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexOctaveGenerator::class.java)
                .function("setScale", returnsObject().params(Type.OBJECT)) { it.target?.setScale(it.getAsDouble(0)) }
                .function("wScale", returnsObject().noParams()) { it.target?.wScale }
                .function("setWScale", returnsObject().params(Type.OBJECT)) { it.target?.setWScale(it.getAsDouble(0)) }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 6) {
                        it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                    } else {
                        it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    if (it.argumentCount == 6) {
                        it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                    } else {
                        it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                    }
                }
        }
    }
}
