package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Cake
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Cake"])
@PlatformSide(Platform.BUKKIT)
object FnCake {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cake::class.java)
                .function("bites", returnsObject().noParams()) { it.target?.bites }
                .function("setBites", returnsObject().params(Type.OBJECT)) { it.target?.setBites(it.getInt(0).toInt()) }
                .function("maximumBites", returnsObject().noParams()) { it.target?.maximumBites }
        }
    }
}
