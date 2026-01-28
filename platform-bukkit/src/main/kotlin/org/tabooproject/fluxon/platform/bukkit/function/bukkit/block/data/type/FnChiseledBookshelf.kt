package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.ChiseledBookshelf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.ChiseledBookshelf"])
@PlatformSide(Platform.BUKKIT)
object FnChiseledBookshelf {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChiseledBookshelf::class.java)
                .function("isSlotOccupied", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.isSlotOccupied(it.getInt(0).toInt())) }
                .function("setSlotOccupied", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setSlotOccupied(
                        it.getInt(0).toInt(),
                        it.getBool(1)
                    ))
                }
                .function("occupiedSlots", returnsObject().noParams()) { it.setReturnRef(it.target?.occupiedSlots) }
                .function("maximumOccupiedSlots", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumOccupiedSlots) }
        }
    }
}
