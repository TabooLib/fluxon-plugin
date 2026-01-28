package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.util.divide
import org.tabooproject.fluxon.platform.bukkit.util.multiply
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
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
            registerFunction("location", returnsObject().params(Type.D, Type.D, Type.D)) {
                val x = it.getDouble(0)
                val y = it.getDouble(1)
                val z = it.getDouble(2)
                it.setReturnRef(Location(null, x, y, z))}
            // world, x, y, z
            registerFunction("location", returnsObject().params(Type.OBJECT, Type.D, Type.D, Type.D)) {
                val world = it.getRef(0) as? World
                val x = it.getDouble(1)
                val y = it.getDouble(2)
                val z = it.getDouble(3)
                it.setReturnRef(Location(world, x, y, z))}
            // x, y, z, yaw, pitch
            registerFunction("location", returnsObject().params(Type.D, Type.D, Type.D, Type.F, Type.F)) {
                val x = it.getDouble(0)
                val y = it.getDouble(1)
                val z = it.getDouble(2)
                val yaw = it.getFloat(3)
                val pitch = it.getFloat(4)
                it.setReturnRef(Location(null, x, y, z, yaw, pitch))}
            // world, x, y, z, yaw, pitch
            registerFunction("location", returnsObject().params(Type.OBJECT, Type.D, Type.D, Type.D, Type.F, Type.F)) {
                val world = it.getRef(0) as? World
                val x = it.getDouble(1)
                val y = it.getDouble(2)
                val z = it.getDouble(3)
                val yaw = it.getFloat(4)
                val pitch = it.getFloat(5)
                it.setReturnRef(Location(world, x, y, z, yaw, pitch))}

            registerExtension(Location::class.java)
                // 基本属性（只读）
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("taboo", returnsObject().noParams()) { it.setReturnRef(it.target?.toProxyLocation()) }
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
                .function("blockX", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockX) }
                .function("blockY", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockY) }
                .function("blockZ", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockZ) }
                .function("chunk", returnsObject().noParams()) { it.setReturnRef(it.target?.chunk) }
                .function("isWorldLoaded", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isWorldLoaded) }
                .function("length", returns(Type.D).noParams()) { it.setReturnRef(it.target?.length()) }
                .function("lengthSquared", returns(Type.D).noParams()) { it.setReturnRef(it.target?.lengthSquared()) }
                .function("serialize", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.serialize()) }
                .function("toVector", returnsObject().noParams()) { it.setReturnRef(it.target?.toVector()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("zero", returnsObject().noParams()) { it.setReturnRef(it.target?.zero()) }

                // 可读写属性 - 坐标
                .function("x", returns(Type.D).noParams()) { it.setReturnDouble(it.target!!.x) }
                .function("setX", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.apply { x = it.getAsDouble(0) }) }
                .function("y", returns(Type.D).noParams()) { it.setReturnDouble(it.target!!.y) }
                .function("setY", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.apply { y = it.getAsDouble(0) }) }
                .function("z", returns(Type.D).noParams()) { it.setReturnDouble(it.target!!.z) }
                .function("setZ", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.apply { z = it.getAsDouble(0) }) }

                // 可读写属性 - 朝向
                .function("yaw", returns(Type.F).noParams()) { it.setReturnFloat(it.target!!.yaw) }
                .function("setYaw", returnsObject().params(Type.F)) { it.setReturnRef(it.target?.apply { yaw = it.getFloat(0) }) }
                .function("pitch", returns(Type.F).noParams()) { it.setReturnFloat(it.target!!.pitch) }
                .function("setPitch", returnsObject().params(Type.F)) { it.setReturnRef(it.target?.apply { pitch = it.getFloat(0) }) }

                // 可读写属性 - 方向向量
                .function("direction", returnsObject().noParams()) { it.setReturnRef(it.target?.direction) }
                .function("setDirection", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.apply { direction = it.getRef(0) as Vector }) }

                // 可读写属性 - 世界
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("setWorld", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.apply {
                        world = when (val value = it.getRef(0)) {
                            is World -> value
                            is String -> Bukkit.getWorld(value)
                            is Location -> value.world
                            else -> throw IllegalArgumentException("参数必须是 World 或 String 或 Location 类型")
                        }
                    })
                }

                // 基本运算
                .function("add", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Location -> it.target?.add(arg.toVector())
                        is Number -> it.target?.add(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    })
                }
                .function("subtract", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Location -> it.target?.subtract(arg.toVector())
                        is Number -> it.target?.subtract(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    })
                }
                .function("multiply", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Location -> it.target?.multiply(arg)
                        is Number -> it.target?.multiply(Location(null, arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    })
                }
                .function("divide", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Location -> it.target?.divide(arg)
                        is Number -> it.target?.divide(Location(null, arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Location 或 Number 类型")
                    })
                }

        }
    }
}