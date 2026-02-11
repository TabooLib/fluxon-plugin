package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.InventoryType
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.InventoryType"])
@PlatformSide(Platform.BUKKIT)
object FnInventoryType : FnEnumGetter<InventoryType>() {

    override val enumClass: Class<InventoryType> = InventoryType::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(InventoryType::class.java)
                .function("defaultSize", returns(Type.I).noParams()) { it.setReturnRef(it.target?.defaultSize) }
                .function("defaultTitle", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.defaultTitle) }
                .function("isCreatable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCreatable ?: false) }
        }
    }
}
