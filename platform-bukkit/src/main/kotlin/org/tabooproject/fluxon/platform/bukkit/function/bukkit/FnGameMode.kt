package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.GameMode
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.GameMode"])
@PlatformSide(Platform.BUKKIT)
object FnGameMode : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.GameMode>() {

    override val enumClass: Class<org.bukkit.GameMode> = org.bukkit.GameMode::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(GameMode::class.java)
                .function("value", returns(Type.I).noParams()) { it.setReturnInt(it.target?.value ?: 0) }
                // static
                .function("getByValue", returns(TYPE).params(Type.I)) { it.setReturnRef(GameMode.getByValue(it.getInt(0).toInt())) }
        }
    }
}
