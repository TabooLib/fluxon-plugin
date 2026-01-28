package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Creeper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Creeper"])
@PlatformSide(Platform.BUKKIT)
object FnCreeper {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Creeper::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPowered) }
                .function("setPowered", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPowered(it.getBool(0))) }
                .function("setMaxFuseTicks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxFuseTicks(it.getInt(0).toInt())) }
                .function("maxFuseTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.maxFuseTicks) }
                .function("setFuseTicks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFuseTicks(it.getInt(0).toInt())) }
                .function("fuseTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.fuseTicks) }
                .function("setExplosionRadius", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setExplosionRadius(it.getInt(0).toInt())) }
                .function("explosionRadius", returnsObject().noParams()) { it.setReturnRef(it.target?.explosionRadius) }
                .function("explode", returnsObject().noParams()) { it.setReturnRef(it.target?.explode()) }
                .function("ignite", returnsObject().noParams()) { it.setReturnRef(it.target?.ignite()) }
        }
    }
}
