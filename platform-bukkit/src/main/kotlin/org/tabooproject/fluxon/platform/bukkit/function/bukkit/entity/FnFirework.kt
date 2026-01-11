package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Firework
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnFirework {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Firework::class.java)
                .function("fireworkMeta", 0) { it.target?.fireworkMeta }
                .function("setFireworkMeta", 1) { it.target?.setFireworkMeta(it.getArgument(0) as FireworkMeta) }
                .function("setAttachedTo", 1) { it.target?.setAttachedTo(it.getArgument(0) as LivingEntity) }
                .function("attachedTo", 0) { it.target?.attachedTo }
                .function("setLife", 1) { it.target?.setLife(it.getNumber(0).toInt()) }
                .function("life", 0) { it.target?.life }
                .function("setMaxLife", 1) { it.target?.setMaxLife(it.getNumber(0).toInt()) }
                .function("maxLife", 0) { it.target?.maxLife }
                .function("detonate", 0) { it.target?.detonate() }
                .function("isDetonated", 0) { it.target?.isDetonated }
                .function("isShotAtAngle", 0) { it.target?.isShotAtAngle }
                .function("setShotAtAngle", 1) { it.target?.setShotAtAngle(it.getBoolean(0)) }
        }
    }
}
