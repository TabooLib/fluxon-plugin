package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.ClickType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.inventory.ClickType"])
@PlatformSide(Platform.BUKKIT)
object FnClickType {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ClickType::class.java)
                .function("isKeyboardClick", returns(Type.Z).noParams()) { it.target?.isKeyboardClick }
                .function("isMouseClick", returns(Type.Z).noParams()) { it.target?.isMouseClick }
                .function("isCreativeAction", returns(Type.Z).noParams()) { it.target?.isCreativeAction }
                .function("isRightClick", returns(Type.Z).noParams()) { it.target?.isRightClick }
                .function("isLeftClick", returns(Type.Z).noParams()) { it.target?.isLeftClick }
                .function("isShiftClick", returns(Type.Z).noParams()) { it.target?.isShiftClick }
        }
    }
}
