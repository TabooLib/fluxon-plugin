package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Interaction
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Interaction"])
@PlatformSide(Platform.BUKKIT)
object FnInteraction {

    val TYPE = Type.fromClass(Interaction::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Interaction::class.java)
                .function("interactionWidth", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.interactionWidth ?: 0f) }
                .function("setInteractionWidth", returnsVoid().params(Type.F)) { it.target?.setInteractionWidth(it.getFloat(0)) }
                .function("interactionHeight", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.interactionHeight ?: 0f) }
                .function("setInteractionHeight", returnsVoid().params(Type.F)) { it.target?.setInteractionHeight(it.getFloat(0)) }
                .function("isResponsive", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isResponsive ?: false) }
                .function("setResponsive", returnsVoid().params(Type.Z)) { it.target?.setResponsive(it.getBool(0)) }
                .function("lastAttack", returnsObject().noParams()) { it.setReturnRef(it.target?.lastAttack) }
                .function("lastInteraction", returnsObject().noParams()) { it.setReturnRef(it.target?.lastInteraction) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Interaction.PreviousInteraction"])
@PlatformSide(Platform.BUKKIT)
object FnInteractionPreviousInteraction {

    val TYPE = Type.fromClass(Interaction.PreviousInteraction::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Interaction.PreviousInteraction::class.java)
                .function("player", returnsObject().noParams()) { it.setReturnRef(it.target?.player) }
                .function("timestamp", returns(Type.J).noParams()) { it.setReturnLong(it.target?.timestamp ?: 0L) }
        }
    }
}
