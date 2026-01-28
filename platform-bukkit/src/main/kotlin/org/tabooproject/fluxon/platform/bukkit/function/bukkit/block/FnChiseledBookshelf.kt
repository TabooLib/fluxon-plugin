package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.ChiseledBookshelf
import org.bukkit.util.Vector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.ChiseledBookshelf"])
@PlatformSide(Platform.BUKKIT)
object FnChiseledBookshelf {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChiseledBookshelf::class.java)
                .function("lastInteractedSlot", returnsObject().noParams()) { it.setReturnRef(it.target?.lastInteractedSlot) }
                .function("setLastInteractedSlot", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLastInteractedSlot(it.getInt(0).toInt())) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
                .function("getSlot", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getSlot(it.getRef(0) as Vector)) }
        }
    }
}
