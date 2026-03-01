package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Entity
import org.bukkit.entity.TNTPrimed
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

@Requires(classes = ["org.bukkit.entity.TNTPrimed"])
@PlatformSide(Platform.BUKKIT)
object FnTNTPrimed {

    val TYPE = Type.fromClass(TNTPrimed::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNTPrimed::class.java)
                .function("setFuseTicks", returnsVoid().params(Type.I)) { it.target?.setFuseTicks(it.getInt(0).toInt()) }
                .function("fuseTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.fuseTicks ?: 0) }
                .function("source",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.source) }
                .function("setSource",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.target?.setSource(it.getRef(0) as Entity) }
        }
    }
}
