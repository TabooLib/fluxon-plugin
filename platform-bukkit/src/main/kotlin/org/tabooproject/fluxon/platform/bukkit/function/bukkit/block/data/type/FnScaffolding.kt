package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Scaffolding
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.Scaffolding"])
@PlatformSide(Platform.BUKKIT)
object FnScaffolding {

    val TYPE = Type.fromClass(Scaffolding::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scaffolding::class.java)
                .function("isBottom", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isBottom ?: false) }
                .function("setBottom", returnsVoid().params(Type.Z)) { it.target?.setBottom(it.getBool(0)) }
                .function("distance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.distance ?: 0) }
                .function("setDistance", returnsVoid().params(Type.I)) { it.target?.setDistance(it.getInt(0)) }
                .function("maximumDistance", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maximumDistance ?: 0) }
        }
    }
}
