package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Chest
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Chest"])
@PlatformSide(Platform.BUKKIT)
object FnChest {

    val TYPE = Type.fromClass(Chest::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Chest::class.java)
                .function("blockInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.blockInventory) }
        }
    }
}
