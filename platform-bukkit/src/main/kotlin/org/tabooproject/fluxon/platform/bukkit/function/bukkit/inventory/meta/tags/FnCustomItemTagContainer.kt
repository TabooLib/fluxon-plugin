package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.tags.CustomItemTagContainer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.tags.CustomItemTagContainer"])
@PlatformSide(Platform.BUKKIT)
object FnCustomItemTagContainer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CustomItemTagContainer::class.java)
                .function("removeCustomTag", returnsObject().params(Type.OBJECT)) { it.target?.removeCustomTag(it.getRef(0) as NamespacedKey) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.target?.isEmpty }
                .function("adapterContext", returnsObject().noParams()) { it.target?.adapterContext }
        }
    }
}
