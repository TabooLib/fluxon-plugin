package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractHorse
import org.bukkit.entity.Horse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnAbstractHorse {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractHorse::class.java)
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as Horse.Variant) }
                .function("domestication", 0) { it.target?.domestication }
                .function("setDomestication", 1) { it.target?.setDomestication(it.getNumber(0).toInt()) }
                .function("maxDomestication", 0) { it.target?.maxDomestication }
                .function("setMaxDomestication", 1) { it.target?.setMaxDomestication(it.getNumber(0).toInt()) }
                .function("jumpStrength", 0) { it.target?.jumpStrength }
                .function("setJumpStrength", 1) { it.target?.setJumpStrength(it.getNumber(0).toDouble()) }
                .function("isEatingHaystack", 0) { it.target?.isEatingHaystack }
                .function("setEatingHaystack", 1) { it.target?.setEatingHaystack(it.getBoolean(0)) }
                .function("inventory", 0) { it.target?.inventory }
        }
    }
}
