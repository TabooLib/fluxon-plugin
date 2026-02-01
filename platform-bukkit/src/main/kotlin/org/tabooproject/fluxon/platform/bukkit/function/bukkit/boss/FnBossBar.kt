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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.boss.BossBar"])
@PlatformSide(Platform.BUKKIT)
object FnBossBar {

    val TYPE = Type.fromClass(BossBar::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BossBar::class.java)
                .function("title", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.title) }
                .function("setTitle", returnsVoid().params(Type.STRING)) { it.target?.setTitle(it.getString(0)) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as BarColor) }
                .function("style", returnsObject().noParams()) { it.setReturnRef(it.target?.style) }
                .function("setStyle", returnsVoid().params(Type.OBJECT)) { it.target?.setStyle(it.getRef(0) as BarStyle) }
                .function("removeFlag", returnsVoid().params(Type.OBJECT)) { it.target?.removeFlag(it.getRef(0) as BarFlag) }
                .function("addFlag", returnsVoid().params(Type.OBJECT)) { it.target?.addFlag(it.getRef(0) as BarFlag) }
                .function("hasFlag", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.hasFlag(it.getRef(0) as BarFlag) ?: false) }
                .function("setProgress", returnsVoid().params(Type.D)) { it.target?.setProgress(it.getDouble(0)) }
                .function("progress", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.progress ?: 0.0) }
                .function("addPlayer", returnsVoid().params(Type.OBJECT)) { it.target?.addPlayer(it.getRef(0) as Player) }
                .function("removePlayer", returnsVoid().params(Type.OBJECT)) { it.target?.removePlayer(it.getRef(0) as Player) }
                .function("removeAll", returnsVoid().noParams()) { it.target?.removeAll() }
                .function("players", returnsObject().noParams()) { it.setReturnRef(it.target?.players) }
                .function("setVisible", returnsVoid().params(Type.Z)) { it.target?.setVisible(it.getBool(0)) }
                .function("isVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisible ?: false) }
                .function("show", returnsVoid().noParams()) { it.target?.show() }
                .function("hide", returnsVoid().noParams()) { it.target?.hide() }
        }
    }
}
