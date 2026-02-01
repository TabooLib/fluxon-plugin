package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Slime
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Slime"])
@PlatformSide(Platform.BUKKIT)
object FnSlime {

    val TYPE = Type.fromClass(Slime::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Slime::class.java)
                .function("size", returns(Type.I).noParams()) { it.setReturnInt(it.target?.size ?: 0) }
                .function("setSize", returnsVoid().params(Type.I)) { it.target?.setSize(it.getInt(0).toInt()) }
        }
    }
}
