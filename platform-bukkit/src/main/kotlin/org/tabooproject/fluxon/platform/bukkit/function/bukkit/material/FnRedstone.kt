package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.material.Redstone
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Redstone"])
@PlatformSide(Platform.BUKKIT)
object FnRedstone {

    val TYPE = Type.fromClass(Redstone::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Redstone::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
        }
    }
}
