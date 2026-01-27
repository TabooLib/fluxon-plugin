package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Projectile
import org.bukkit.projectiles.ProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.entity.Projectile"])
@PlatformSide(Platform.BUKKIT)
object FnProjectile {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Projectile::class.java)
                .function("shooter", 0) { it.target?.shooter }
                .function("setShooter", 1) { it.target?.setShooter(it.getArgument(0) as ProjectileSource) }
                .function("doesBounce", 0) { it.target?.doesBounce() }
                .function("setBounce", 1) { it.target?.setBounce(it.getBoolean(0)) }
        }
    }
}
