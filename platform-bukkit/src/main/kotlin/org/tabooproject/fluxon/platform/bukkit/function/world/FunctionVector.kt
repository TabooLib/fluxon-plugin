package org.tabooproject.fluxon.platform.bukkit.function.world

import org.bukkit.World
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FunctionVector {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            // 构建向量
            registerFunction("vector", 3) {
                val x = it.getNumber(0)
                val y = it.getNumber(1)
                val z = it.getNumber(2)
                Vector(x.toDouble(), y.toDouble(), z.toDouble())
            }

            registerExtension(Vector::class.java)
                // 基本运算
                .function("add", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Vector -> it.target?.add(arg)
                        is Number -> it.target?.add(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    }
                }
                .function("subtract", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Vector -> it.target?.subtract(arg)
                        is Number -> it.target?.subtract(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    }
                }
                .function("multiply", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Vector -> it.target?.multiply(arg)
                        is Number -> it.target?.multiply(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    }
                }
                .function("divide", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Vector -> it.target?.divide(arg)
                        is Number -> it.target?.divide(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    }
                }

                // 属性计算
                .function("x", 0) {
                    it.target?.x
                }
                .function("y", 0) {
                    it.target?.y
                }
                .function("z", 0) {
                    it.target?.z
                }
                .function("length", 0) {
                    it.target?.length()
                }
                .function("lengthSquared", 0) {
                    it.target?.lengthSquared()
                }
                .function("normalize", 0) {
                    it.target?.normalize()
                }
                .function("distance", 1) {
                    it.target?.distance(it.getArgumentByType(0, Vector::class.java)!!)
                }
                .function("distanceSquared", 1) {
                    it.target?.distanceSquared(it.getArgumentByType(0, Vector::class.java)!!)
                }

                // 向量积运算
                .function("dot", 1) {
                    it.target?.dot(it.getArgumentByType(0, Vector::class.java)!!)
                }
                .function("cross", 1) {
                    it.target?.crossProduct(it.getArgumentByType(0, Vector::class.java)!!)
                }

                // 向量旋转
                .function("rotateAroundX", 1) {
                    it.target?.rotateAroundX(it.getNumber(0).toDouble())
                }
                .function("rotateAroundY", 1) {
                    it.target?.rotateAroundY(it.getNumber(0).toDouble())
                }
                .function("rotateAroundZ", 1) {
                    it.target?.rotateAroundZ(it.getNumber(0).toDouble())
                }
                .function("rotateAroundAxis", 2) {
                    it.target?.rotateAroundAxis(
                        it.getArgumentByType(0, Vector::class.java)!!,
                        it.getNumber(1).toDouble()
                    )
                }

                // 克隆
                .function("clone", 0) {
                    it.target?.clone()
                }

                // 转换为 Location
                .function("toLocation", 1) {
                    it.target?.toLocation(it.getArgument(0)!! as World)
                }
        }
    }
}