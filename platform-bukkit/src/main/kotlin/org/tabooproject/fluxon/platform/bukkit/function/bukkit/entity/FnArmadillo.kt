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

@Requires(classes = ["org.bukkit.entity.Armadillo"])
@PlatformSide(Platform.BUKKIT)
object FnArmadillo {

    val TYPE = Type.fromClass(org.bukkit.entity.Armadillo::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.entity.Armadillo::class.java)
                // .function("getState", returns(Type.fromClass(org.bukkit.entity.State::class.java)).noParams()) { it.setReturnRef(it.target?.getState()) }
                // .function("rollUp", returnsVoid().noParams()) { it.target?.rollUp() }
                // .function("rollOut", returnsVoid().noParams()) { it.target?.rollOut() }
        }
    }
}
