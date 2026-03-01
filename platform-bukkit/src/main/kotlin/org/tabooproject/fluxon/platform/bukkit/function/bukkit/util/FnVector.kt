package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.World
import org.bukkit.util.Vector
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
 * org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector
 *
 * @author Lynn
 * @since 2026/1/6
 */
@Requires(classes = ["org.bukkit.util.Vector"])
@PlatformSide(Platform.BUKKIT)
object FnVector {

    val TYPE = Type.fromClass(Vector::class.java)
    private val TABOOLIB_VECTOR = Type.fromClass(taboolib.common.util.Vector::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            // 构建向量
            registerFunction("vector", returns(TYPE).params(Type.D, Type.D, Type.D)) {
                val x = it.getDouble(0)
                val y = it.getDouble(1)
                val z = it.getDouble(2)
                it.setReturnRef(Vector(x, y, z))
            }

            registerExtension(Vector::class.java)
                // 基本属性（只读）
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("taboo", returns(TABOOLIB_VECTOR).noParams()) { it.setReturnRef(it.target?.let { v -> taboolib.common.util.Vector(v.x, v.y, v.z) }) }
                .function("blockX", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockX ?: 0) }
                .function("blockY", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockY ?: 0) }
                .function("blockZ", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockZ ?: 0) }
                .function("length", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.length() ?: 0.0) }
                .function("lengthSquared", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.lengthSquared() ?: 0.0) }
                .function("isNormalized", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isNormalized ?: false) }
                .function("normalize",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.clone()?.normalize()) }
                .function("zero",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.clone()?.zero()) }

                // 可读写属性
                .function("x", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.x ?: 0.0) }
                .function("setX",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.apply { x = it.getDouble(0) }) }
                .function("y", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.y ?: 0.0) }
                .function("setY",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.apply { y = it.getDouble(0) }) }
                .function("z", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.z ?: 0.0) }
                .function("setZ",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.apply { z = it.getDouble(0) }) }

                // 基本运算
                .function("add",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Vector -> it.target?.add(arg)
                        is Number -> it.target?.add(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    })
                }
                .function("subtract",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnRef(it.target?.subtract(it.getRef(0) as Vector))
                }
                .function("subtract",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) {
                    val arg = it.getDouble(0)
                    it.setReturnRef(it.target?.subtract(Vector(arg, arg, arg)))
                }
                .function("multiply", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(it.target?.multiply(it.getRef(0) as Vector)) }
                .function("multiply", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.multiply(it.getDouble(0))) }
                .function("divide",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnRef(when (val arg = it.getRef(0)!!) {
                        is Vector -> it.target?.divide(arg)
                        is Number -> it.target?.divide(Vector(arg.toDouble(), arg.toDouble(), arg.toDouble()))
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Number 类型")
                    })
                }

                // 属性计算
                .function("distance",returns(Type.D).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnDouble(it.target?.distance(it.getRef(0) as Vector) ?: 0.0)
                }
                .function("distanceSquared",returns(Type.D).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnDouble(it.target?.distanceSquared(it.getRef(0) as Vector) ?: 0.0)
                }

                // 向量积运算
                .function("dot",returns(Type.D).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnDouble(it.target?.dot(it.getRef(0) as Vector) ?: 0.0)
                }
                .function("cross",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(it.target?.crossProduct(it.getRef(0) as Vector)) }

                // 向量旋转
                .function("rotateAroundX",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.rotateAroundX(it.getDouble(0))) }
                .function("rotateAroundY",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.rotateAroundY(it.getDouble(0))) }
                .function("rotateAroundZ",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(Type.D)) { it.setReturnRef(it.target?.rotateAroundZ(it.getDouble(0))) }
                .function("rotateAroundAxis",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D)) {
                    it.setReturnRef(it.target?.rotateAroundAxis(
                        it.getRef(0) as Vector,
                        it.getDouble(1)
                    ))
                }

                // 转换为 Location
                .function("toLocation",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnWorld.TYPE)) { it.setReturnRef(it.target?.toLocation(it.getRef(0)!! as World)) }
        }
    }
}
