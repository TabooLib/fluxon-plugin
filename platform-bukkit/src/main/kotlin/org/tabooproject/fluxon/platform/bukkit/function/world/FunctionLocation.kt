package org.tabooproject.fluxon.platform.bukkit.function.world

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.util.divide
import org.tabooproject.fluxon.platform.bukkit.util.multiply
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide


@PlatformSide(Platform.BUKKIT)
object FunctionLocation {

    @Awake(LifeCycle.LOAD)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            // 构建向量
            // x, y, z
            // world, x, y, z
            // x, y, z, yaw, pitch
            // world, x, y, z, yaw, pitch
            registerFunction("location", listOf(3, 4, 5, 6)) {
                when (it.arguments.size) {
                    3 -> {
                        // x, y, z
                        val x = it.getNumber(0)
                        val y = it.getNumber(1)
                        val z = it.getNumber(2)
                        Location(null, x.toDouble(), y.toDouble(), z.toDouble())
                    }

                    4 -> {
                        // world, x, y, z
                        val world = it.getArgument(0) as? World
                        val x = it.getNumber(1)
                        val y = it.getNumber(2)
                        val z = it.getNumber(3)
                        Location(world, x.toDouble(), y.toDouble(), z.toDouble())
                    }

                    5 -> {
                        // x, y, z, yaw, pitch
                        val x = it.getNumber(0)
                        val y = it.getNumber(1)
                        val z = it.getNumber(2)
                        val yaw = it.getNumber(3)
                        val pitch = it.getNumber(4)
                        Location(null, x.toDouble(), y.toDouble(), z.toDouble(), yaw.toFloat(), pitch.toFloat())
                    }

                    6 -> {
                        // world, x, y, z, yaw, pitch
                        val world = it.getArgument(0) as? World
                        val x = it.getNumber(1)
                        val y = it.getNumber(2)
                        val z = it.getNumber(3)
                        val yaw = it.getNumber(4)
                        val pitch = it.getNumber(5)
                        Location(world, x.toDouble(), y.toDouble(), z.toDouble(), yaw.toFloat(), pitch.toFloat())
                    }

                    else -> error("location 函数参数数量错误: ${it.arguments.contentDeepToString()}")
                }
            }

            registerExtension(Location::class.java)
                // 基本运算
                .function("add", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Location -> it.target?.add(arg.toVector())
                        is Number -> it.target?.add(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    }
                }
                .function("subtract", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Location -> it.target?.subtract(arg.toVector())
                        is Number -> it.target?.subtract(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    }
                }
                .function("multiply", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Location -> it.target?.multiply(arg)
                        is Number -> it.target?.multiply(Location(null, arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    }
                }
                .function("divide", 1) {
                    when (val arg = it.getArgument(0)!!) {
                        is Location -> it.target?.divide(arg)
                        is Number -> it.target?.divide(Location(null, arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    }
                }

                // 属性计算
                .function("world", 0) {
                    it.target?.world
                }
                .function("x", 0) {
                    it.target?.x
                }
                .function("y", 0) {
                    it.target?.y
                }
                .function("z", 0) {
                    it.target?.z
                }
                .function("yaw", 0) {
                    it.target?.yaw
                }
                .function("pitch", 0) {
                    it.target?.pitch
                }
                .function("direction", 0) {
                    it.target?.direction
                }
                .function("length", 0) {
                    it.target?.length()
                }
                .function("lengthSquared", 0) {
                    it.target?.lengthSquared()
                }
                .function("normalize", 0) {
                    it.target?.toVector()?.normalize()
                }
                .function("distance", 1) {
                    it.target?.distance(it.getArgumentByType(0, Location::class.java)!!)
                }
                .function("distanceSquared", 1) {
                    it.target?.distanceSquared(it.getArgumentByType(0, Location::class.java)!!)
                }
                .function("block", 0) {
                    it.target?.block
                }
                // 克隆
                .function("clone", 0) {
                    it.target?.clone()
                }
                // 转换为 Vector
                .function("toVector", 1) {
                    it.target?.toVector()
                }
        }
    }
}