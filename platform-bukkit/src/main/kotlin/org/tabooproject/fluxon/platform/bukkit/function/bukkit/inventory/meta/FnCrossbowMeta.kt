package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.CrossbowMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.CrossbowMeta"])
@PlatformSide(Platform.BUKKIT)
object FnCrossbowMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CrossbowMeta::class.java)
                .function("hasChargedProjectiles", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasChargedProjectiles()) }
                .function("chargedProjectiles", returnsObject().noParams()) { it.setReturnRef(it.target?.chargedProjectiles) }
                .function("setChargedProjectiles", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setChargedProjectiles(it.getRef(0) as List<ItemStack>)) }
                .function("addChargedProjectile", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addChargedProjectile(it.getRef(0) as ItemStack)) }
        }
    }
}
