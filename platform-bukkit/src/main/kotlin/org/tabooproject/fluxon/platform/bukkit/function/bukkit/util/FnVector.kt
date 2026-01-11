package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnVector {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vector::class.java)
                .function("add", 1) { it.target?.add(it.getArgument(0) as Vector) }
                .function("subtract", 1) { it.target?.subtract(it.getArgument(0) as Vector) }
                .function("multiply", 1) {
                    // Vector multiply(@NotNull Vector vec)
                    // Vector multiply(int m)
                    // Vector multiply(double m)
                    // Vector multiply(float m)
                    TODO()
                }
                .function("divide", 1) { it.target?.divide(it.getArgument(0) as Vector) }
                .function("copy", 1) { it.target?.copy(it.getArgument(0) as Vector) }
                .function("length", 0) { it.target?.length() }
                .function("lengthSquared", 0) { it.target?.lengthSquared() }
                .function("distance", 1) { it.target?.distance(it.getArgument(0) as Vector) }
                .function("distanceSquared", 1) { it.target?.distanceSquared(it.getArgument(0) as Vector) }
                .function("angle", 1) { it.target?.angle(it.getArgument(0) as Vector) }
                .function("midpoint", 1) {
                    // Vector midpoint(@NotNull Vector other)
                    // Vector getMidpoint(@NotNull Vector other)
                    TODO()
                }
                .function("dot", 1) { it.target?.dot(it.getArgument(0) as Vector) }
                .function("crossProduct", 1) {
                    // Vector crossProduct(@NotNull Vector o)
                    // Vector getCrossProduct(@NotNull Vector o)
                    TODO()
                }
                .function("normalize", 0) { it.target?.normalize() }
                .function("zero", 0) { it.target?.zero() }
                .function("isZero", 0) { it.target?.isZero }
                .function("isInAABB", 2) {
                    it.target?.isInAABB(
                        it.getArgument(0) as Vector,
                        it.getArgument(1) as Vector
                    )
                }
                .function("isInSphere", 2) {
                    it.target?.isInSphere(
                        it.getArgument(0) as Vector,
                        it.getNumber(1).toDouble()
                    )
                }
                .function("isNormalized", 0) { it.target?.isNormalized }
                .function("rotateAroundX", 1) { it.target?.rotateAroundX(it.getNumber(0).toDouble()) }
                .function("rotateAroundY", 1) { it.target?.rotateAroundY(it.getNumber(0).toDouble()) }
                .function("rotateAroundZ", 1) { it.target?.rotateAroundZ(it.getNumber(0).toDouble()) }
                .function("rotateAroundAxis", 2) {
                    it.target?.rotateAroundAxis(
                        it.getArgument(0) as Vector,
                        it.getNumber(1).toDouble()
                    )
                }
                .function(
                    "rotateAroundNonUnitAxis",
                    2
                ) { it.target?.rotateAroundNonUnitAxis(it.getArgument(0) as Vector, it.getNumber(1).toDouble()) }
                .function("x", 0) { it.target?.getX() }
                .function("blockX", 0) { it.target?.blockX }
                .function("y", 0) { it.target?.getY() }
                .function("blockY", 0) { it.target?.blockY }
                .function("z", 0) { it.target?.getZ() }
                .function("blockZ", 0) { it.target?.blockZ }
                .function("setX", 1) {
                    // Vector setX(int x)
                    // Vector setX(double x)
                    // Vector setX(float x)
                    TODO()
                }
                .function("setY", 1) {
                    // Vector setY(int y)
                    // Vector setY(double y)
                    // Vector setY(float y)
                    TODO()
                }
                .function("setZ", 1) {
                    // Vector setZ(int z)
                    // Vector setZ(double z)
                    // Vector setZ(float z)
                    TODO()
                }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("clone", 0) { it.target?.clone() }
                .function("toString", 0) { it.target?.toString() }
                .function("toLocation", 1) { it.target?.toLocation(it.getArgument(0) as World) }
                .function("toLocation", 3) {
                    it.target?.toLocation(
                        it.getArgument(0) as World,
                        it.getNumber(1).toFloat(),
                        it.getNumber(2).toFloat()
                    )
                }
                .function("toBlockVector", 0) { it.target?.toBlockVector() }
                .function("toVector3f", 0) { it.target?.toVector3f() }
                .function("toVector3d", 0) { it.target?.toVector3d() }
                .function("toVector3i", 1) { it.target?.toVector3i(it.getNumber(0).toInt()) }
                .function("toVector3i", 0) { it.target?.toVector3i() }
                .function("checkFinite", 0) { it.target?.checkFinite() }
                // static
                .function("epsilon", 0) { Vector.getEpsilon() }
                // static
                .function("minimum", 2) { Vector.getMinimum(it.getArgument(0) as Vector, it.getArgument(1) as Vector) }
                // static
                .function("maximum", 2) { Vector.getMaximum(it.getArgument(0) as Vector, it.getArgument(1) as Vector) }
                // static
                .function("random", 0) { Vector.getRandom() }
                // static
                .function("fromJOML", 1) {
                    // static Vector fromJOML(@NotNull Vector3f vector)
                    // static Vector fromJOML(@NotNull Vector3d vector)
                    // static Vector fromJOML(@NotNull Vector3i vector)
                    // static Vector fromJOML(@NotNull Vector3fc vector)
                    // static Vector fromJOML(@NotNull Vector3dc vector)
                    // static Vector fromJOML(@NotNull Vector3ic vector)
                    TODO()
                }
                // static
                .function("deserialize", 1) { Vector.deserialize(it.getArgument(0) as Map<String, Any>) }
        }
    }
}
