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
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.damage.DamageSource"])
@PlatformSide(Platform.BUKKIT)
object FnDamageSource {

    val TYPE = Type.fromClass(DamageSource::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageSource::class.java)
                .function("damageType", returnsObject().noParams()) { it.setReturnRef(it.target?.damageType) }
                .function("causingEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.causingEntity) }
                .function("directEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.directEntity) }
                .function("damageLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.damageLocation) }
                .function("sourceLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.sourceLocation) }
                .function("isIndirect", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isIndirect ?: false) }
                .function("foodExhaustion", returnsObject().noParams()) { it.setReturnRef(it.target?.foodExhaustion) }
                .function("scalesWithDifficulty", returnsObject().noParams()) { it.setReturnRef(it.target?.scalesWithDifficulty()) }
                .function("builder", returnsObject().params(Type.OBJECT)) { it.setReturnRef(DamageSource.builder(it.getRef(0) as DamageType)) }
        }
    }
}

@Requires(classes = ["org.bukkit.damage.DamageSource.Builder"])
@PlatformSide(Platform.BUKKIT)
object FnDamageSourceBuilder {

    val TYPE = Type.fromClass(DamageSource.Builder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DamageSource.Builder::class.java)
                .function("withCausingEntity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.withCausingEntity(it.getRef(0) as Entity)) }
                .function("withDirectEntity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.withDirectEntity(it.getRef(0) as Entity)) }
                .function("withDamageLocation", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.withDamageLocation(it.getRef(0) as Location)) }
                .function("build", returnsObject().noParams()) { it.setReturnRef(it.target?.build()) }
        }
    }
}
