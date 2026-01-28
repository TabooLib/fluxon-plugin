package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.World
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

/**
 * FluxonPlugin
 * org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector
 *
 * @author Lynn
 * @since 2026/1/6
 */
@Requires(classes = ["org.bukkit.util.Vector"])
@PlatformSide(Platform.BUKKIT)
object FnVector {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // 构建向量
            registerFunction("vector", returnsObject().params(Type.D, Type.D, Type.D)) {
                val x = it.getInt(0)
                val y = it.getInt(1)
                val z = it.getInt(2)
                it.setReturnRef(Vector(x.toDouble(), y.toDouble(), z.toDouble()))}

            registerExtension(Vector::class.java)
                // 基本属性（只读）
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("taboo", returnsObject().noParams()) { it.setReturnRef(it.target?.let { v -> taboolib.common.util.Vector(v.x, v.y, v.z) }) }
                .function("blockX", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockX) }
                .function("blockY", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockY) }
                .function("blockZ", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockZ) }
                .function("length", returns(Type.D).noParams()) { it.setReturnRef(it.target?.length()) }
                .function("lengthSquared", returns(Type.D).noParams()) { it.setReturnRef(it.target?.lengthSquared()) }
                .function("isNormalized", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isNormalized) }
                .function("normalize", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()?.normalize()) }
                .function("zero", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()?.zero()) }

                // 可读写属性
                .function("x", returns(Type.D).noParams()) { it.setReturnRef(it.target?.x) }
                .function("setX", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.apply { x = it.getAsDouble(0) }) }
                .function("y", returns(Type.D).noParams()) { it.setReturnRef(it.target?.y) }
                .function("setY", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.apply { y = it.getAsDouble(0) }) }
                .function("z", returns(Type.D).noParams()) { it.setReturnRef(it.target?.z) }
                .function("setZ", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.apply { z = it.getAsDouble(0) }) }

                // 基本运算
                .function("add", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Vector -> it.target?.add(arg)
                        is Number -> it.target?.add(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    })
                }
                .function("subtract", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Vector -> it.target?.subtract(arg)
                        is Number -> it.target?.subtract(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    })
                }
                .function("multiply", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Vector -> it.target?.multiply(arg)
                        is Number -> it.target?.multiply(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    })
                }
                .function("divide", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Vector -> it.target?.divide(arg)
                        is Number -> it.target?.divide(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    })
                }

                // 属性计算
                .function("distance", returns(Type.D).params(Type.OBJECT)) { it.setReturnRef(it.target?.distance(it.getRef(0) as Vector)) }
                .function("distanceSquared", returns(Type.D).params(Type.OBJECT)) { it.setReturnRef(it.target?.distanceSquared(it.getRef(0) as Vector)) }

                // 向量积运算
                .function("dot", returns(Type.D).params(Type.OBJECT)) { it.setReturnRef(it.target?.dot(it.getRef(0) as Vector)) }
                .function("cross", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.crossProduct(it.getRef(0) as Vector)) }

                // 向量旋转
                .function("rotateAroundX", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.rotateAroundX(it.getAsDouble(0))) }
                .function("rotateAroundY", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.rotateAroundY(it.getAsDouble(0))) }
                .function("rotateAroundZ", returnsObject().params(Type.D)) { it.setReturnRef(it.target?.rotateAroundZ(it.getAsDouble(0))) }
                .function("rotateAroundAxis", returnsObject().params(Type.OBJECT, Type.D)) {
                    it.setReturnRef(it.target?.rotateAroundAxis(
                        it.getRef(0) as Vector,
                        it.getAsDouble(1)
                    ))
                }

                // 转换为 Location
                .function("toLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.toLocation(it.getRef(0)!! as World)) }
        }
    }
}