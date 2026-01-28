package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Vindicator
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Vindicator"])
@PlatformSide(Platform.BUKKIT)
object FnVindicator {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vindicator::class.java)
                .function("isJohnny", returns(Type.Z).noParams()) { it.target?.isJohnny }
                .function("setJohnny", returnsObject().params(Type.OBJECT)) { it.target?.setJohnny(it.getBool(0)) }
        }
    }
}
