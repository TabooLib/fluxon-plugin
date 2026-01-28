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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.Sign"])
@PlatformSide(Platform.BUKKIT)
object FnSign {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Sign::class.java)
                .function("lines", returnsObject().noParams()) { it.target?.lines }
                .function("getLine", returnsObject().params(Type.OBJECT)) { it.target?.getLine(it.getInt(0).toInt()) }
                .function("setLine", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setLine(it.getInt(0).toInt(), it.getString(1)!!) }
                .function("isEditable", returns(Type.Z).noParams()) { it.target?.isEditable }
                .function("setEditable", returnsObject().params(Type.OBJECT)) { it.target?.setEditable(it.getBool(0)) }
                .function("isWaxed", returns(Type.Z).noParams()) { it.target?.isWaxed }
                .function("setWaxed", returnsObject().params(Type.OBJECT)) { it.target?.setWaxed(it.getBool(0)) }
                .function("isGlowingText", returns(Type.Z).noParams()) { it.target?.isGlowingText }
                .function("setGlowingText", returnsObject().params(Type.OBJECT)) { it.target?.setGlowingText(it.getBool(0)) }
                .function("color", returnsObject().noParams()) { it.target?.color }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as DyeColor) }
                .function("getSide", returnsObject().params(Type.OBJECT)) { it.target?.getSide(it.getRef(0) as Side) }
                .function("getTargetSide", returnsObject().params(Type.OBJECT)) { it.target?.getTargetSide(it.getRef(0) as Player) }
                .function("allowedEditor", returnsObject().noParams()) { it.target?.allowedEditor }
        }
    }
}
