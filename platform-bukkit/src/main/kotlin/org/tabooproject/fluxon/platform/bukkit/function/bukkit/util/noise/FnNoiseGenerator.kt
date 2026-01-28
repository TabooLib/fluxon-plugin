package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.NoiseGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.NoiseGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnNoiseGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NoiseGenerator::class.java)
                // static
                .function("floor", returnsObject().params(Type.OBJECT)) { NoiseGenerator.floor(it.getAsDouble(0)) }
                .function("noise", returnsObject().params(Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    when (it.argumentCount) {
                        1 -> it.target?.noise(it.getAsDouble(0))
                        2 -> it.target?.noise(it.getAsDouble(0), it.getAsDouble(1))
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getInt(1).toInt(),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        5 -> when (val var2 = it.getRef(1)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                it.getBool(4)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                var2,
                                it.getInt(2).toInt(),
                                it.getAsDouble(3),
                                it.getAsDouble(4)
                            )

                            else -> throw IllegalArgumentException("第二个参数必须是 Int 或 Double 类型")
                        }

                        6 -> when (val var3 = it.getRef(2)) {
                            is Int -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getAsDouble(3),
                                it.getAsDouble(4),
                                it.getBool(5)
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                var3,
                                it.getInt(3).toInt(),
                                it.getAsDouble(4),
                                it.getAsDouble(5)
                            )

                            else -> throw IllegalArgumentException("第三个参数必须是 Int 或 Double 类型")
                        }

                        7 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getInt(3).toInt(),
                            it.getAsDouble(4),
                            it.getAsDouble(5),
                            it.getBool(6)
                        )
                        else -> error("NoiseGenerator#noise 函数参数数量错误: ${"args"}")
                    }
                }
        }
    }
}
