package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Projectile
import org.bukkit.projectiles.ProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.entity.Projectile"])
@PlatformSide(Platform.BUKKIT)
object FnProjectile {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Projectile::class.java)
                .function("shooter", returnsObject().noParams()) { it.target?.shooter }
                .function("setShooter", returnsObject().params(Type.OBJECT)) { it.target?.setShooter(it.getRef(0) as ProjectileSource) }
                .function("doesBounce", returnsObject().noParams()) { it.target?.doesBounce() }
                .function("setBounce", returnsObject().params(Type.OBJECT)) { it.target?.setBounce(it.getBool(0)) }
        }
    }
}
