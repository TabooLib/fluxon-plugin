package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Lightable
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

@Requires(classes = ["org.bukkit.block.data.Lightable"])
@PlatformSide(Platform.BUKKIT)
object FnLightable {

    val TYPE = Type.fromClass(Lightable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lightable::class.java)
                .function("isLit", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLit ?: false) }
                .function("setLit", returnsVoid().params(Type.Z)) { it.target?.setLit(it.getBool(0)) }
        }
    }
}
