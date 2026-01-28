package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.block.BlockFace
import org.bukkit.util.BoundingBox
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.BoundingBox"])
@PlatformSide(Platform.BUKKIT)
object FnBoundingBox {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BoundingBox::class.java)
                // static
                .function("of", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> BoundingBox.of(it.getRef(0) as Block)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> BoundingBox.of(var1, it.getRef(1) as Vector)
                            is Location -> BoundingBox.of(var1, it.getRef(1) as Location)
                            is Block -> BoundingBox.of(var1, it.getRef(1) as Block)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 Block 类型")
                        }

                        4 -> when (val var1 = it.getRef(0)) {
                            is Vector -> BoundingBox.of(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3)
                            )

                            is Location -> BoundingBox.of(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3)
                            )

                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 Location 类型")
                        }
                        else -> error("BoundingBox#of 函数参数数量错误: ${"args"}")
                    })
                }
                .function("of", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> BoundingBox.of(it.getRef(0) as Block)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> BoundingBox.of(var1, it.getRef(1) as Vector)
                            is Location -> BoundingBox.of(var1, it.getRef(1) as Location)
                            is Block -> BoundingBox.of(var1, it.getRef(1) as Block)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 Block 类型")
                        }

                        4 -> when (val var1 = it.getRef(0)) {
                            is Vector -> BoundingBox.of(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3)
                            )

                            is Location -> BoundingBox.of(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3)
                            )

                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 Location 类型")
                        }
                        else -> error("BoundingBox#of 函数参数数量错误: ${"args"}")
                    })
                }
                .function("of", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> BoundingBox.of(it.getRef(0) as Block)
                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> BoundingBox.of(var1, it.getRef(1) as Vector)
                            is Location -> BoundingBox.of(var1, it.getRef(1) as Location)
                            is Block -> BoundingBox.of(var1, it.getRef(1) as Block)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 Block 类型")
                        }

                        4 -> when (val var1 = it.getRef(0)) {
                            is Vector -> BoundingBox.of(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3)
                            )

                            is Location -> BoundingBox.of(
                                var1,
                                it.getAsDouble(1),
                                it.getAsDouble(2),
                                it.getAsDouble(3)
                            )

                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 Location 类型")
                        }
                        else -> error("BoundingBox#of 函数参数数量错误: ${"args"}")
                    })
                }
                .function("resize", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.resize(
                        it.getAsDouble(0),
                        it.getAsDouble(1),
                        it.getAsDouble(2),
                        it.getAsDouble(3),
                        it.getAsDouble(4),
                        it.getAsDouble(5)
                    ))
                }
                .function("minX", returnsObject().noParams()) { it.setReturnRef(it.target?.minX) }
                .function("minY", returnsObject().noParams()) { it.setReturnRef(it.target?.minY) }
                .function("minZ", returnsObject().noParams()) { it.setReturnRef(it.target?.minZ) }
                .function("min", returnsObject().noParams()) { it.setReturnRef(it.target?.min) }
                .function("maxX", returnsObject().noParams()) { it.setReturnRef(it.target?.maxX) }
                .function("maxY", returnsObject().noParams()) { it.setReturnRef(it.target?.maxY) }
                .function("maxZ", returnsObject().noParams()) { it.setReturnRef(it.target?.maxZ) }
                .function("max", returnsObject().noParams()) { it.setReturnRef(it.target?.max) }
                .function("widthX", returnsObject().noParams()) { it.setReturnRef(it.target?.widthX) }
                .function("widthZ", returnsObject().noParams()) { it.setReturnRef(it.target?.widthZ) }
                .function("height", returnsObject().noParams()) { it.setReturnRef(it.target?.height) }
                .function("volume", returnsObject().noParams()) { it.setReturnRef(it.target?.volume) }
                .function("centerX", returnsObject().noParams()) { it.setReturnRef(it.target?.centerX) }
                .function("centerY", returnsObject().noParams()) { it.setReturnRef(it.target?.centerY) }
                .function("centerZ", returnsObject().noParams()) { it.setReturnRef(it.target?.centerZ) }
                .function("center", returnsObject().noParams()) { it.setReturnRef(it.target?.center) }
                .function("copy", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.copy(it.getRef(0) as BoundingBox)) }
                .function("expand", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1)
                            is Double -> it.target?.expand(var1)
                            is Number -> it.target?.expand(var1.toDouble())
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                        }

                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1, it.getAsDouble(1))
                            is BlockFace -> it.target?.expand(var1, it.getAsDouble(1))
                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                        }

                        3 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        6 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("BoundingBox#expand 函数参数数量错误: ${"args"}")
                    })
                }
                .function("expand", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1)
                            is Double -> it.target?.expand(var1)
                            is Number -> it.target?.expand(var1.toDouble())
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                        }

                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1, it.getAsDouble(1))
                            is BlockFace -> it.target?.expand(var1, it.getAsDouble(1))
                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                        }

                        3 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        6 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("BoundingBox#expand 函数参数数量错误: ${"args"}")
                    })
                }
                .function("expand", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1)
                            is Double -> it.target?.expand(var1)
                            is Number -> it.target?.expand(var1.toDouble())
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                        }

                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1, it.getAsDouble(1))
                            is BlockFace -> it.target?.expand(var1, it.getAsDouble(1))
                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                        }

                        3 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        6 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("BoundingBox#expand 函数参数数量错误: ${"args"}")
                    })
                }
                .function("expand", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1)
                            is Double -> it.target?.expand(var1)
                            is Number -> it.target?.expand(var1.toDouble())
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                        }

                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1, it.getAsDouble(1))
                            is BlockFace -> it.target?.expand(var1, it.getAsDouble(1))
                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                        }

                        3 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        6 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("BoundingBox#expand 函数参数数量错误: ${"args"}")
                    })
                }
                .function("expand", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1)
                            is Double -> it.target?.expand(var1)
                            is Number -> it.target?.expand(var1.toDouble())
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                        }

                        2 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.expand(var1, it.getAsDouble(1))
                            is BlockFace -> it.target?.expand(var1, it.getAsDouble(1))
                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                        }

                        3 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )

                        4 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3)
                        )

                        6 -> it.target?.expand(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2),
                            it.getAsDouble(3),
                            it.getAsDouble(4),
                            it.getAsDouble(5)
                        )
                        else -> error("BoundingBox#expand 函数参数数量错误: ${"args"}")
                    })
                }
                .function("expandDirectional", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.expandDirectional(it.getRef(0) as Vector)
                    } else {
                        it.target?.expandDirectional(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                    })
                }
                .function("expandDirectional", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.expandDirectional(it.getRef(0) as Vector)
                    } else {
                        it.target?.expandDirectional(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                    })
                }
                .function("union", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.union(var1)
                            is Location -> it.target?.union(var1)
                            is BoundingBox -> it.target?.union(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 BoundingBox 类型")
                        }
                    } else {
                        it.target?.union(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                    })
                }
                .function("union", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.union(var1)
                            is Location -> it.target?.union(var1)
                            is BoundingBox -> it.target?.union(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 BoundingBox 类型")
                        }
                    } else {
                        it.target?.union(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                    })
                }
                .function("intersection", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.intersection(it.getRef(0) as BoundingBox)) }
                .function("shift", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.shift(var1)
                            is Location -> it.target?.shift(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Location 类型")
                        }
                    } else {
                        it.target?.shift(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                    })
                }
                .function("shift", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.shift(var1)
                            is Location -> it.target?.shift(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Location 类型")
                        }
                    } else {
                        it.target?.shift(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                    })
                }
                .function("overlaps", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.overlaps(it.getRef(0) as BoundingBox)
                    } else {
                        it.target?.overlaps(
                            it.getRef(0) as Vector,
                            it.getRef(1) as Vector
                        )
                    })
                }
                .function("overlaps", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(if (it.argumentCount == 1) {
                        it.target?.overlaps(it.getRef(0) as BoundingBox)
                    } else {
                        it.target?.overlaps(
                            it.getRef(0) as Vector,
                            it.getRef(1) as Vector
                        )
                    })
                }
                .function("contains", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.contains(var1)
                            is BoundingBox -> it.target?.contains(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 BoundingBox 类型")
                        }

                        2 -> it.target?.contains(
                            it.getRef(0) as Vector,
                            it.getRef(1) as Vector
                        )

                        3 -> it.target?.contains(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                        else -> error("BoundingBox#contains 函数参数数量错误: ${"args"}")
                    })
                }
                .function("contains", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.contains(var1)
                            is BoundingBox -> it.target?.contains(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 BoundingBox 类型")
                        }

                        2 -> it.target?.contains(
                            it.getRef(0) as Vector,
                            it.getRef(1) as Vector
                        )

                        3 -> it.target?.contains(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                        else -> error("BoundingBox#contains 函数参数数量错误: ${"args"}")
                    })
                }
                .function("contains", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (it.argumentCount) {
                        1 -> when (val var1 = it.getRef(0)) {
                            is Vector -> it.target?.contains(var1)
                            is BoundingBox -> it.target?.contains(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 BoundingBox 类型")
                        }

                        2 -> it.target?.contains(
                            it.getRef(0) as Vector,
                            it.getRef(1) as Vector
                        )

                        3 -> it.target?.contains(
                            it.getAsDouble(0),
                            it.getAsDouble(1),
                            it.getAsDouble(2)
                        )
                        else -> error("BoundingBox#contains 函数参数数量错误: ${"args"}")
                    })
                }
                .function("rayTrace", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.rayTrace(
                        it.getRef(0) as Vector,
                        it.getRef(1) as Vector,
                        it.getAsDouble(2)
                    ))
                }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                // static
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(BoundingBox.deserialize(it.getRef(0) as Map<String, Any>)) }
        }
    }
}
