package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractVillager
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.AbstractVillager"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractVillager {

    val TYPE = Type.fromClass(AbstractVillager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractVillager::class.java)
                .function("inventory",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE).noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
