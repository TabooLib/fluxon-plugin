package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.minecart

import org.bukkit.entity.minecart.ExplosiveMinecart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.minecart.ExplosiveMinecart"])
@PlatformSide(Platform.BUKKIT)
object FnExplosiveMinecart {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ExplosiveMinecart::class.java)
                .function("setFuseTicks", returnsObject().params(Type.OBJECT)) { it.target?.setFuseTicks(it.getInt(0).toInt()) }
                .function("fuseTicks", returnsObject().noParams()) { it.target?.fuseTicks }
                .function("ignite", returnsObject().noParams()) { it.target?.ignite() }
                .function("isIgnited", returns(Type.Z).noParams()) { it.target?.isIgnited }
                .function("explode", returnsObject().noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.explode()
                    } else {
                        it.target?.explode(it.getAsDouble(0))
                    }
                }
                .function("explode", returnsObject().params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.explode()
                    } else {
                        it.target?.explode(it.getAsDouble(0))
                    }
                }
        }
    }
}
