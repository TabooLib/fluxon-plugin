package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.DoubleChest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.DoubleChest"])
@PlatformSide(Platform.BUKKIT)
object FnDoubleChest {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(DoubleChest::class.java)
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("leftSide", returnsObject().noParams()) { it.setReturnRef(it.target?.leftSide) }
                .function("rightSide", returnsObject().noParams()) { it.setReturnRef(it.target?.rightSide) }
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("world", returnsObject().noParams()) { it.setReturnRef(it.target?.world) }
                .function("x", returnsObject().noParams()) { it.setReturnRef(it.target?.x) }
                .function("y", returnsObject().noParams()) { it.setReturnRef(it.target?.y) }
                .function("z", returnsObject().noParams()) { it.setReturnRef(it.target?.z) }
        }
    }
}
