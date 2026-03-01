package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector
import org.tabooproject.fluxon.platform.bukkit.util.divide
import org.tabooproject.fluxon.platform.bukkit.util.multiply
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
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


    val TYPE = Type.fromClass(Location::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // 构建向量
            // x, y, z
            registerFunction("location", returns(TYPE).params(Type.D, Type.D, Type.D)) {
                val x = it.getDouble(0)
                val y = it.getDouble(1)
                val z = it.getDouble(2)
                it.setReturnRef(Location(null, x, y, z))}
            // world, x, y, z
            registerFunction("location", returns(TYPE).params(FnWorld.TYPE, Type.D, Type.D, Type.D)) {
                val world = it.getRef(0) as? World
                val x = it.getDouble(1)
                val y = it.getDouble(2)
                val z = it.getDouble(3)
                it.setReturnRef(Location(world, x, y, z))}
            // x, y, z, yaw, pitch
            registerFunction("location", returns(TYPE).params(Type.D, Type.D, Type.D, Type.F, Type.F)) {
                val x = it.getDouble(0)
                val y = it.getDouble(1)
                val z = it.getDouble(2)
                val yaw = it.getFloat(3)
                val pitch = it.getFloat(4)
                it.setReturnRef(Location(null, x, y, z, yaw, pitch))}
            // world, x, y, z, yaw, pitch
            registerFunction("location", returns(TYPE).params(FnWorld.TYPE, Type.D, Type.D, Type.D, Type.F, Type.F)) {
                val world = it.getRef(0) as? World
                val x = it.getDouble(1)
                val y = it.getDouble(2)
                val z = it.getDouble(3)
                val yaw = it.getFloat(4)
                val pitch = it.getFloat(5)
                it.setReturnRef(Location(world, x, y, z, yaw, pitch))}

            registerExtension(Location::class.java)
                // 基本属性（只读）
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
//                .function("taboo", returns(Type.OBJECT).noParams()) { it.setReturnRef(it.target?.toProxyLocation()) }
                .function("block", returns(FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.block) }
                .function("blockX", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockX ?: 0) }
                .function("blockY", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockY ?: 0) }
                .function("blockZ", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockZ ?: 0) }
                .function("chunk", returns(FnChunk.TYPE).noParams()) { it.setReturnRef(it.target?.chunk) }
                .function("isWorldLoaded", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWorldLoaded ?: false) }
                .function("length", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.length() ?: 0.0) }
                .function("lengthSquared", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.lengthSquared() ?: 0.0) }
                .function("serialize", returns(Type.MAP).noParams()) { it.setReturnRef(it.target?.serialize()) }
                .function("toVector", returns(FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.toVector()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("zero", returns(TYPE).noParams()) { it.setReturnRef(it.target?.zero()) }

                // 可读写属性 - 坐标
                .function("x", returns(Type.D).noParams()) { it.setReturnDouble(it.target!!.x) }
                .function("setX", returns(TYPE).params(Type.D)) { it.setReturnRef(it.target?.apply { x = it.getDouble(0) }) }
                .function("y", returns(Type.D).noParams()) { it.setReturnDouble(it.target!!.y) }
                .function("setY", returns(TYPE).params(Type.D)) { it.setReturnRef(it.target?.apply { y = it.getDouble(0) }) }
                .function("z", returns(Type.D).noParams()) { it.setReturnDouble(it.target!!.z) }
                .function("setZ", returns(TYPE).params(Type.D)) { it.setReturnRef(it.target?.apply { z = it.getDouble(0) }) }

                // 可读写属性 - 朝向
                .function("yaw", returns(Type.F).noParams()) { it.setReturnFloat(it.target!!.yaw) }
                .function("setYaw", returns(TYPE).params(Type.F)) { it.setReturnRef(it.target?.apply { yaw = it.getFloat(0) }) }
                .function("pitch", returns(Type.F).noParams()) { it.setReturnFloat(it.target!!.pitch) }
                .function("setPitch", returns(TYPE).params(Type.F)) { it.setReturnRef(it.target?.apply { pitch = it.getFloat(0) }) }

                // 可读写属性 - 方向向量
                .function("direction", returns(FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.direction) }
                .function("setDirection", returns(TYPE).params(FnVector.TYPE)) { it.setReturnRef(it.target?.apply { direction = it.getRef(0) as Vector }) }

                // 可读写属性 - 世界
                .function("world", returns(FnWorld.TYPE).noParams()) { it.setReturnRef(it.target?.world) }
                .function("setWorld", returns(TYPE).params(TYPE)) {
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
                .function("add", returns(TYPE).params(TYPE)) {
                    it.setReturnRef(it.target?.add(it.getRef(0) as Location))
                }
                .function("add", returns(TYPE).params(FnVector.TYPE)) {
                    it.setReturnRef(it.target?.add(it.getRef(0) as Vector))
                }
                .function("add", returns(TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.add(it.getDouble(0), it.getDouble(1), it.getDouble(2)))
                }
                .function("subtract", returns(TYPE).params(TYPE)) {
                    it.setReturnRef(it.target?.subtract(it.getRef(0) as Location))
                }
                .function("subtract", returns(TYPE).params(FnVector.TYPE)) {
                    it.setReturnRef(it.target?.subtract(it.getRef(0) as Vector))
                }
                .function("subtract", returns(TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.subtract(it.getDouble(0), it.getDouble(1), it.getDouble(2)))
                }
                .function("multiply",returns(TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.multiply(it.getRef(0) as Location))
                }
                .function("multiply", returns(TYPE).params(Type.D)) {
                    it.setReturnRef(it.target?.multiply(it.getDouble(0)))
                }
                .function("divide",returns(TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) {
                    it.setReturnRef(it.target?.divide(it.getRef(0) as Location))
                }
                .function("divide", returns(TYPE).params(Type.D)) {
                    val arg = it.getDouble(0)
                    it.target?.divide(Location(null, arg, arg, arg))
                }

                .function("distance", returns(Type.D).params(TYPE)) {
                    it.setReturnDouble(it.target?.distance(it.getRef(0) as Location)!!)
                }
                .function("distanceSquared", returns(Type.D).params(TYPE)) {
                    it.setReturnDouble(it.target?.distanceSquared(it.getRef(0) as Location)!!)
                }

        }
    }
}
