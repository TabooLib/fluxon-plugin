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

    val TYPE = Type.fromClass(EnchantmentStorageMeta::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentStorageMeta::class.java)
                .function("hasStoredEnchants", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.hasStoredEnchants() ?: false) }
                .function("hasStoredEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) { it.setReturnBool(it.target?.hasStoredEnchant(it.getRef(0) as Enchantment) ?: false) }
                .function("getStoredEnchantLevel",returns(Type.I).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) { it.setReturnInt(it.target?.getStoredEnchantLevel(it.getRef(0) as Enchantment) ?: 0) }
                .function("addStoredEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE, Type.I, Type.Z)) {
                    it.setReturnBool(it.target?.addStoredEnchant(
                        it.getRef(0) as Enchantment,
                        it.getInt(1),
                        it.getBool(2)
                    ) ?: false)
                }
                .function("removeStoredEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) { it.setReturnBool(it.target?.removeStoredEnchant(it.getRef(0) as Enchantment) ?: false) }
                .function("hasConflictingStoredEnchant",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE)) { it.setReturnBool(it.target?.hasConflictingStoredEnchant(it.getRef(0) as Enchantment) ?: false) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.meta.FnEnchantmentStorageMeta.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
