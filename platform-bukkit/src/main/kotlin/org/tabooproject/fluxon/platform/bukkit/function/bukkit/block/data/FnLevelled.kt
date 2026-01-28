package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Levelled
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Levelled"])
@PlatformSide(Platform.BUKKIT)
object FnLevelled {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Levelled::class.java)
                .function("level", returnsObject().noParams()) { it.setReturnRef(it.target?.level) }
                .function("setLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLevel(it.getInt(0).toInt())) }
                .function("maximumLevel", returnsObject().noParams()) { it.setReturnRef(it.target?.maximumLevel) }
        }
    }
}
