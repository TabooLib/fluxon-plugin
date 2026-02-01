package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.ChiseledBookshelf
import org.bukkit.util.Vector
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnChiseledBookshelfInventory
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.ChiseledBookshelf"])
@PlatformSide(Platform.BUKKIT)
object FnChiseledBookshelf {

    val TYPE = Type.fromClass(ChiseledBookshelf::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChiseledBookshelf::class.java)
                .function("lastInteractedSlot", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lastInteractedSlot ?: 0) }
                .function("setLastInteractedSlot", returnsVoid().params(Type.I)) { it.target?.setLastInteractedSlot(it.getInt(0)) }
                .function("inventory", returns(FnChiseledBookshelfInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returns(FnChiseledBookshelfInventory.TYPE).noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
                .function("getSlot", returns(Type.I).params(FnVector.TYPE)) { it.setReturnInt(it.target?.getSlot(it.getRef(0) as Vector) ?: 0) }
        }
    }
}
