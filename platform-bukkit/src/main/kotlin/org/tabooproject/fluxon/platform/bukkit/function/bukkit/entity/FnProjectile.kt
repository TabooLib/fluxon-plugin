package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Projectile
import org.bukkit.projectiles.ProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.entity.Projectile"])
@PlatformSide(Platform.BUKKIT)
object FnProjectile {

    val TYPE = Type.fromClass(Projectile::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Projectile::class.java)
                .function("shooter", returnsObject().noParams()) { it.setReturnRef(it.target?.shooter) }
                .function("setShooter", returnsVoid().params(Type.OBJECT)) { it.target?.setShooter(it.getRef(0) as ProjectileSource) }
                .function("doesBounce", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.doesBounce() ?: false) }
                .function("setBounce", returnsVoid().params(Type.Z)) { it.target?.setBounce(it.getBool(0)) }
        }
    }
}
