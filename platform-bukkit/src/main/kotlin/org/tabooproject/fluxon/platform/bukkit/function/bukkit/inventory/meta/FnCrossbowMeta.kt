package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.CrossbowMeta
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

@Requires(classes = ["org.bukkit.inventory.meta.CrossbowMeta"])
@PlatformSide(Platform.BUKKIT)
object FnCrossbowMeta {

    val TYPE = Type.fromClass(CrossbowMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CrossbowMeta::class.java)
                .function("hasChargedProjectiles", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasChargedProjectiles() ?: false) }
                .function("chargedProjectiles", returnsObject().noParams()) { it.setReturnRef(it.target?.chargedProjectiles) }
                .function("setChargedProjectiles", returnsVoid().params(Type.OBJECT)) { it.target?.setChargedProjectiles(it.getRef(0) as List<ItemStack>) }
                .function("addChargedProjectile", returnsVoid().params(Type.OBJECT)) { it.target?.addChargedProjectile(it.getRef(0) as ItemStack) }
        }
    }
}
