package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags

import org.bukkit.inventory.meta.tags.ItemTagAdapterContext
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.tags.ItemTagAdapterContext"])
@PlatformSide(Platform.BUKKIT)
object FnItemTagAdapterContext {

    val TYPE = Type.fromClass(ItemTagAdapterContext::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemTagAdapterContext::class.java)
                .function("newTagContainer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags.FnCustomItemTagContainer.TYPE).noParams()) { it.setReturnRef(it.target?.newTagContainer()) }
        }
    }
}
