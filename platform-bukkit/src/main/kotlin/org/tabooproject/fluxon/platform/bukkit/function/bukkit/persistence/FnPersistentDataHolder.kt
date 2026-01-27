package org.tabooproject.fluxon.platform.bukkit.function.bukkit.persistence

import org.bukkit.persistence.PersistentDataHolder
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.persistence.PersistentDataHolder"])
@PlatformSide(Platform.BUKKIT)
object FnPersistentDataHolder {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PersistentDataHolder::class.java)
                .function("persistentDataContainer", 0) { it.target?.persistentDataContainer }
        }
    }
}
