package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.SculkCatalyst
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.SculkCatalyst"])
@PlatformSide(Platform.BUKKIT)
object FnSculkCatalyst {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(SculkCatalyst::class.java)
                .function("isBloom", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isBloom) }
                .function("setBloom", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBloom(it.getBool(0))) }
        }
    }
}
