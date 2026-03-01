package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.util.CachedServerIcon"])
@PlatformSide(Platform.BUKKIT)
object FnCachedServerIcon {

    val TYPE = Type.fromClass(org.bukkit.util.CachedServerIcon::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.util.CachedServerIcon::class.java)
                // .function("getData", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.getData()) }
                // .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty() ?: false) }
        }
    }
}
