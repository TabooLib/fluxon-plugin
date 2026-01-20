package org.tabooproject.fluxon.platform.bukkit.function.bukkit.damage

import org.bukkit.Location
import org.bukkit.damage.DamageSource
import org.bukkit.damage.DamageType
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnDamageSource {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageSource::class.java)
                .function("damageType", 0) { it.target?.damageType }
                .function("causingEntity", 0) { it.target?.causingEntity }
                .function("directEntity", 0) { it.target?.directEntity }
                .function("damageLocation", 0) { it.target?.damageLocation }
                .function("sourceLocation", 0) { it.target?.sourceLocation }
                .function("isIndirect", 0) { it.target?.isIndirect }
                .function("foodExhaustion", 0) { it.target?.foodExhaustion }
                .function("scalesWithDifficulty", 0) { it.target?.scalesWithDifficulty() }
                .function("builder", 1) { DamageSource.builder(it.getArgument(0) as DamageType) }

            registerExtension(DamageSource.Builder::class.java)
                .function("withCausingEntity", 1) { it.target?.withCausingEntity(it.getArgument(0) as Entity) }
                .function("withDirectEntity", 1) { it.target?.withDirectEntity(it.getArgument(0) as Entity) }
                .function("withDamageLocation", 1) { it.target?.withDamageLocation(it.getArgument(0) as Location) }
                .function("build", 0) { it.target?.build() }
        }
    }
}
