package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Bukkit
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
import taboolib.platform.util.toProxyLocation
import taboolib.common.Requires

/**
 * FluxonPlugin
 * org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnLocation
 *
 * @author Lynn
 * @since 2026/1/6
 */
@Requires(classes = ["org.bukkit.Location"])
@PlatformSide(Platform.BUKKIT)
object FnLocation {

    @Awake(LifeCycle.INIT)
    private fun init() {
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
                // 基本属性（只读）
                .function("clone", 0) { it.target?.clone() }
                .function("taboo", 0) { it.target?.toProxyLocation() }
                .function("block", 0) { it.target?.block }
                .function("blockX", 0) { it.target?.blockX }
                .function("blockY", 0) { it.target?.blockY }
                .function("blockZ", 0) { it.target?.blockZ }
                .function("chunk", 0) { it.target?.chunk }
                .function("isWorldLoaded", 0) { it.target?.isWorldLoaded }
                .function("length", 0) { it.target?.length() }
                .function("lengthSquared", 0) { it.target?.lengthSquared() }
                .function("serialize", 0) { it.target?.serialize() }
                .function("toVector", 0) { it.target?.toVector() }
                .function("toString", 0) { it.target?.toString() }
                .function("zero", 0) { it.target?.zero() }

                // 可读写属性 - 坐标
                .function("x", 0) { it.target?.x }
                .function("setX", 1) { it.target?.apply { x = it.getNumber(0).toDouble() } }
                .function("y", 0) { it.target?.y }
                .function("setY", 1) { it.target?.apply { y = it.getNumber(0).toDouble() } }
                .function("z", 0) { it.target?.z }
                .function("setZ", 1) { it.target?.apply { z = it.getNumber(0).toDouble() } }

                // 可读写属性 - 朝向
                .function("yaw", 0) { it.target?.yaw }
                .function("setYaw", 1) { it.target?.apply { yaw = it.getNumber(0).toFloat() } }
                .function("pitch", 0) { it.target?.pitch }
                .function("setPitch", 1) { it.target?.apply { pitch = it.getNumber(0).toFloat() } }

                // 可读写属性 - 方向向量
                .function("direction", 0) { it.target?.direction }
                .function("setDirection", 1) { it.target?.apply { direction = it.getArgument(0) as Vector } }

                // 可读写属性 - 世界
                .function("world", 0) { it.target?.world }
                .function("setWorld", 1) {
                    it.target?.apply {
                        world = when (val value = it.getArgument(0)) {
                            is World -> value
                            is String -> Bukkit.getWorld(value)
                            is Location -> value.world
                            else -> throw IllegalArgumentException("参数必须是 World 或 String 或 Location 类型")
                        }
                    }
                }

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

                .function("distance", 1) {
                    it.target?.distance(it.getArgument(0) as Location)
                }
                .function("distanceSquared", 1) {
                    it.target?.distanceSquared(it.getArgument(0) as Location)
                }

        }
    }
}