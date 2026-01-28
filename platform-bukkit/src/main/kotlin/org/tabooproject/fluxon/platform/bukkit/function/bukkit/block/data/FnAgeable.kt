package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Ageable"])
@PlatformSide(Platform.BUKKIT)
object FnAgeable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", returnsObject().noParams()) { it.setReturnRef(it.target?.age) }
                .function("setAge", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAge(it.getInt(0).toInt())) }
                .function("maximumAge", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumAge) }
        }
    }
}
