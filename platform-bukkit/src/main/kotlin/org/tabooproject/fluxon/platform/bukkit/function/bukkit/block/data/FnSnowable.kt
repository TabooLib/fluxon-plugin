package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Snowable
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

@Requires(classes = ["org.bukkit.block.data.Snowable"])
@PlatformSide(Platform.BUKKIT)
object FnSnowable {

    val TYPE = Type.fromClass(Snowable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Snowable::class.java)
                .function("isSnowy", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSnowy ?: false) }
                .function("setSnowy", returnsVoid().params(Type.Z)) { it.target?.setSnowy(it.getBool(0)) }
        }
    }
}
