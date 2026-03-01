package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.entity.Salmon"])
@PlatformSide(Platform.BUKKIT)
object FnSalmon {

    val TYPE = Type.fromClass(org.bukkit.entity.Salmon::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Salmon::class.java)
                // .function("getVariant", returns(Type.fromClass(org.bukkit.entity.Variant::class.java)).noParams()) { it.setReturnRef(it.target?.getVariant()) }
                // .function("setVariant", returnsVoid().params(Type.fromClass(org.bukkit.entity.Variant::class.java))) { it.target?.setVariant(it.getRef(0) as org.bukkit.entity.Variant) }
        }
    }
}
