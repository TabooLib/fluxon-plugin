package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Repeater
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

@Requires(classes = ["org.bukkit.block.data.type.Repeater"])
@PlatformSide(Platform.BUKKIT)
object FnRepeater {

    val TYPE = Type.fromClass(Repeater::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Repeater::class.java)
                .function("delay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.delay ?: 0) }
                .function("setDelay", returnsVoid().params(Type.I)) { it.target?.setDelay(it.getInt(0).toInt()) }
                .function("minimumDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.minimumDelay ?: 0) }
                .function("maximumDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumDelay ?: 0) }
                .function("isLocked", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isLocked ?: false) }
                .function("setLocked", returnsVoid().params(Type.Z)) { it.target?.setLocked(it.getBool(0)) }
        }
    }
}
