package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.enchantments.EnchantmentWrapper
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.enchantments.EnchantmentWrapper"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantmentWrapper {

    val TYPE = Type.fromClass(EnchantmentWrapper::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnchantmentWrapper::class.java)
                .function("enchantment",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments.FnEnchantment.TYPE).noParams()) { it.setReturnRef(it.target?.enchantment) }
        }
    }
}
