package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.bukkit.block.Dispenser
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.projectiles.FnBlockProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.Dispenser"])
@PlatformSide(Platform.BUKKIT)
object FnDispenser {

    val TYPE = Type.fromClass(Dispenser::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Dispenser::class.java)
                .function("blockProjectileSource", returns(FnBlockProjectileSource.TYPE).noParams()) { it.setReturnRef(it.target?.blockProjectileSource) }
                .function("dispense", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.dispense()) }
        }
    }
}
