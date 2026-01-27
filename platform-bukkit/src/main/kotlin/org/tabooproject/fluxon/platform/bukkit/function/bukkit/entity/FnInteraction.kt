package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Interaction
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.entity.Interaction"])
@PlatformSide(Platform.BUKKIT)
object FnInteraction {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Interaction::class.java)
                .function("interactionWidth", 0) { it.target?.interactionWidth }
                .function("setInteractionWidth", 1) { it.target?.setInteractionWidth(it.getNumber(0).toFloat()) }
                .function("interactionHeight", 0) { it.target?.interactionHeight }
                .function("setInteractionHeight", 1) { it.target?.setInteractionHeight(it.getNumber(0).toFloat()) }
                .function("isResponsive", 0) { it.target?.isResponsive }
                .function("setResponsive", 1) { it.target?.setResponsive(it.getBoolean(0)) }
                .function("lastAttack", 0) { it.target?.lastAttack }
                .function("lastInteraction", 0) { it.target?.lastInteraction }
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
                .function("player", 0) { it.target?.player }
                .function("timestamp", 0) { it.target?.timestamp }
        }
    }
}
