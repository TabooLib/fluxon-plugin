package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.*
import org.bukkit.Particle.DustOptions
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.nms.PacketWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.java.Export
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.library.xseries.particles.XParticle
import taboolib.module.nms.sendPacket
import java.util.concurrent.ConcurrentHashMap
import kotlin.jvm.optionals.getOrNull

object FunctionParticle {

    class ParticlePacketBuilder(val particle: Particle, val location: Location) {

        private var offset = Vector()
        private var speed = 0.0
        private var count = 1
        private var data: Any? = null

        @Export
        fun offset(offset: Vector): ParticlePacketBuilder {
            this.offset = offset
            return this
        }

        @Export
        fun speed(speed: Double): ParticlePacketBuilder {
            this.speed = speed
            return this
        }

        @Export
        fun count(count: Int): ParticlePacketBuilder {
            this.count = count
            return this
        }

        @Export
        fun data(data: Any): ParticlePacketBuilder {
            this.data = data
            return this
        }

        @Export
        fun build(): Any {
            // 避免 data 为空
            if (data == null) {
                when (particle.dataType) {
                    DustOptions::class.java -> data = DustOptions(Color.RED, 1.0f)
                    Particle.DustTransition::class.java -> data = Particle.DustTransition(Color.RED, Color.WHITE, 1.0f)
                    ItemStack::class.java -> data = ItemStack(Material.STONE)
                    BlockData::class.java -> data = Material.STONE.createBlockData()
                    Float::class.java -> data = 1f
                    Integer::class.java -> data = 1
                    Vibration::class.java -> error("Vibration 缺少参数")
                }
            }
            return PacketWrapper.instance.wrap(particle, location, offset, speed, count, data)
        }

        @Export
        fun sendTo(player: Player) {
            player.sendPacket(build())
        }

        @Export
        fun sendTo(world: World) {
            val packet = build()
            world.players.forEach { it.sendPacket(packet) }
        }

        override fun toString(): String {
            return "ParticlePacketBuilder(particle=$particle, location=$location, offset=$offset, speed=$speed, count=$count, data=$data)"
        }
    }

    val particleCacheMap = ConcurrentHashMap<String, Particle>()

    @Awake(LifeCycle.CONST)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            exportRegistry.registerClass(ParticlePacketBuilder::class.java)
            // Particle
            registerFunction("particle", listOf(1, 2)) {
                val name = it.getArgument(0).toString()
                val particle = particleCacheMap.computeIfAbsent(name) {
                    XParticle.of(name).getOrNull()?.get() ?: error("粒子不存在: $name")
                }
                val location = it.getArgumentByType(1, Location::class.java)!!
                ParticlePacketBuilder(particle, location)
            }
            // ParticleData
            registerFunction("dustOptions", listOf(1, 2)) {
                val color = it.getArgumentByType(0, Color::class.java)!!
                val size = it.getArgument(1) as? Number ?: 1.0f
                DustOptions(color, size.toFloat())
            }
            registerFunction("dustTransition", listOf(2, 3)) {
                val fromColor = it.getArgumentByType(0, Color::class.java)!!
                val toColor = it.getArgumentByType(1, Color::class.java)!!
                val size = it.getArgument(2) as? Number ?: 1.0f
                Particle.DustTransition(fromColor, toColor, size.toFloat())
            }
        }
    }
}