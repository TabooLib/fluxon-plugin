package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Powerable
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

@Requires(classes = ["org.bukkit.block.data.Powerable"])
@PlatformSide(Platform.BUKKIT)
object FnPowerable {

    val TYPE = Type.fromClass(Powerable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Powerable::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("setPowered", returnsVoid().params(Type.Z)) { it.target?.setPowered(it.getBool(0)) }
        }
    }
}
