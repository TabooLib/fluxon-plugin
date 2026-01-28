package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Beehive
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Beehive"])
@PlatformSide(Platform.BUKKIT)
object FnBeehive {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Beehive::class.java)
                .function("honeyLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.honeyLevel) }
                .function("setHoneyLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setHoneyLevel(it.getInt(0).toInt())) }
                .function("maximumHoneyLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumHoneyLevel) }
        }
    }
}
