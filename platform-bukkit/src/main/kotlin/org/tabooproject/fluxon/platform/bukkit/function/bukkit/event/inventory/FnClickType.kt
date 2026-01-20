package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.ClickType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnClickType {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ClickType::class.java)
                .function("isKeyboardClick", 0) { it.target?.isKeyboardClick }
                .function("isMouseClick", 0) { it.target?.isMouseClick }
                .function("isCreativeAction", 0) { it.target?.isCreativeAction }
                .function("isRightClick", 0) { it.target?.isRightClick }
                .function("isLeftClick", 0) { it.target?.isLeftClick }
                .function("isShiftClick", 0) { it.target?.isShiftClick }
        }
    }
}
