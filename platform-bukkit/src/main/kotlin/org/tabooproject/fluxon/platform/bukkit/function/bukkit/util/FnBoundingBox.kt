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

@PlatformSide(Platform.BUKKIT)
object FnBoundingBox {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BoundingBox::class.java)
                // static
                .function("of", listOf(1, 2, 4)) {
                    when (it.arguments.size) {
                        1 -> BoundingBox.of(it.getArgument(0) as Block)
                        2 -> when (val var1 = it.getArgument(0)) {
                            is Vector -> BoundingBox.of(var1, it.getArgument(1) as Vector)
                            is Location -> BoundingBox.of(var1, it.getArgument(1) as Location)
                            is Block -> BoundingBox.of(var1, it.getArgument(1) as Block)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 Block 类型")
                        }

                        4 -> when (val var1 = it.getArgument(0)) {
                            is Vector -> BoundingBox.of(
                                var1,
                                it.getNumber(1).toDouble(),
                                it.getNumber(2).toDouble(),
                                it.getNumber(3).toDouble()
                            )

                            is Location -> BoundingBox.of(
                                var1,
                                it.getNumber(1).toDouble(),
                                it.getNumber(2).toDouble(),
                                it.getNumber(3).toDouble()
                            )

                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 Location 类型")
                        }
                        else -> error("BoundingBox#of 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("resize", 6) {
                    it.target?.resize(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble()
                    )
                }
                .function("minX", 0) { it.target?.minX }
                .function("minY", 0) { it.target?.minY }
                .function("minZ", 0) { it.target?.minZ }
                .function("min", 0) { it.target?.min }
                .function("maxX", 0) { it.target?.maxX }
                .function("maxY", 0) { it.target?.maxY }
                .function("maxZ", 0) { it.target?.maxZ }
                .function("max", 0) { it.target?.max }
                .function("widthX", 0) { it.target?.widthX }
                .function("widthZ", 0) { it.target?.widthZ }
                .function("height", 0) { it.target?.height }
                .function("volume", 0) { it.target?.volume }
                .function("centerX", 0) { it.target?.centerX }
                .function("centerY", 0) { it.target?.centerY }
                .function("centerZ", 0) { it.target?.centerZ }
                .function("center", 0) { it.target?.center }
                .function("copy", 1) { it.target?.copy(it.getArgument(0) as BoundingBox) }
                .function("expand", listOf(1, 2, 3, 4, 6)) {
                    when (it.arguments.size) {
                        1 -> when (val var1 = it.getArgument(0)) {
                            is Vector -> it.target?.expand(var1)
                            is Double -> it.target?.expand(var1)
                            is Number -> it.target?.expand(var1.toDouble())
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                        }

                        2 -> when (val var1 = it.getArgument(0)) {
                            is Vector -> it.target?.expand(var1, it.getNumber(1).toDouble())
                            is BlockFace -> it.target?.expand(var1, it.getNumber(1).toDouble())
                            else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                        }

                        3 -> it.target?.expand(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )

                        4 -> it.target?.expand(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble()
                        )

                        6 -> it.target?.expand(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble(),
                            it.getNumber(3).toDouble(),
                            it.getNumber(4).toDouble(),
                            it.getNumber(5).toDouble()
                        )
                        else -> error("BoundingBox#expand 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("expandDirectional", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        it.target?.expandDirectional(it.getArgument(0) as Vector)
                    } else {
                        it.target?.expandDirectional(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )
                    }
                }
                .function("union", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Vector -> it.target?.union(var1)
                            is Location -> it.target?.union(var1)
                            is BoundingBox -> it.target?.union(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 BoundingBox 类型")
                        }
                    } else {
                        it.target?.union(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )
                    }
                }
                .function("intersection", 1) { it.target?.intersection(it.getArgument(0) as BoundingBox) }
                .function("shift", listOf(1, 3)) {
                    if (it.arguments.size == 1) {
                        when (val var1 = it.getArgument(0)) {
                            is Vector -> it.target?.shift(var1)
                            is Location -> it.target?.shift(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 Location 类型")
                        }
                    } else {
                        it.target?.shift(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )
                    }
                }
                .function("overlaps", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.overlaps(it.getArgument(0) as BoundingBox)
                    } else {
                        it.target?.overlaps(
                            it.getArgument(0) as Vector,
                            it.getArgument(1) as Vector
                        )
                    }
                }
                .function("contains", listOf(1, 2, 3)) {
                    when (it.arguments.size) {
                        1 -> when (val var1 = it.getArgument(0)) {
                            is Vector -> it.target?.contains(var1)
                            is BoundingBox -> it.target?.contains(var1)
                            else -> throw IllegalArgumentException("参数必须是 Vector 或 BoundingBox 类型")
                        }

                        2 -> it.target?.contains(
                            it.getArgument(0) as Vector,
                            it.getArgument(1) as Vector
                        )

                        3 -> it.target?.contains(
                            it.getNumber(0).toDouble(),
                            it.getNumber(1).toDouble(),
                            it.getNumber(2).toDouble()
                        )
                        else -> error("BoundingBox#contains 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                    }
                }
                .function("rayTrace", 3) {
                    it.target?.rayTrace(
                        it.getArgument(0) as Vector,
                        it.getArgument(1) as Vector,
                        it.getNumber(2).toDouble()
                    )
                }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("toString", 0) { it.target?.toString() }
                .function("clone", 0) { it.target?.clone() }
                // static
                .function("deserialize", 1) { BoundingBox.deserialize(it.getArgument(0) as Map<String, Any>) }
        }
    }
}
