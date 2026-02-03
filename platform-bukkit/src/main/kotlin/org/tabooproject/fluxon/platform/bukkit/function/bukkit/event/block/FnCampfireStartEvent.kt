package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.CampfireStartEvent
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnCampfireRecipe
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.CampfireStartEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCampfireStartEvent {

    val TYPE = Type.fromClass(CampfireStartEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CampfireStartEvent::class.java)
                .function("recipe", returns(FnCampfireRecipe.TYPE).noParams()) { it.setReturnRef(it.target?.recipe) }
                .function("totalCookTime", returns(Type.I).noParams()) { it.setReturnRef(it.target?.totalCookTime) }
                .function("setTotalCookTime", returnsVoid().params(Type.I)) { it.target?.setTotalCookTime(it.getInt(0)) }
        }
    }
}
