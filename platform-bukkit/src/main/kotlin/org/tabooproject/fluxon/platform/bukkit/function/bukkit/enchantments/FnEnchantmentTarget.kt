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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.enchantments.EnchantmentTarget"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantmentTarget {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentTarget::class.java)
                .function("includes", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is Material -> it.target?.includes(var1)
                        is ItemStack -> it.target?.includes(var1)
                        else -> throw IllegalArgumentException("参数必须是 Material 或 ItemStack 类型")
                    })
                }
        }
    }
}
