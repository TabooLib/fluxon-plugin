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

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRecipeBookSettingsChangeEvent::class.java)
                .function("recipeBookType", returnsObject().noParams()) { it.setReturnRef(it.target?.recipeBookType) }
                .function("isOpen", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isOpen) }
                .function("isFiltering", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isFiltering) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerRecipeBookSettingsChangeEvent.getHandlerList()) }
        }
    }
}
