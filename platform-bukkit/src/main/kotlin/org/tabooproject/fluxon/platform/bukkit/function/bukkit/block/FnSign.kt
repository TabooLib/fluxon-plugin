package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.DyeColor
import org.bukkit.block.Sign
import org.bukkit.block.sign.Side
import org.bukkit.entity.Player
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.block.Sign"])
@PlatformSide(Platform.BUKKIT)
object FnSign {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sign::class.java)
                .function("lines", 0) { it.target?.lines }
                .function("getLine", 1) { it.target?.getLine(it.getNumber(0).toInt()) }
                .function("setLine", 2) { it.target?.setLine(it.getNumber(0).toInt(), it.getString(1)!!) }
                .function("isEditable", 0) { it.target?.isEditable }
                .function("setEditable", 1) { it.target?.setEditable(it.getBoolean(0)) }
                .function("isWaxed", 0) { it.target?.isWaxed }
                .function("setWaxed", 1) { it.target?.setWaxed(it.getBoolean(0)) }
                .function("isGlowingText", 0) { it.target?.isGlowingText }
                .function("setGlowingText", 1) { it.target?.setGlowingText(it.getBoolean(0)) }
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as DyeColor) }
                .function("getSide", 1) { it.target?.getSide(it.getArgument(0) as Side) }
                .function("getTargetSide", 1) { it.target?.getTargetSide(it.getArgument(0) as Player) }
                .function("allowedEditor", 0) { it.target?.allowedEditor }
        }
    }
}
