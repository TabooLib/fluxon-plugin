package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Fireball
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Fireball"])
@PlatformSide(Platform.BUKKIT)
object FnFireball {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fireball::class.java)
                .function("setDirection", returnsObject().params(Type.OBJECT)) { it.target?.setDirection(it.getRef(0) as Vector) }
                .function("direction", returnsObject().noParams()) { it.target?.direction }
                .function("setAcceleration", returnsObject().params(Type.OBJECT)) { it.target?.setAcceleration(it.getRef(0) as Vector) }
                .function("acceleration", returnsObject().noParams()) { it.target?.acceleration }
        }
    }
}
