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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.boss.BossBar"])
@PlatformSide(Platform.BUKKIT)
object FnBossBar {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BossBar::class.java)
                .function("title", returnsObject().noParams()) { it.target?.title }
                .function("setTitle", returnsObject().params(Type.OBJECT)) { it.target?.setTitle(it.getString(0)) }
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as BarColor) }
                .function("style", returnsObject().noParams()) { it.target?.style }
                .function("setStyle", returnsObject().params(Type.OBJECT)) { it.target?.setStyle(it.getRef(0) as BarStyle) }
                .function("removeFlag", returnsObject().params(Type.OBJECT)) { it.target?.removeFlag(it.getRef(0) as BarFlag) }
                .function("addFlag", returnsObject().params(Type.OBJECT)) { it.target?.addFlag(it.getRef(0) as BarFlag) }
                .function("hasFlag", returns(Type.Z).params(Type.OBJECT)) { it.target?.hasFlag(it.getRef(0) as BarFlag) }
                .function("setProgress", returnsObject().params(Type.OBJECT)) { it.target?.setProgress(it.getAsDouble(0)) }
                .function("progress", returnsObject().noParams()) { it.target?.progress }
                .function("addPlayer", returnsObject().params(Type.OBJECT)) { it.target?.addPlayer(it.getRef(0) as Player) }
                .function("removePlayer", returnsObject().params(Type.OBJECT)) { it.target?.removePlayer(it.getRef(0) as Player) }
                .function("removeAll", returnsObject().noParams()) { it.target?.removeAll() }
                .function("players", returnsObject().noParams()) { it.target?.players }
                .function("setVisible", returnsObject().params(Type.OBJECT)) { it.target?.setVisible(it.getBool(0)) }
                .function("isVisible", returns(Type.Z).noParams()) { it.target?.isVisible }
                .function("show", returnsObject().noParams()) { it.target?.show() }
                .function("hide", returnsObject().noParams()) { it.target?.hide() }
        }
    }
}
