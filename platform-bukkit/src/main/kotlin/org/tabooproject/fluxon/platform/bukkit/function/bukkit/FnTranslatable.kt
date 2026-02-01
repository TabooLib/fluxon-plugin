package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.Translatable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.Translatable"])
@PlatformSide(Platform.BUKKIT)
object FnTranslatable {

    val TYPE = Type.fromClass(Translatable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Translatable::class.java)
                .function("translationKey", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.translationKey) }
        }
    }
}
