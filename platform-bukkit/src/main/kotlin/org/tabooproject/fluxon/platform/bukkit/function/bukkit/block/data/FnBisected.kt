package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Bisected
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Bisected"])
@PlatformSide(Platform.BUKKIT)
object FnBisected {

    val TYPE = Type.fromClass(Bisected::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Bisected::class.java)
                .function("half", returnsObject().noParams()) { it.setReturnRef(it.target?.half) }
                .function("setHalf", returnsVoid().params(Type.OBJECT)) { it.target?.setHalf(it.getRef(0) as Bisected.Half) }
        }
    }
}
