package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.SimplexNoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnSimplexNoiseGenerator {

    val TYPE = Type.fromClass(SimplexNoiseGenerator::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexNoiseGenerator::class.java)
                // static
                .function("getNoise", returns(Type.D).params(Type.D)) {
                    it.setReturnDouble(SimplexNoiseGenerator.getNoise(it.getDouble(0)))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D)) {
                    it.setReturnDouble(SimplexNoiseGenerator.getNoise(
                        it.getDouble(0),
                        it.getDouble(1)
                    ))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(SimplexNoiseGenerator.getNoise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("getNoise", returns(Type.D).params(Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnDouble(SimplexNoiseGenerator.getNoise(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3)
                    ))
                }
                // static
                .function("instance", returns(TYPE).noParams()) {
                    it.setReturnRef(SimplexNoiseGenerator.getInstance())
                }
        }
    }
}
