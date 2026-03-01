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
                .function("of",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE)) {
                    it.setReturnRef(BoundingBox.of(it.getRef(0) as Block))
                }
                .function("of", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(BoundingBox.of(it.getRef(0) as Vector, it.getRef(1) as Vector)) }
                .function("of", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.setReturnRef(BoundingBox.of(it.getRef(0) as Location, it.getRef(1) as Location)) }
                .function("of", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE)) { it.setReturnRef(BoundingBox.of(it.getRef(0) as Block, it.getRef(1) as Block)) }
                .function("of", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D, Type.D, Type.D)) { it.setReturnRef(BoundingBox.of(it.getRef(0) as Vector, it.getDouble(1), it.getDouble(2), it.getDouble(3))) }
                .function("of", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE, Type.D, Type.D, Type.D)) { it.setReturnRef(BoundingBox.of(it.getRef(0) as Location, it.getDouble(1), it.getDouble(2), it.getDouble(3))) }
                .function("resize",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.D)) {
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
                .function("min",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.min) }
                .function("maxX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxX ?: 0.0) }
                .function("maxY", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxY ?: 0.0) }
                .function("maxZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.maxZ ?: 0.0) }
                .function("max",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.max) }
                .function("widthX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.widthX ?: 0.0) }
                .function("widthZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.widthZ ?: 0.0) }
                .function("height", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.height ?: 0.0) }
                .function("volume", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.volume ?: 0.0) }
                .function("centerX", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.centerX ?: 0.0) }
                .function("centerY", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.centerY ?: 0.0) }
                .function("centerZ", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.centerZ ?: 0.0) }
                .function("center",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.center) }
                .function("copy",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE)) { it.setReturnRef(it.target?.copy(it.getRef(0) as BoundingBox)) }
                .function("expand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(it.target?.expand(it.getRef(0) as Vector)) }
                .function("expand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D)) { it.setReturnRef(it.target?.expand(it.getDouble(0))) }
                .function("expand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D)) { it.setReturnRef(it.target?.expand(it.getRef(0) as Vector, it.getDouble(1))) }
                .function("expand", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE, Type.D)) { it.setReturnRef(it.target?.expand(it.getRef(0) as BlockFace, it.getDouble(1))) }
                .function("expand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expand(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("expand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expand(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3)
                    ))
                }
                .function("expand",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D, Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expand(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2),
                        it.getDouble(3),
                        it.getDouble(4),
                        it.getDouble(5)
                    ))
                }
                .function("expandDirectional",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnRef(it.target?.expandDirectional(it.getRef(0) as Vector))
                }
                .function("expandDirectional",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.expandDirectional(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("union", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(it.target?.union(it.getRef(0) as Vector)) }
                .function("union", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.setReturnRef(it.target?.union(it.getRef(0) as Location)) }
                .function("union", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(TYPE)) { it.setReturnRef(it.target?.union(it.getRef(0) as BoundingBox)) }
                .function("union",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.union(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("intersection",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE)) {
                    it.setReturnRef(it.target?.intersection(it.getRef(0) as BoundingBox))
                }
                .function("shift", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(it.target?.shift(it.getRef(0) as Vector)) }
                .function("shift", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE)) { it.setReturnRef(it.target?.shift(it.getRef(0) as Location)) }
                .function("shift",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.D, Type.D, Type.D)) {
                    it.setReturnRef(it.target?.shift(
                        it.getDouble(0),
                        it.getDouble(1),
                        it.getDouble(2)
                    ))
                }
                .function("overlaps",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE)) {
                    it.setReturnBool(it.target?.overlaps(it.getRef(0) as BoundingBox) ?: false)
                }
                .function("overlaps",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
                    it.setReturnBool(it.target?.overlaps(
                        it.getRef(0) as Vector,
                        it.getRef(1) as Vector
                    ) ?: false)
                }
                .function("contains", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnBool(it.target?.contains(it.getRef(0) as Vector) ?: false) }
                .function("contains", returns(Type.Z).params(TYPE)) { it.setReturnBool(it.target?.contains(it.getRef(0) as BoundingBox) ?: false) }
                .function("contains",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) {
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
                .function("rayTrace",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnRayTraceResult.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.D)) {
                    it.setReturnRef(it.target?.rayTrace(
                        it.getRef(0) as Vector,
                        it.getRef(1) as Vector,
                        it.getDouble(2)
                    ))
                }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                // static
                .function("deserialize",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnBoundingBox.TYPE).params(Type.MAP)) {
                    it.setReturnRef(BoundingBox.deserialize(it.getRef(0) as Map<String, Any>))
                }
        }
    }
}
