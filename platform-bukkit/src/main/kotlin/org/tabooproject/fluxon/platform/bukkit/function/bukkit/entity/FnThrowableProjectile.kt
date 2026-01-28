package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.ThrowableProjectile
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.ThrowableProjectile"])
@PlatformSide(Platform.BUKKIT)
object FnThrowableProjectile {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ThrowableProjectile::class.java)
                .function("item", returnsObject().noParams()) { it.target?.item }
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
        }
    }
}
