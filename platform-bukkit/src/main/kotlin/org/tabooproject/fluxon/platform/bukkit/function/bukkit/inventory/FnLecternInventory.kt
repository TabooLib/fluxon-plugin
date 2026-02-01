package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory

import org.bukkit.inventory.LecternInventory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.inventory.LecternInventory"])
@PlatformSide(Platform.BUKKIT)
object FnLecternInventory {

    val TYPE = Type.fromClass(LecternInventory::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LecternInventory::class.java)
                .function("holder", returnsObject().noParams()) { it.setReturnRef(it.target?.holder) }
        }
    }
}
