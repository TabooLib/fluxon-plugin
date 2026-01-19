package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.tags.CustomItemTagContainer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnCustomItemTagContainer {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CustomItemTagContainer::class.java)
                .function("removeCustomTag", 1) { it.target?.removeCustomTag(it.getArgument(0) as NamespacedKey) }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("adapterContext", 0) { it.target?.adapterContext }
        }
    }
}
