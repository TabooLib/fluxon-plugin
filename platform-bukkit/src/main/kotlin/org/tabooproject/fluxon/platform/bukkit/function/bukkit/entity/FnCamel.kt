package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Camel
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Camel"])
@PlatformSide(Platform.BUKKIT)
object FnCamel {

    val TYPE = Type.fromClass(Camel::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Camel::class.java)
                .function("isDashing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDashing ?: false) }
                .function("setDashing", returnsVoid().params(Type.Z)) { it.target?.setDashing(it.getBool(0)) }
        }
    }
}
