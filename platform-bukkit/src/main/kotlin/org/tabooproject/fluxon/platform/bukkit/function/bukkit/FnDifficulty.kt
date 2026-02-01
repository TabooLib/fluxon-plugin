package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Difficulty
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Difficulty"])
@PlatformSide(Platform.BUKKIT)
object FnDifficulty {

    val TYPE = Type.fromClass(Difficulty::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Difficulty::class.java)
                .function("value", returns(Type.I).noParams()) { it.setReturnInt(it.target?.value ?: 0) }
                // static
                .function("getByValue", returnsObject().params(Type.I)) { it.setReturnRef(Difficulty.getByValue(it.getInt(0).toInt())) }
        }
    }
}
