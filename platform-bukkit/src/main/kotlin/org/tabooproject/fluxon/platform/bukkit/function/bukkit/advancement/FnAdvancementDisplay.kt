package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementDisplay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAdvancementDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementDisplay::class.java)
                .function("title", 0) { it.target?.title }
                .function("description", 0) { it.target?.description }
                .function("icon", 0) { it.target?.icon }
                .function("shouldShowToast", 0) { it.target?.shouldShowToast() }
                .function("shouldAnnounceChat", 0) { it.target?.shouldAnnounceChat() }
                .function("isHidden", 0) { it.target?.isHidden }
                .function("x", 0) { it.target?.x }
                .function("y", 0) { it.target?.y }
                .function("type", 0) { it.target?.type }
        }
    }
}
