package org.tabooproject.fluxon.platform.bukkit.function.bukkit.util

import org.bukkit.util.BlockIterator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.util.BlockIterator"])
@PlatformSide(Platform.BUKKIT)
object FnBlockIterator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockIterator::class.java)
                .function("hasNext", returns(Type.Z).noParams()) { it.target?.hasNext() }
                .function("next", returnsObject().noParams()) { it.target?.next() }
                .function("remove", returnsObject().noParams()) { it.target?.remove() }
        }
    }
}
