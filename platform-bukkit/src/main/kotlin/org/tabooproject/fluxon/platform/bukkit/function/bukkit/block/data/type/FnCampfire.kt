package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Campfire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Campfire"])
@PlatformSide(Platform.BUKKIT)
object FnCampfire {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Campfire::class.java)
                .function("isSignalFire", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSignalFire) }
                .function("setSignalFire", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSignalFire(it.getBool(0))) }
        }
    }
}
