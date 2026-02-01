package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Campfire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.block.data.type.Campfire"])
@PlatformSide(Platform.BUKKIT)
object FnCampfire {

    val TYPE = Type.fromClass(Campfire::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Campfire::class.java)
                .function("isSignalFire", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSignalFire ?: false) }
                .function("setSignalFire", returnsVoid().params(Type.Z)) { it.target?.setSignalFire(it.getBool(0)) }
        }
    }
}
