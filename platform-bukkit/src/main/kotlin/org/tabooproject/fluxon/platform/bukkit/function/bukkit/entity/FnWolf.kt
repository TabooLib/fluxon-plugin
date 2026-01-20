package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.DyeColor
import org.bukkit.entity.Wolf
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnWolf {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wolf::class.java)
                .function("isAngry", 0) { it.target?.isAngry }
                .function("setAngry", 1) { it.target?.setAngry(it.getBoolean(0)) }
                .function("collarColor", 0) { it.target?.collarColor }
                .function("setCollarColor", 1) { it.target?.setCollarColor(it.getArgument(0) as DyeColor) }
                .function("isWet", 0) { it.target?.isWet }
                .function("tailAngle", 0) { it.target?.tailAngle }
                .function("isInterested", 0) { it.target?.isInterested }
                .function("setInterested", 1) { it.target?.setInterested(it.getBoolean(0)) }
                .function("variant", 0) { it.target?.variant }
                .function("setVariant", 1) { it.target?.setVariant(it.getArgument(0) as Wolf.Variant) }
        }
    }
}
