package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.EntityEffect
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.EntityEffect"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEffect : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.EntityEffect>() {

    override val enumClass: Class<org.bukkit.EntityEffect> = org.bukkit.EntityEffect::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEffect::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnInt(it.target?.data?.toInt() ?: 0) }
                .function("isApplicableTo", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.setReturnBool(it.target?.isApplicableTo(it.getRef(0) as Entity) ?: false) }
                .function("isApplicableTo", returns(Type.Z).params(Type.CLASS)) { it.setReturnBool(it.target?.isApplicableTo(it.getRef(0) as Class<Entity>) ?: false) }
        }
    }
}
