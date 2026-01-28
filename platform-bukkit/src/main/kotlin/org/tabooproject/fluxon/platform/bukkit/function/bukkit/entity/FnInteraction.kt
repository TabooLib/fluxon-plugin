package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Interaction
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Interaction"])
@PlatformSide(Platform.BUKKIT)
object FnInteraction {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Interaction::class.java)
                .function("interactionWidth", returnsObject().noParams()) { it.target?.interactionWidth }
                .function("setInteractionWidth", returnsObject().params(Type.OBJECT)) { it.target?.setInteractionWidth(it.getFloat(0)) }
                .function("interactionHeight", returnsObject().noParams()) { it.target?.interactionHeight }
                .function("setInteractionHeight", returnsObject().params(Type.OBJECT)) { it.target?.setInteractionHeight(it.getFloat(0)) }
                .function("isResponsive", returns(Type.Z).noParams()) { it.target?.isResponsive }
                .function("setResponsive", returnsObject().params(Type.OBJECT)) { it.target?.setResponsive(it.getBool(0)) }
                .function("lastAttack", returnsObject().noParams()) { it.target?.lastAttack }
                .function("lastInteraction", returnsObject().noParams()) { it.target?.lastInteraction }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Interaction.PreviousInteraction"])
@PlatformSide(Platform.BUKKIT)
object FnInteractionPreviousInteraction {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Interaction.PreviousInteraction::class.java)
                .function("player", returnsObject().noParams()) { it.target?.player }
                .function("timestamp", returnsObject().noParams()) { it.target?.timestamp }
        }
    }
}
