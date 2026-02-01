package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractWindCharge
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.AbstractWindCharge"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractWindCharge {

    val TYPE = Type.fromClass(AbstractWindCharge::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractWindCharge::class.java)
                .function("explode", returnsObject().noParams()) { it.setReturnRef(it.target?.explode()) }
        }
    }
}
