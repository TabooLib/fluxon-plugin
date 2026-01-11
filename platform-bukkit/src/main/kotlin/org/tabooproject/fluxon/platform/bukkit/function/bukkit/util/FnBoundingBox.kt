package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.block.Block
import org.bukkit.util.BoundingBox
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnBoundingBox {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BoundingBox::class.java)
                // static
                .function("of", 2) {
                    // static BoundingBox of(@NotNull Vector corner1, @NotNull Vector corner2)
                    // static BoundingBox of(@NotNull Location corner1, @NotNull Location corner2)
                    // static BoundingBox of(@NotNull Block corner1, @NotNull Block corner2)
                    TODO()
                }
                // static
                .function("of", 1) { BoundingBox.of(it.getArgument(0) as Block) }
                // static
                .function("of", 4) {
                    // static BoundingBox of(@NotNull Vector center, double x, double y, double z)
                    // static BoundingBox of(@NotNull Location center, double x, double y, double z)
                    TODO()
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
                .function("expand", 6) {
                    it.target?.expand(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble(),
                        it.getNumber(4).toDouble(),
                        it.getNumber(5).toDouble()
                    )
                }
                .function("expand", 3) {
                    it.target?.expand(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("expand", 1) {
                    // BoundingBox expand(@NotNull Vector expansion)
                    // BoundingBox expand(double expansion)
                    TODO()
                }
                .function("expand", 4) {
                    it.target?.expand(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble(),
                        it.getNumber(3).toDouble()
                    )
                }
                .function("expand", 2) {
                    // BoundingBox expand(@NotNull Vector direction, double expansion)
                    // BoundingBox expand(@NotNull BlockFace blockFace, double expansion)
                    TODO()
                }
                .function("expandDirectional", 3) {
                    it.target?.expandDirectional(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("expandDirectional", 1) { it.target?.expandDirectional(it.getArgument(0) as Vector) }
                .function("union", 3) {
                    it.target?.union(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("union", 1) {
                    // BoundingBox union(@NotNull Vector position)
                    // BoundingBox union(@NotNull Location position)
                    // BoundingBox union(@NotNull BoundingBox other)
                    TODO()
                }
                .function("intersection", 1) { it.target?.intersection(it.getArgument(0) as BoundingBox) }
                .function("shift", 3) {
                    it.target?.shift(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("shift", 1) {
                    // BoundingBox shift(@NotNull Vector shift)
                    // BoundingBox shift(@NotNull Location shift)
                    TODO()
                }
                .function("overlaps", 1) { it.target?.overlaps(it.getArgument(0) as BoundingBox) }
                .function("overlaps", 2) {
                    it.target?.overlaps(
                        it.getArgument(0) as Vector,
                        it.getArgument(1) as Vector
                    )
                }
                .function("contains", 3) {
                    it.target?.contains(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("contains", 1) {
                    // boolean contains(@NotNull Vector position)
                    // boolean contains(@NotNull BoundingBox other)
                    TODO()
                }
                .function("contains", 2) {
                    it.target?.contains(
                        it.getArgument(0) as Vector,
                        it.getArgument(1) as Vector
                    )
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
