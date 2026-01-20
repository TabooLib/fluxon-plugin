package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign

import org.bukkit.block.sign.SignSide
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnSignSide {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SignSide::class.java)
                .function("lines", 0) { it.target?.lines }
                .function("line", 1) { it.target?.getLine(it.getNumber(0).toInt()) }
                .function("setLine", 2) { it.target?.setLine(it.getNumber(0).toInt(), it.getString(1)!!) }
                .function("isGlowingText", 0) { it.target?.isGlowingText }
                .function("setGlowingText", 1) { it.target?.setGlowingText(it.getBoolean(0)) }
        }
    }
}
