package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.ExplosiveMinecart
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

@Requires(classes = ["org.bukkit.entity.minecart.ExplosiveMinecart"])
@PlatformSide(Platform.BUKKIT)
object FnExplosiveMinecart {

    val TYPE = Type.fromClass(ExplosiveMinecart::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExplosiveMinecart::class.java)
                .function("setFuseTicks", returnsVoid().params(Type.I)) { it.target?.setFuseTicks(it.getInt(0).toInt()) }
                .function("fuseTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fuseTicks ?: 0) }
                .function("ignite", returnsVoid().noParams()) { it.target?.ignite() }
                .function("isIgnited", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isIgnited ?: false) }
                .function("explode", returnsVoid().noParams()) { it.target?.explode() }
                .function("explode", returnsVoid().params(Type.D)) { it.target?.explode(it.getDouble(0)) }
        }
    }
}
