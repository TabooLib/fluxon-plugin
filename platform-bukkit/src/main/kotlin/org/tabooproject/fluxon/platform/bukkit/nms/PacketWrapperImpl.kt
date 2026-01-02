package org.tabooproject.fluxon.platform.bukkit.nms

import net.minecraft.network.protocol.game.PacketPlayOutWorldParticles
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.craftbukkit.v1_20_R4.CraftParticle
import org.bukkit.util.Vector

class PacketWrapperImpl : PacketWrapper() {

    override fun wrap(
        particle: Particle,
        location: Location,
        offset: Vector,
        speed: Double,
        count: Int,
        data: Any?,
    ): Any {
        return PacketPlayOutWorldParticles(
            CraftParticle.createParticleParam(particle, data),
            true,
            location.x,
            location.y,
            location.z,
            offset.x.toFloat(),
            offset.y.toFloat(),
            offset.z.toFloat(),
            speed.toFloat(),
            count
        )
    }
}