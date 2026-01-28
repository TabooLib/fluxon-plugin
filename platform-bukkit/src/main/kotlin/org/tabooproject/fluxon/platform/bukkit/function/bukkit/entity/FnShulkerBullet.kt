package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.ShulkerBullet
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.ShulkerBullet"])
@PlatformSide(Platform.BUKKIT)
object FnShulkerBullet {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ShulkerBullet::class.java)
                .function("target", returnsObject().noParams()) { it.target?.target }
                .function("setTarget", returnsObject().params(Type.OBJECT)) { it.target?.setTarget(it.getRef(0) as Entity) }
        }
    }
}
