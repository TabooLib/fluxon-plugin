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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockVector::class.java)
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                // static
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(BlockVector.deserialize(it.getRef(0) as Map<String, Any>)) }
        }
    }
}
