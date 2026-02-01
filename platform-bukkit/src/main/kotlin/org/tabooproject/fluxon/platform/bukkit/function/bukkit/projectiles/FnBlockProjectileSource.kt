package org.tabooproject.fluxon.platform.bukkit.function.bukkit.projectiles

import org.bukkit.projectiles.BlockProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.projectiles.BlockProjectileSource"])
@PlatformSide(Platform.BUKKIT)
object FnBlockProjectileSource {

    val TYPE = Type.fromClass(BlockProjectileSource::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(BlockProjectileSource::class.java)
                .function("block", returnsObject().noParams()) { it.setReturnRef(it.target?.block) }
        }
    }
}
