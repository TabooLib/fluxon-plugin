package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Furnace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Furnace"])
@PlatformSide(Platform.BUKKIT)
object FnFurnace {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Furnace::class.java)
                .function("burnTime", returnsObject().noParams()) { it.setReturnRef(it.target?.burnTime) }
                .function("setBurnTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBurnTime(it.getInt(0).toShort())) }
                .function("cookTime", returnsObject().noParams()) { it.setReturnRef(it.target?.cookTime) }
                .function("setCookTime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCookTime(it.getInt(0).toShort())) }
                .function("cookTimeTotal", returnsObject().noParams()) { it.setReturnRef(it.target?.cookTimeTotal) }
                .function("setCookTimeTotal", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCookTimeTotal(it.getInt(0).toInt())) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
