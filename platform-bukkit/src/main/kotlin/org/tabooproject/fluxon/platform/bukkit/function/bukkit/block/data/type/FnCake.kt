package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Cake
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Cake"])
@PlatformSide(Platform.BUKKIT)
object FnCake {

    val TYPE = Type.fromClass(Cake::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Cake::class.java)
                .function("bites", returns(Type.I).noParams()) { it.setReturnInt(it.target?.bites ?: 0) }
                .function("setBites", returnsVoid().params(Type.I)) { it.target?.setBites(it.getInt(0).toInt()) }
                .function("maximumBites", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumBites ?: 0) }
        }
    }
}
