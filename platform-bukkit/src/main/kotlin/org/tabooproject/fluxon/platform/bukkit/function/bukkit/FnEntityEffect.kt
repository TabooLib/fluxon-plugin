package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.EntityEffect
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

@Requires(classes = ["org.bukkit.EntityEffect"])
@PlatformSide(Platform.BUKKIT)
object FnEntityEffect {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityEffect::class.java)
                .function("data", returnsObject().noParams()) { it.setReturnRef(it.target?.data) }
                .function("isApplicableTo", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Entity -> it.target?.isApplicableTo(var1)
                        is Class<*> -> it.target?.isApplicableTo(var1 as Class<Entity>)
                        else -> throw IllegalArgumentException("参数必须是 Entity 或 Class<Entity> 类型")
                    })
                }
        }
    }
}
