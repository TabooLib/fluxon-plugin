package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.InventoryType"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryType::class.java)
                .function("defaultSize", returnsObject().noParams()) { it.target?.defaultSize }
                .function("defaultTitle", returnsObject().noParams()) { it.target?.defaultTitle }
                .function("isCreatable", returns(Type.Z).noParams()) { it.target?.isCreatable }
        }
    }
}
