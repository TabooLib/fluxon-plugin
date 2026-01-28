package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.NetherWartsState
import org.bukkit.material.NetherWarts
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.NetherWarts"])
@PlatformSide(Platform.BUKKIT)
object FnNetherWarts {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NetherWarts::class.java)
                .function("state", returnsObject().noParams()) { it.target?.state }
                .function("setState", returnsObject().params(Type.OBJECT)) { it.target?.setState(it.getRef(0) as NetherWartsState) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
