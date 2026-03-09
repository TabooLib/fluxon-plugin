package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexOctaveGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.SimplexOctaveGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnSimplexOctaveGenerator {

    val TYPE = Type.fromClass(SimplexOctaveGenerator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexOctaveGenerator::class.java)
                .function("setScale", returnsVoid().params(Type.D)) { it.target?.setScale(it.getAsDouble(0)) }
                .function("wScale", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.wScale ?: 0.0) }
                .function("setWScale", returnsVoid().params(Type.D)) { it.target?.setWScale(it.getAsDouble(0)) }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2),
                        it.getAsDouble(3),
                        it.getAsDouble(4),
                        it.getAsDouble(5)
                    ) ?: 0.0)
                }
                .function("noise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.D, Type.Z)) {
                    it.setReturnDouble(it.target?.noise(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2),
                        it.getAsDouble(3),
                        it.getAsDouble(4),
                        it.getAsDouble(5),
                        it.getBool(6)
                    ) ?: 0.0)
                }
        }
    }
}
