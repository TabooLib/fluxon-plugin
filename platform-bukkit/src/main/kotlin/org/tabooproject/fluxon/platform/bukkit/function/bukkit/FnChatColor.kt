package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ChatColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnChatColor {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChatColor::class.java)
                .function("char", 0) { it.target?.char }
                .function("toString", 0) { it.target?.toString() }
                .function("isFormat", 0) { it.target?.isFormat }
                .function("isColor", 0) { it.target?.isColor }
                // static
                .function("byChar", 1) {
                    // static ChatColor getByChar(char code)
                    // static ChatColor getByChar(@NotNull String code)
                    TODO()
                }
                // static
                .function("stripColor", 1) { ChatColor.stripColor(it.getString(0)) }
                // static
                .function("translateAlternateColorCodes", 2) {
                    ChatColor.translateAlternateColorCodes(
                        it.getString(0)?.firstOrNull()!!, it.getString(1)!!
                    )
                }
                // static
                .function("lastColors", 1) { ChatColor.getLastColors(it.getString(0)!!) }
        }
    }
}
