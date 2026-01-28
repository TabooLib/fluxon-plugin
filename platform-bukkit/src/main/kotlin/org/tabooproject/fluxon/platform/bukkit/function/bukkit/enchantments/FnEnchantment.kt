package org.tabooproject.fluxon.platform.bukkit.function.bukkit.enchantments

import org.bukkit.NamespacedKey
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.enchantments.Enchantment"])
@PlatformSide(Platform.BUKKIT)
object FnEnchantment {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Enchantment::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.target?.name }
                .function("maxLevel", returnsObject().noParams()) { it.target?.maxLevel }
                .function("startLevel", returnsObject().noParams()) { it.target?.startLevel }
                .function("itemTarget", returnsObject().noParams()) { it.target?.itemTarget }
                .function("isTreasure", returns(Type.Z).noParams()) { it.target?.isTreasure }
                .function("isCursed", returns(Type.Z).noParams()) { it.target?.isCursed }
                .function("conflictsWith", returnsObject().params(Type.OBJECT)) { it.target?.conflictsWith(it.getRef(0) as Enchantment) }
                .function("canEnchantItem", returns(Type.Z).params(Type.OBJECT)) { it.target?.canEnchantItem(it.getRef(0) as ItemStack) }
                // static
                .function("getByKey", returnsObject().params(Type.OBJECT)) { Enchantment.getByKey(it.getRef(0) as NamespacedKey) }
                // static
                .function("getByName", returnsObject().params(Type.OBJECT)) { Enchantment.getByName(it.getString(0)) }
                // static
                .function("values", returnsObject().noParams()) { Enchantment.values() }
        }
    }
}
