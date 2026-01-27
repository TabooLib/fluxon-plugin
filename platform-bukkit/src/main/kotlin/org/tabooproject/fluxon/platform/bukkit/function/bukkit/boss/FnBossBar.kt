package org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss

import org.bukkit.boss.BarColor
import org.bukkit.boss.BarFlag
import org.bukkit.boss.BarStyle
import org.bukkit.boss.BossBar
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.boss.BossBar"])
@PlatformSide(Platform.BUKKIT)
object FnBossBar {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BossBar::class.java)
                .function("title", 0) { it.target?.title }
                .function("setTitle", 1) { it.target?.setTitle(it.getString(0)) }
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as BarColor) }
                .function("style", 0) { it.target?.style }
                .function("setStyle", 1) { it.target?.setStyle(it.getArgument(0) as BarStyle) }
                .function("removeFlag", 1) { it.target?.removeFlag(it.getArgument(0) as BarFlag) }
                .function("addFlag", 1) { it.target?.addFlag(it.getArgument(0) as BarFlag) }
                .function("hasFlag", 1) { it.target?.hasFlag(it.getArgument(0) as BarFlag) }
                .function("setProgress", 1) { it.target?.setProgress(it.getNumber(0).toDouble()) }
                .function("progress", 0) { it.target?.progress }
                .function("addPlayer", 1) { it.target?.addPlayer(it.getArgument(0) as Player) }
                .function("removePlayer", 1) { it.target?.removePlayer(it.getArgument(0) as Player) }
                .function("removeAll", 0) { it.target?.removeAll() }
                .function("players", 0) { it.target?.players }
                .function("setVisible", 1) { it.target?.setVisible(it.getBoolean(0)) }
                .function("isVisible", 0) { it.target?.isVisible }
                .function("show", 0) { it.target?.show() }
                .function("hide", 0) { it.target?.hide() }
        }
    }
}
