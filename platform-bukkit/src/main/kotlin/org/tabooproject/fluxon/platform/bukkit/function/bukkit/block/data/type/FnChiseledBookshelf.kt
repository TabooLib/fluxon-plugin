package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.ChiseledBookshelf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.block.data.type.ChiseledBookshelf"])
@PlatformSide(Platform.BUKKIT)
object FnChiseledBookshelf {

    val TYPE = Type.fromClass(ChiseledBookshelf::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChiseledBookshelf::class.java)
                .function("isSlotOccupied", returns(Type.Z).params(Type.I)) { it.setReturnBool(it.target?.isSlotOccupied(it.getInt(0)) ?: false) }
                .function("setSlotOccupied", returnsVoid().params(Type.I, Type.Z)) {
                    it.target?.setSlotOccupied(
                        it.getInt(0),
                        it.getBool(1)
                    )
                }
                .function("occupiedSlots", returns(StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.occupiedSlots) }
                .function("maximumOccupiedSlots", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumOccupiedSlots ?: 0) }
        }
    }
}
