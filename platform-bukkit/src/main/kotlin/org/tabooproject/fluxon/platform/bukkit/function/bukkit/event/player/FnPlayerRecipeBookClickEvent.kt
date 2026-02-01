package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.player

import org.bukkit.event.player.PlayerRecipeBookClickEvent
import org.bukkit.inventory.Recipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.player.PlayerRecipeBookClickEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerRecipeBookClickEvent {

    val TYPE = Type.fromClass(PlayerRecipeBookClickEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerRecipeBookClickEvent::class.java)
                .function("originalRecipe", returnsObject().noParams()) { it.setReturnRef(it.target?.originalRecipe) }
                .function("recipe", returnsObject().noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("setRecipe", returnsVoid().params(Type.OBJECT)) { it.target?.setRecipe(it.getRef(0) as Recipe) }
                .function("isShiftClick", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShiftClick ?: false) }
                .function("setShiftClick", returnsVoid().params(Type.Z)) { it.target?.setShiftClick(it.getBool(0)) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(PlayerRecipeBookClickEvent.getHandlerList()) }
        }
    }
}
