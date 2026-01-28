package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Lectern
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Lectern"])
@PlatformSide(Platform.BUKKIT)
object FnLectern {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lectern::class.java)
                .function("page", returnsObject().noParams()) { it.setReturnRef(it.target?.page) }
                .function("setPage", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPage(it.getInt(0).toInt())) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
                .function("snapshotInventory", returnsObject().noParams()) { it.setReturnRef(it.target?.snapshotInventory) }
        }
    }
}
