package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.tags

import org.bukkit.inventory.meta.tags.ItemTagAdapterContext
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.inventory.meta.tags.ItemTagAdapterContext"])
@PlatformSide(Platform.BUKKIT)
object FnItemTagAdapterContext {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ItemTagAdapterContext::class.java)
                .function("newTagContainer", 0) { it.target?.newTagContainer() }
        }
    }
}
