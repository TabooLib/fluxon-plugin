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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.util.BoundingBox"])
@PlatformSide(Platform.BUKKIT)
object FnBoundingBox {

    val TYPE = Type.fromClass(BoundingBox::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BoundingBox::class.java)
                // static
                .function("of", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(BoundingBox.of(it.getRef(0) as Block))
                }
                .function("of", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Vector -> BoundingBox.of(var1, it.getRef(1) as Vector)
                        is Location -> BoundingBox.of(var1, it.getRef(1) as Location)
                        is Block -> BoundingBox.of(var1, it.getRef(1) as Block)
                        else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 Block 类型")
                    })
                }
                .function("of", returnsObject().params(Type.OBJECT, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Vector -> BoundingBox.of(
                            var1,
                            it.getDouble(1),
                            it.getDouble(2),
                            it.getDouble(3)
                        )
                        is Location -> BoundingBox.of(
                            var1,
                            it.getDouble(1),
                            it.getDouble(2),
                            it.getDouble(3)
                        )
                        else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 Location 类型")
                    })
                }
                .function("resize", returnsObject().params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.resize(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getDouble(5)
                    ))
                }
                .function("minX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.minX ?: 0.0) }
                .function("minY", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.minY ?: 0.0) }
                .function("minZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.minZ ?: 0.0) }
                .function("min", returnsObject().noParams()) { it.setReturnRef(it.target?.min) }
                .function("maxX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxX ?: 0.0) }
                .function("maxY", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxY ?: 0.0) }
                .function("maxZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxZ ?: 0.0) }
                .function("max", returnsObject().noParams()) { it.setReturnRef(it.target?.max) }
                .function("widthX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.widthX ?: 0.0) }
                .function("widthZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.widthZ ?: 0.0) }
                .function("height", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.height ?: 0.0) }
                .function("volume", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.volume ?: 0.0) }
                .function("centerX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.centerX ?: 0.0) }
                .function("centerY", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.centerY ?: 0.0) }
                .function("centerZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.centerZ ?: 0.0) }
                .function("center", returnsObject().noParams()) { it.setReturnRef(it.target?.center) }
                .function("copy", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.copy(it.getRef(0) as BoundingBox)) }
                .function("expand", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Vector -> it.target?.expand(var1)
                        is Double -> it.target?.expand(var1)
                        is Number -> it.target?.expand(var1.toDouble())
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Double 类型")
                    })
                }
                .function("expand", returnsObject().params(Type.OBJECT, Type.D)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Vector -> it.target?.expand(var1, it.getDouble(1))
                        is BlockFace -> it.target?.expand(var1, it.getDouble(1))
                        else -> throw IllegalArgumentException("第一个参数必须是 Vector 或 BlockFace 类型")
                    })
                }
                .function("expand", returnsObject().params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expand(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("expand", returnsObject().params(Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expand(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3)
                    ))
                }
                .function("expand", returnsObject().params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expand(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getDouble(5)
                    ))
                }
                .function("expandDirectional", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.expandDirectional(it.getRef(0) as Vector))
                }
                .function("expandDirectional", returnsObject().params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expandDirectional(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("union", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Vector -> it.target?.union(var1)
                        is Location -> it.target?.union(var1)
                        is BoundingBox -> it.target?.union(var1)
                        else -> throw IllegalArgumentException("参数必须是 Vector、Location 或 BoundingBox 类型")
                    })
                }
                .function("union", returnsObject().params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.union(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("intersection", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(it.target?.intersection(it.getRef(0) as BoundingBox))
                }
                .function("shift", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Vector -> it.target?.shift(var1)
                        is Location -> it.target?.shift(var1)
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 Location 类型")
                    })
                }
                .function("shift", returnsObject().params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.shift(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("overlaps", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.overlaps(it.getRef(0) as BoundingBox) ?: false)
                }
                .function("overlaps", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.overlaps(
                        it.getRef(0) as Vector,
                        it.getRef(1) as Vector
                    ) ?: false)
                }
                .function("contains", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(when (val var1 = it.getRef(0)) {
                        is Vector -> it.target?.contains(var1)
                        is BoundingBox -> it.target?.contains(var1)
                        else -> throw IllegalArgumentException("参数必须是 Vector 或 BoundingBox 类型")
                    } ?: false)
                }
                .function("contains", returns(Type.Z).params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnBool(it.target?.contains(
                        it.getRef(0) as Vector,
                        it.getRef(1) as Vector
                    ) ?: false)
                }
                .function("contains", returns(Type.Z).params(Type.D, Type.D, Type.D)) {
                    it.setReturnBool(it.target?.contains(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ) ?: false)
                }
                .function("rayTrace", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.D)) {
                    it.setReturnRef(it.target?.rayTrace(
                        it.getRef(0) as Vector,
                        it.getRef(1) as Vector,
                        it.getDouble(2)
                    ))
                }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnInt(it.target?.hashCode() ?: 0) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.equals(it.getRef(0)) ?: false)
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                // static
                .function("deserialize", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(BoundingBox.deserialize(it.getRef(0) as Map<String, Any>))
                }
        }
    }
}
