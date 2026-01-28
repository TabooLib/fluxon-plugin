package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.PerlinNoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.PerlinNoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnPerlinNoiseGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PerlinNoiseGenerator::class.java)
                // static
                .function("getNoise", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4)
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4)
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4)
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4)
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4)
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("getNoise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> PerlinNoiseGenerator.getNoise(it.getAsDouble(0))
                        2 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1)
                        )

                        3 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getInt(2).toInt(),
                            it.getAsDouble(3),
                            it.getAsDouble(4)
                        )

                        6 -> PerlinNoiseGenerator.getNoise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("PerlinNoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                // static
                .function("instance", returnsObject().noParams()) { it.setReturnRef(PerlinNoiseGenerator.getInstance()) }
        }
    }
}
