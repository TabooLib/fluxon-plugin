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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Fireball"])
@PlatformSide(Platform.BUKKIT)
object FnFireball {

    val TYPE = Type.fromClass(Fireball::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fireball::class.java)
                .function("setDirection",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.target?.setDirection(it.getRef(0) as Vector) }
                .function("direction",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.direction) }
                .function("setAcceleration",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.target?.setAcceleration(it.getRef(0) as Vector) }
                .function("acceleration",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE).noParams()) { it.setReturnRef(it.target?.acceleration) }
        }
    }
}
