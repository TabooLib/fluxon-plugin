package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Comparator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Comparator"])
@PlatformSide(Platform.BUKKIT)
object FnComparator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Comparator::class.java)
                .function("mode", returnsObject().noParams()) { it.target?.mode }
                .function("setMode", returnsObject().params(Type.OBJECT)) { it.target?.setMode(it.getRef(0) as Comparator.Mode) }
        }
    }
}
