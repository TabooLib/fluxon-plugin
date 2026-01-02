package org.tabooproject.fluxon.platform.bukkit.util

import org.bukkit.Location

/**
 * 位置坐标按对应轴相乘
 */
fun Location.multiply(other: Location): Location {
    this.x *= other.x
    this.y *= other.y
    this.z *= other.z
    return this
}

/**
 * 位置坐标按对应轴相除
 */
fun Location.divide(other: Location): Location {
    this.x /= other.x
    this.y /= other.y
    this.z /= other.z
    return this
}