package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Art
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.Art"])
@PlatformSide(Platform.BUKKIT)
object FnArt {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Art::class.java)
                .function("blockWidth", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockWidth) }
                .function("blockHeight", returns(Type.I).noParams()) { it.setReturnRef(it.target?.blockHeight) }
                .function("id", returns(Type.I).noParams()) { it.setReturnRef(it.target?.id) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                // static
                .function("getById", returnsObject().params(Type.I)) { it.setReturnRef(Art.getById(it.getInt(0))) }
                // static
                .function("getByName", returnsObject().params(Type.STRING)) { it.setReturnRef(Art.getByName(it.getString(0)!!)) }
        }
    }
}
