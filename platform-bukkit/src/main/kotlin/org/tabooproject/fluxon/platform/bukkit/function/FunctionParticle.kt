package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.*
import org.bukkit.Particle.DustOptions
import org.bukkit.block.data.BlockData
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.nms.PacketWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.library.xseries.particles.XParticle
import java.util.concurrent.ConcurrentHashMap
import kotlin.jvm.optionals.getOrNull

object FunctionParticle {

    class ParticlePacketBuilder(val particle: Particle, val location: Location) {

        var offset = Vector()

        var speed = 0.0

        var count = 1

        var data: Any? = null

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

        override fun toString(): String {
            return "ParticlePacketBuilder(particle=$particle, location=$location, offset=$offset, speed=$speed, count=$count, data=$data)"
        }
    }

    val particleCacheMap = ConcurrentHashMap<String, Particle>()

    @Awake(LifeCycle.CONST)
    fun init() {
        with(FluxonRuntime.getInstance()) {
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
            // ParticlePacketBuilder
            registerExtensionFunction(ParticlePacketBuilder::class.java, "offset", 1) {
                it.target?.offset = it.getArgumentByType(0, Vector::class.java)!!
                it.target
            }
            registerExtensionFunction(ParticlePacketBuilder::class.java, "speed", 1) {
                it.target?.speed = it.getNumber(0).toDouble()
                it.target
            }
            registerExtensionFunction(ParticlePacketBuilder::class.java, "count", 1) {
                it.target?.count = it.getNumber(0).toInt()
                it.target
            }
            registerExtensionFunction(ParticlePacketBuilder::class.java, "data", 1) {
                it.target?.data = it.getArgument(0)
                it.target
            }
            registerExtensionFunction(ParticlePacketBuilder::class.java, "build", 0) {
                it.target?.build()
            }
        }
    }
}