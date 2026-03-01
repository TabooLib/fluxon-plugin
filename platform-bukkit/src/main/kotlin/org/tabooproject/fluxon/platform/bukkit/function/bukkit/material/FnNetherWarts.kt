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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.NetherWarts"])
@PlatformSide(Platform.BUKKIT)
object FnNetherWarts {

    val TYPE = Type.fromClass(NetherWarts::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(NetherWarts::class.java)
                .function("state", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNetherWartsState.TYPE).noParams()) { it.setReturnRef(it.target?.state) }
                .function("setState", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNetherWartsState.TYPE)) { it.target?.setState(it.getRef(0) as NetherWartsState)  }
                .function("setState", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNetherWartsState.enumValue(it.getString(0))?.let { p0 -> it.target?.setState(p0)  } }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
