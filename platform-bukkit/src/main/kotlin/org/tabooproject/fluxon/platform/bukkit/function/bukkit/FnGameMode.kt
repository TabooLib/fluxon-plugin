package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameMode
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.GameMode"])
@PlatformSide(Platform.BUKKIT)
object FnGameMode {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameMode::class.java)
                .function("value", returnsObject().noParams()) { it.setReturnRef(it.target?.value) }
                // static
                .function("getByValue", returnsObject().params(Type.OBJECT)) { it.setReturnRef(GameMode.getByValue(it.getInt(0).toInt())) }
        }
    }
}
