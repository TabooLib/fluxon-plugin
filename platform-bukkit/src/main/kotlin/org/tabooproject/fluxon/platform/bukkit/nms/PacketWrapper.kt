package org.tabooproject.fluxon.platform.bukkit.nms

import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.util.Vector
import taboolib.module.nms.nmsProxy

abstract class PacketWrapper {

    abstract fun wrap(
        particle: Particle,
        location: Location,
        offset: Vector = Vector(),
        speed: Double = 0.0,
        count: Int = 1,
        data: Any? = null,
    ): Any

    companion object {

        val instance by lazy { nmsProxy<PacketWrapper>() }
    }
}