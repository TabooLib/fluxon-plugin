package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.NamespacedKey
import org.bukkit.persistence.PersistentDataContainer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnPersistentDataContainer {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataContainer::class.java)
                .function("has", 1) { it.target?.has(it.getArgument(0) as NamespacedKey) }
                .function("keys", 0) { it.target?.keys }
                .function("remove", 1) { it.target?.remove(it.getArgument(0) as NamespacedKey) }
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("copyTo", 2) {
                    it.target?.copyTo(
                        it.getArgument(0) as PersistentDataContainer,
                        it.getBoolean(1)
                    )
                }
                .function("adapterContext", 0) { it.target?.adapterContext }
        }
    }
}
