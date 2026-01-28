package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.noise

import org.bukkit.util.noise.OctaveGenerator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.noise.OctaveGenerator"])
@PlatformSide(Platform.BUKKIT)
object FnOctaveGenerator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OctaveGenerator::class.java)
                .function("setScale", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setScale(it.getAsDouble(0))) }
                .function("xScale", returnsObject().noParams()) { it.setReturnRef(it.target?.getXScale()) }
                .function("setXScale", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setXScale(it.getAsDouble(0))) }
                .function("yScale", returnsObject().noParams()) { it.setReturnRef(it.target?.getYScale()) }
                .function("setYScale", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setYScale(it.getAsDouble(0))) }
                .function("zScale", returnsObject().noParams()) { it.setReturnRef(it.target?.getZScale()) }
                .function("setZScale", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setZScale(it.getAsDouble(0))) }
                .function("octaves", returnsObject().noParams()) { it.setReturnRef(it.target?.getOctaves()) }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> when (val var4 = it.getRef(3)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            else -> throw IllegalArgumentException("第四个参数必须是 Boolean 或 Double 类型")
                        }

                        5 -> when (val var5 = it.getRef(4)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            else -> throw IllegalArgumentException("第五个参数必须是 Boolean 或 Double 类型")
                        }

                        6 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getBool(5)
                        )
                        else -> error("OctaveGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> when (val var4 = it.getRef(3)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            else -> throw IllegalArgumentException("第四个参数必须是 Boolean 或 Double 类型")
                        }

                        5 -> when (val var5 = it.getRef(4)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            else -> throw IllegalArgumentException("第五个参数必须是 Boolean 或 Double 类型")
                        }

                        6 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getBool(5)
                        )
                        else -> error("OctaveGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> when (val var4 = it.getRef(3)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            else -> throw IllegalArgumentException("第四个参数必须是 Boolean 或 Double 类型")
                        }

                        5 -> when (val var5 = it.getRef(4)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            else -> throw IllegalArgumentException("第五个参数必须是 Boolean 或 Double 类型")
                        }

                        6 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getBool(5)
                        )
                        else -> error("OctaveGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
                .function("noise", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        3 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> when (val var4 = it.getRef(3)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                var4
                            )

                            else -> throw IllegalArgumentException("第四个参数必须是 Boolean 或 Double 类型")
                        }

                        5 -> when (val var5 = it.getRef(4)) {
                            is Boolean -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            is Double -> it.target?.noise(
                                it.getAsDouble(0),
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3),
                                var5
                            )

                            else -> throw IllegalArgumentException("第五个参数必须是 Boolean 或 Double 类型")
                        }

                        6 -> it.target?.noise(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getBool(5)
                        )
                        else -> error("OctaveGenerator#noise 函数参数数量错误: ${"args"}")
                    })
                }
        }
    }
}
