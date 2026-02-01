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

    val TYPE = Type.fromClass(Art::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Art::class.java)
                .function("blockWidth", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockWidth ?: 0) }
                .function("blockHeight", returns(Type.I).noParams()) { it.setReturnInt(it.target?.blockHeight ?: 0) }
                .function("id", returns(Type.I).noParams()) { it.setReturnInt(it.target?.id ?: 0) }
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                // static
                .function("getById", returnsObject().params(Type.I)) { it.setReturnRef(Art.getById(it.getInt(0))) }
                // static
                .function("getByName", returnsObject().params(Type.STRING)) { it.setReturnRef(Art.getByName(it.getString(0)!!)) }
        }
    }
}
