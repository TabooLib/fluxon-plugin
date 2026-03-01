package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ComplexEntityPart
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.ComplexEntityPart"])
@PlatformSide(Platform.BUKKIT)
object FnComplexEntityPart {

    val TYPE = Type.fromClass(ComplexEntityPart::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ComplexEntityPart::class.java)
                .function("parent",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnComplexLivingEntity.TYPE).noParams()) { it.setReturnRef(it.target?.parent) }
        }
    }
}
