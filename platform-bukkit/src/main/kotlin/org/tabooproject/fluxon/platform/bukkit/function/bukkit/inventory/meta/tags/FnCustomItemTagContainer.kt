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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.tags.CustomItemTagContainer"])
@PlatformSide(Platform.BUKKIT)
object FnCustomItemTagContainer {

    val TYPE = Type.fromClass(CustomItemTagContainer::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CustomItemTagContainer::class.java)
                .function("removeCustomTag", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnNamespacedKey.TYPE)) { it.target?.removeCustomTag(it.getRef(0) as NamespacedKey) }
                .function("isEmpty", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEmpty ?: false) }
                .function("adapterContext",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags.FnItemTagAdapterContext.TYPE).noParams()) { it.setReturnRef(it.target?.adapterContext) }
        }
    }
}
