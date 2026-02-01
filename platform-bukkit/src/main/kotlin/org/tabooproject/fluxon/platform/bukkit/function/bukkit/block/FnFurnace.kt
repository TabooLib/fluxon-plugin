package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Furnace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Furnace"])
@PlatformSide(Platform.BUKKIT)
object FnFurnace {

    val TYPE = Type.fromClass(Furnace::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Furnace::class.java)
                .function("burnTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.burnTime?.toInt() ?: 0) }
                .function("setBurnTime", returnsVoid().params(Type.I)) { it.target?.setBurnTime(it.getInt(0).toShort()) }
                .function("cookTime", returns(Type.I).noParams()) { it.setReturnInt(it.target?.cookTime?.toInt() ?: 0) }
                .function("setCookTime", returnsVoid().params(Type.I)) { it.target?.setCookTime(it.getInt(0).toShort()) }
                .function("cookTimeTotal", returns(Type.I).noParams()) { it.setReturnInt(it.target?.cookTimeTotal ?: 0) }
                .function("setCookTimeTotal", returnsVoid().params(Type.I)) { it.target?.setCookTimeTotal(it.getInt(0)) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
