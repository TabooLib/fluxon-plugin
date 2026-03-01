package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Particle.DustOptions
import org.bukkit.Vibration
import org.bukkit.World
import org.bukkit.block.data.BlockData
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.nms.PacketWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.java.Export
import taboolib.library.xseries.particles.XParticle
import taboolib.module.nms.sendPacket
import java.util.concurrent.ConcurrentHashMap
import kotlin.jvm.optionals.getOrNull

@Requires(classes = ["org.bukkit.Particle"])
@PlatformSide(Platform.BUKKIT)
object FnParticle : FnEnumGetter<Particle>() {

    override val enumClass: Class<Particle> = Particle::class.java

    override fun enumValue(value: String): Particle? {
        return XParticle.of(value).getOrNull()?.get()
    }

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
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle::class.java)
                .function("key", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE).noParams()) { it.setReturnRef(it.target?.key) }
            exportRegistry.registerClass(ParticlePacketBuilder::class.java)

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

@Requires(classes = ["org.bukkit.Particle\$DustOptions"])
@PlatformSide(Platform.BUKKIT)
object FnParticleDustOptions {

    val TYPE = Type.fromClass(Particle.DustOptions::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle.DustOptions::class.java)
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("size", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.size ?: 0.0f) }
        }
    }
}

@Requires(classes = ["org.bukkit.Particle\$DustTransition"])
@PlatformSide(Platform.BUKKIT)
object FnParticleDustTransition {

    val TYPE = Type.fromClass(Particle.DustTransition::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Particle.DustTransition::class.java)
                .function("toColor", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnColor.TYPE).noParams()) { it.setReturnRef(it.target?.toColor) }
        }
    }
}
