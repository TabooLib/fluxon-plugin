package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Repeater
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Repeater"])
@PlatformSide(Platform.BUKKIT)
object FnRepeater {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Repeater::class.java)
                .function("delay", returnsObject().noParams()) { it.target?.delay }
                .function("setDelay", returnsObject().params(Type.OBJECT)) { it.target?.setDelay(it.getInt(0).toInt()) }
                .function("minimumDelay", returnsObject().noParams()) { it.target?.minimumDelay }
                .function("maximumDelay", returnsObject().noParams()) { it.target?.maximumDelay }
                .function("isLocked", returns(Type.Z).noParams()) { it.target?.isLocked }
                .function("setLocked", returnsObject().params(Type.OBJECT)) { it.target?.setLocked(it.getBool(0)) }
        }
    }
}
