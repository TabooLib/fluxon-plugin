package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.sign

import org.bukkit.block.sign.SignSide
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.sign.SignSide"])
@PlatformSide(Platform.BUKKIT)
object FnSignSide {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SignSide::class.java)
                .function("lines", returnsObject().noParams()) { it.target?.lines }
                .function("getLine", returnsObject().params(Type.OBJECT)) { it.target?.getLine(it.getInt(0).toInt()) }
                .function("setLine", returnsObject().params(Type.OBJECT, Type.OBJECT)) { it.target?.setLine(it.getInt(0).toInt(), it.getString(1)!!) }
                .function("isGlowingText", returns(Type.Z).noParams()) { it.target?.isGlowingText }
                .function("setGlowingText", returnsObject().params(Type.OBJECT)) { it.target?.setGlowingText(it.getBool(0)) }
        }
    }
}
