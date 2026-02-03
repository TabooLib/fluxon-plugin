package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign

import org.bukkit.block.sign.SignSide
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.sign.SignSide"])
@PlatformSide(Platform.BUKKIT)
object FnSignSide {

    val TYPE = Type.fromClass(SignSide::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SignSide::class.java)
                .function("lines", returns(StandardTypes.STRING_ARRAY).noParams()) { it.setReturnRef(it.target?.lines) }
                .function("getLine", returns(Type.STRING).params(Type.I)) { it.setReturnRef(it.target?.getLine(it.getInt(0).toInt())) }
                .function("setLine", returnsVoid().params(Type.I, Type.STRING)) {
                    it.target?.setLine(it.getInt(0), it.getString(1)!!)
                }
                .function("isGlowingText", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isGlowingText ?: false) }
                .function("setGlowingText", returnsVoid().params(Type.Z)) { it.target?.setGlowingText(it.getBool(0)) }
        }
    }
}
