package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.inventory

import org.bukkit.event.inventory.ClickType
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.inventory.ClickType"])
@PlatformSide(Platform.BUKKIT)
object FnClickType : FnEnumGetter<ClickType>() {

    override val enumClass: Class<ClickType> = ClickType::class.java

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ClickType::class.java)
                .function("isKeyboardClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isKeyboardClick ?: false) }
                .function("isMouseClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isMouseClick ?: false) }
                .function("isCreativeAction", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCreativeAction ?: false) }
                .function("isRightClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRightClick ?: false) }
                .function("isLeftClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLeftClick ?: false) }
                .function("isShiftClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShiftClick ?: false) }
        }
    }
}
