package org.tabooproject.fluxon.platform.bukkit.function

import org.bukkit.*
import org.bukkit.Particle.DustOptions
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.nms.PacketWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.java.Export
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.library.xseries.particles.XParticle
import taboolib.module.nms.sendPacket
import java.util.concurrent.ConcurrentHashMap
import kotlin.jvm.optionals.getOrNull

@PlatformSide(Platform.BUKKIT)
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

    @Awake(LifeCycle.INIT)
    fun init() {
        with(FluxonRuntime.getInstance()) {
            exportRegistry.registerClass(ParticlePacketBuilder::class.java)
            // Particle
            registerFunction("particle", returnsObject().params(Type.STRING)) {
                val name = it.getString(0)!!
                it.setReturnRef(XParticle.of(name).getOrNull()?.get() ?: error("粒子不存在: $name"))}
            registerFunction("particleOrNull", returnsObject().params(Type.STRING)) {
                val name = it.getString(0)!!
                it.setReturnRef(XParticle.of(name).getOrNull()?.get())}
            // BuildParticle
            registerFunction("buildParticle", returnsObject().params(Type.STRING, Type.OBJECT)) {
                val name = it.getString(0)!!
                val particle = particleCacheMap.computeIfAbsent(name) {
                    XParticle.of(name).getOrNull()?.get() ?: error("粒子不存在: $name")
                }
                val location = it.getRef(1) as Location
                it.setReturnRef(ParticlePacketBuilder(particle, location))}
            // ParticleData
            registerFunction("dustOptions", returnsObject().params(Type.OBJECT)) {
                val color = it.getRef(0) as Color
                it.setReturnRef(DustOptions(color, 1.0f))}
            registerFunction("dustOptions", returnsObject().params(Type.OBJECT, Type.F)) {
                val color = it.getRef(0) as Color
                val size = it.getFloat(1)
                it.setReturnRef(DustOptions(color, size))}
            registerFunction("dustTransition", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                val fromColor = it.getRef(0) as Color
                val toColor = it.getRef(1) as Color
                it.setReturnRef(Particle.DustTransition(fromColor, toColor, 1.0f))}
            registerFunction("dustTransition", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.F)) {
                val fromColor = it.getRef(0) as Color
                val toColor = it.getRef(1) as Color
                val size = it.getFloat(2)
                it.setReturnRef(Particle.DustTransition(fromColor, toColor, size))}
        }
    }
}