package org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta

import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.meta.EnchantmentStorageMeta
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.inventory.meta.EnchantmentStorageMeta"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantmentStorageMeta {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentStorageMeta::class.java)
                .function("hasStoredEnchants", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.hasStoredEnchants()) }
                .function("hasStoredEnchant", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasStoredEnchant(it.getRef(0) as Enchantment)) }
                .function("getStoredEnchantLevel", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getStoredEnchantLevel(it.getRef(0) as Enchantment)) }
                .function("addStoredEnchant", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.addStoredEnchant(
                        it.getRef(0) as Enchantment,
                        it.getInt(1).toInt(),
                        it.getBool(2)
                    ))
                }
                .function("removeStoredEnchant", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeStoredEnchant(it.getRef(0) as Enchantment)) }
                .function("hasConflictingStoredEnchant", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasConflictingStoredEnchant(it.getRef(0) as Enchantment)) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
