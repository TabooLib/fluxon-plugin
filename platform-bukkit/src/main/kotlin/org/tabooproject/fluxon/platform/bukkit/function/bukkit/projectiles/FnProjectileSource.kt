package org.tabooproject.fluxon.platform.bukkit.function.bukkit.projectiles

import org.bukkit.projectiles.ProjectileSource
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.projectiles.ProjectileSource"])
@PlatformSide(Platform.BUKKIT)
object FnProjectileSource {

    val TYPE = Type.fromClass(ProjectileSource::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.projectiles.ProjectileSource::class.java)
                // .function("launchProjectile", returns(Type.OBJECT).params(Type.CLASS)) { it.setReturnRef(it.target?.launchProjectile(it.getRef(0) as java.lang.Class)) }
                // .function("launchProjectile", returns(Type.OBJECT).params(Type.CLASS, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE)) { it.setReturnRef(it.target?.launchProjectile(it.getRef(0) as java.lang.Class, it.getRef(1) as org.bukkit.util.Vector)) }
                // .function("launchProjectile", returns(Type.OBJECT).params(Type.CLASS, org.tabooproject.fluxon.platform.bukkit.function.bukkit.util.FnVector.TYPE, Type.fromClass(java.util.function.Consumer::class.java))) { it.setReturnRef(it.target?.launchProjectile(it.getRef(0) as java.lang.Class, it.getRef(1) as org.bukkit.util.Vector, it.getRef(2) as java.util.function.Consumer)) }
        }
    }
}
