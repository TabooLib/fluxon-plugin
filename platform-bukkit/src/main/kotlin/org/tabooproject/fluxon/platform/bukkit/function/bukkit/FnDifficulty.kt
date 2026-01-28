package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Difficulty
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Difficulty"])
@PlatformSide(Platform.BUKKIT)
object FnDifficulty {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Difficulty::class.java)
                .function("value", returnsObject().noParams()) { it.target?.value }
                // static
                .function("getByValue", returnsObject().params(Type.OBJECT)) { Difficulty.getByValue(it.getInt(0).toInt()) }
        }
    }
}
