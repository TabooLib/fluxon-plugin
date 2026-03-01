package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BlockVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.BlockVector"])
@PlatformSide(Platform.BUKKIT)
object FnBlockVector {

    val TYPE = Type.fromClass(BlockVector::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockVector::class.java)
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
                // static
                .function("deserialize", returns(TYPE).params(Type.MAP)) { it.setReturnRef(BlockVector.deserialize(it.getRef(0) as Map<String, Any>)) }
        }
    }
}
