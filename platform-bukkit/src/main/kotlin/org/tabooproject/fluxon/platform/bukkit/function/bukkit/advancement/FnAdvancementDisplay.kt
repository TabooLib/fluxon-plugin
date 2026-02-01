package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementDisplay
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.advancement.AdvancementDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnAdvancementDisplay {

    val TYPE = Type.fromClass(AdvancementDisplay::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementDisplay::class.java)
                .function("title", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.title) }
                .function("description", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.description) }
                .function("icon", returns(FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.icon) }
                .function("shouldShowToast", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.shouldShowToast() ?: false) }
                .function("shouldAnnounceChat", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.shouldAnnounceChat() ?: false) }
                .function("isHidden", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isHidden ?: false) }
                .function("x", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.x ?: 0.0f) }
                .function("y", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.y ?: 0.0f) }
                .function("type", returns(FnAdvancementDisplayType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
        }
    }
}
