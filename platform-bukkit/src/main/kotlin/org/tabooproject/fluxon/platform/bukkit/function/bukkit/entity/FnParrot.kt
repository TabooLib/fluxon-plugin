package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Parrot
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

@Requires(classes = ["org.bukkit.entity.Parrot"])
@PlatformSide(Platform.BUKKIT)
object FnParrot {

    val TYPE = Type.fromClass(Parrot::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Parrot::class.java)
                .function("variant", returnsObject().noParams()) { it.setReturnRef(it.target?.variant) }
                .function("setVariant", returnsVoid().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Parrot.Variant) }
                .function("isDancing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDancing ?: false) }
        }
    }
}
