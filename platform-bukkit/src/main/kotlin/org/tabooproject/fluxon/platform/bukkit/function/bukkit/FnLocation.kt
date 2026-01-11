package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnLocation {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Location::class.java)
                .function("setWorld", 1) { it.target?.setWorld(it.getArgument(0) as World) }
                .function("isWorldLoaded", 0) { it.target?.isWorldLoaded }
                .function("world", 0) { it.target?.world }
                .function("chunk", 0) { it.target?.chunk }
                .function("block", 0) { it.target?.block }
                .function("setX", 1) { it.target?.setX(it.getNumber(0).toDouble()) }
                .function("x", 0) { it.target?.x }
                .function("blockX", 0) { it.target?.blockX }
                .function("setY", 1) { it.target?.setY(it.getNumber(0).toDouble()) }
                .function("y", 0) { it.target?.y }
                .function("blockY", 0) { it.target?.blockY }
                .function("setZ", 1) { it.target?.setZ(it.getNumber(0).toDouble()) }
                .function("z", 0) { it.target?.z }
                .function("blockZ", 0) { it.target?.blockZ }
                .function("setYaw", 1) { it.target?.setYaw(it.getNumber(0).toFloat()) }
                .function("yaw", 0) { it.target?.yaw }
                .function("setPitch", 1) { it.target?.setPitch(it.getNumber(0).toFloat()) }
                .function("pitch", 0) { it.target?.pitch }
                .function("direction", 0) { it.target?.direction }
                .function("setDirection", 1) { it.target?.setDirection(it.getArgument(0) as Vector) }
                .function("add", 1) {
                    // Location add(@NotNull Location vec)
                    // Location add(@NotNull Vector vec)
                    TODO()
                }
                .function("add", 3) {
                    it.target?.add(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("subtract", 1) {
                    // Location subtract(@NotNull Location vec)
                    // Location subtract(@NotNull Vector vec)
                    TODO()
                }
                .function("subtract", 3) {
                    it.target?.subtract(
                        it.getNumber(0).toDouble(),
                        it.getNumber(1).toDouble(),
                        it.getNumber(2).toDouble()
                    )
                }
                .function("length", 0) { it.target?.length() }
                .function("lengthSquared", 0) { it.target?.lengthSquared() }
                .function("distance", 1) { it.target?.distance(it.getArgument(0) as Location) }
                .function("distanceSquared", 1) { it.target?.distanceSquared(it.getArgument(0) as Location) }
                .function("multiply", 1) { it.target?.multiply(it.getNumber(0).toDouble()) }
                .function("zero", 0) { it.target?.zero() }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("toString", 0) { it.target?.toString() }
                .function("toVector", 0) { it.target?.toVector() }
                .function("clone", 0) { it.target?.clone() }
                .function("checkFinite", 0) { it.target?.checkFinite() }
                // static
                .function("locToBlock", 1) { Location.locToBlock(it.getNumber(0).toDouble()) }
                // static
                .function("deserialize", 1) { Location.deserialize(it.getArgument(0) as Map<String, Any>) }
                // static
                .function("normalizeYaw", 1) { Location.normalizeYaw(it.getNumber(0).toFloat()) }
                // static
                .function("normalizePitch", 1) { Location.normalizePitch(it.getNumber(0).toFloat()) }
        }
    }
}
