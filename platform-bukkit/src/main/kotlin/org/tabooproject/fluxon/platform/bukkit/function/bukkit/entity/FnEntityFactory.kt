package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.EntityFactory
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnEntityFactory {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EntityFactory::class.java)
                .function("createEntitySnapshot", 1) { it.target?.createEntitySnapshot(it.getString(0)!!) }
        }
    }
}
