package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameRule
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.GameRule"])
@PlatformSide(Platform.BUKKIT)
object FnGameRule {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameRule::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.getType()) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
