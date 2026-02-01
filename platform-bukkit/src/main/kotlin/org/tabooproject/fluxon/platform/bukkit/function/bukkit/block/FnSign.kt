package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.DyeColor
import org.bukkit.block.Sign
import org.bukkit.block.sign.Side
import org.bukkit.entity.Player
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnDyeColor
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign.FnSide
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign.FnSignSide
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnPlayer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Sign"])
@PlatformSide(Platform.BUKKIT)
object FnSign {

    val TYPE = Type.fromClass(Sign::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sign::class.java)
                .function("lines", returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.lines?.toList()) }
                .function("getLine", returns(Type.STRING).params(Type.I)) { it.setReturnRef(it.target?.getLine(it.getInt(0).toInt())) }
                .function("setLine", returnsVoid().params(Type.I, Type.STRING)) { it.target?.setLine(it.getInt(0).toInt(), it.getString(1)!!) }
                .function("isEditable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEditable ?: false) }
                .function("setEditable", returnsVoid().params(Type.Z)) { it.target?.setEditable(it.getBool(0)) }
                .function("isWaxed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isWaxed ?: false) }
                .function("setWaxed", returnsVoid().params(Type.Z)) { it.target?.setWaxed(it.getBool(0)) }
                .function("isGlowingText", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isGlowingText ?: false) }
                .function("setGlowingText", returnsVoid().params(Type.Z)) { it.target?.setGlowingText(it.getBool(0)) }
                .function("color", returns(FnDyeColor.TYPE).noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(FnDyeColor.TYPE)) { it.target?.setColor(it.getRef(0) as DyeColor) }
                .function("setColor", returnsVoid().params(Type.STRING)) { FnDyeColor.enumValue(it.getString(0))?.let { p0 -> it.target?.setColor(p0) } }
                .function("getSide", returns(FnSignSide.TYPE).params(FnSide.TYPE)) { it.setReturnRef(it.target?.getSide(it.getRef(0) as Side)) }
                .function("getTargetSide", returns(FnSignSide.TYPE).params(FnPlayer.TYPE)) { it.setReturnRef(it.target?.getTargetSide(it.getRef(0) as Player)) }
                .function("allowedEditor", returns(FnPlayer.TYPE).noParams()) { it.setReturnRef(it.target?.allowedEditor) }
        }
    }
}
