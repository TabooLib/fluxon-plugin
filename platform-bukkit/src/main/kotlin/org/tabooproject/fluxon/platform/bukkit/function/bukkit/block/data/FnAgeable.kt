package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Ageable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Ageable"])
@PlatformSide(Platform.BUKKIT)
object FnAgeable {

    val TYPE = Type.fromClass(Ageable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Ageable::class.java)
                .function("age", returns(Type.I).noParams()) { it.setReturnInt(it.target?.age ?: 0) }
                .function("setAge", returnsVoid().params(Type.I)) { it.target?.setAge(it.getInt(0)) }
                .function("maximumAge", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumAge ?: 0) }
        }
    }
}
