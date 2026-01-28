package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Bamboo
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Bamboo"])
@PlatformSide(Platform.BUKKIT)
object FnBamboo {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bamboo::class.java)
                .function("leaves", returnsObject().noParams()) { it.setReturnRef(it.target?.leaves) }
                .function("setLeaves", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLeaves(it.getRef(0) as Bamboo.Leaves)) }
        }
    }
}
