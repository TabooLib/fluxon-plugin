package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Scaffolding
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Scaffolding"])
@PlatformSide(Platform.BUKKIT)
object FnScaffolding {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Scaffolding::class.java)
                .function("isBottom", returns(Type.Z).noParams()) { it.target?.isBottom }
                .function("setBottom", returnsObject().params(Type.OBJECT)) { it.target?.setBottom(it.getBool(0)) }
                .function("distance", returnsObject().noParams()) { it.target?.distance }
                .function("setDistance", returnsObject().params(Type.OBJECT)) { it.target?.setDistance(it.getInt(0).toInt()) }
                .function("maximumDistance", returnsObject().noParams()) { it.target?.maximumDistance }
        }
    }
}
