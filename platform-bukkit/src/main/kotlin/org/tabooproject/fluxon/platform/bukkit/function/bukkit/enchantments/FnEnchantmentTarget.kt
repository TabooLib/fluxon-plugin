package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.Material
import org.bukkit.enchantments.EnchantmentTarget
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.enchantments.EnchantmentTarget"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantmentTarget : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.enchantments.EnchantmentTarget>() {

    override val enumClass: Class<org.bukkit.enchantments.EnchantmentTarget> = org.bukkit.enchantments.EnchantmentTarget::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentTarget::class.java)
                .function("includes", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.TYPE)) { it.setReturnBool(it.target?.includes(it.getRef(0) as Material) ?: false) }
                .function("includes", returns(Type.Z).params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnMaterial.enumValue(it.getString(0))?.let { p0 -> it.setReturnBool(it.target?.includes(p0) ?: false) } }
                .function("includes", returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.setReturnBool(it.target?.includes(it.getRef(0) as ItemStack) ?: false) }
        }
    }
}
