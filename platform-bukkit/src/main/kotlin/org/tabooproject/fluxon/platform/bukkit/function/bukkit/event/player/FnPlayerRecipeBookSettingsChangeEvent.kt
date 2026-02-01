package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerRecipeBookSettingsChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerRecipeBookSettingsChangeEvent {

    val TYPE = Type.fromClass(PlayerRecipeBookSettingsChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRecipeBookSettingsChangeEvent::class.java)
                .function("recipeBookType", returnsObject().noParams()) { it.setReturnRef(it.target?.recipeBookType) }
                .function("isOpen", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOpen ?: false) }
                .function("isFiltering", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFiltering ?: false) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerRecipeBookSettingsChangeEvent.getHandlerList()) }
        }
    }
}
