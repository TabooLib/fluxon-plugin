package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Creeper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Creeper"])
@PlatformSide(Platform.BUKKIT)
object FnCreeper {

    val TYPE = Type.fromClass(Creeper::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Creeper::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("setPowered", returnsVoid().params(Type.Z)) { it.target?.setPowered(it.getBool(0)) }
                .function("setMaxFuseTicks", returnsVoid().params(Type.I)) { it.target?.setMaxFuseTicks(it.getInt(0).toInt()) }
                .function("maxFuseTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxFuseTicks ?: 0) }
                .function("setFuseTicks", returnsVoid().params(Type.I)) { it.target?.setFuseTicks(it.getInt(0).toInt()) }
                .function("fuseTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fuseTicks ?: 0) }
                .function("setExplosionRadius", returnsVoid().params(Type.I)) { it.target?.setExplosionRadius(it.getInt(0).toInt()) }
                .function("explosionRadius", returns(Type.I).noParams()) { it.setReturnInt(it.target?.explosionRadius ?: 0) }
                .function("explode", returnsVoid().noParams()) { it.target?.explode() }
                .function("ignite", returnsVoid().noParams()) { it.target?.ignite() }
        }
    }
}
