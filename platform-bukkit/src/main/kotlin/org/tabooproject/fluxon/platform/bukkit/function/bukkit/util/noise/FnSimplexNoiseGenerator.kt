package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.SimplexNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.SimplexNoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnSimplexNoiseGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SimplexNoiseGenerator::class.java)
                // static
                .function("getNoise", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> SimplexNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                        else -> error("SimplexNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> SimplexNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                        else -> error("SimplexNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> SimplexNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                        else -> error("SimplexNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> SimplexNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> SimplexNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )
                        else -> error("SimplexNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                // static
                .function("instance", returnsObject().noParams()) { it.setReturnRef(SimplexNoiseGenerator.getInstance()) }
        }
    }
}
