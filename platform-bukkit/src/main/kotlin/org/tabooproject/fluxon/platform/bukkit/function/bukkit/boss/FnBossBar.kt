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
                .function("color", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.TYPE)) { it.target?.setColor(it.getRef(0) as BarColor)  }
                .function("setColor", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarColor.enumValue(it.getString(0))?.let { p0 -> it.target?.setColor(p0)  } }
                .function("style", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.TYPE).noParams()) { it.setReturnRef(it.target?.style) }
                .function("setStyle", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.TYPE)) { it.target?.setStyle(it.getRef(0) as BarStyle)  }
                .function("setStyle", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarStyle.enumValue(it.getString(0))?.let { p0 -> it.target?.setStyle(p0)  } }
                .function("removeFlag", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarFlag.TYPE)) { it.target?.removeFlag(it.getRef(0) as BarFlag)  }
                .function("removeFlag", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarFlag.enumValue(it.getString(0))?.let { p0 -> it.target?.removeFlag(p0)  } }
                .function("addFlag", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarFlag.TYPE)) { it.target?.addFlag(it.getRef(0) as BarFlag)  }
                .function("addFlag", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarFlag.enumValue(it.getString(0))?.let { p0 -> it.target?.addFlag(p0)  } }
                .function("hasFlag", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarFlag.TYPE)) { it.setReturnBool(it.target?.hasFlag(it.getRef(0) as BarFlag) ?: false)  }
                .function("hasFlag", returns(Type.Z).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.boss.FnBarFlag.enumValue(it.getString(0))?.let { p0 -> it.setReturnBool(it.target?.hasFlag(p0) ?: false)  } }
                .function("setProgress", returnsVoid().params(Type.D)) { it.target?.setProgress(it.getDouble(0)) }
                .function("progress", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.progress ?: 0.0) }
                .function("addPlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) { it.target?.addPlayer(it.getRef(0) as Player) }
                .function("removePlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer.TYPE)) { it.target?.removePlayer(it.getRef(0) as Player) }
                .function("removeAll", returnsVoid().noParams()) { it.target?.removeAll() }
                .function("players",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.players) }
                .function("setVisible", returnsVoid().params(Type.Z)) { it.target?.setVisible(it.getBool(0)) }
                .function("isVisible", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isVisible ?: false) }
                .function("show", returnsVoid().noParams()) { it.target?.show() }
                .function("hide", returnsVoid().noParams()) { it.target?.hide() }
        }
    }
}
