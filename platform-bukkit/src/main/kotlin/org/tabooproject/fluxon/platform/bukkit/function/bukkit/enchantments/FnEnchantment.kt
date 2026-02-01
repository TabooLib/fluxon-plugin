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

    val TYPE = Type.fromClass(Enchantment::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Enchantment::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("maxLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxLevel ?: 0) }
                .function("startLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.startLevel ?: 0) }
                .function("itemTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.itemTarget) }
                .function("isTreasure", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isTreasure ?: false) }
                .function("isCursed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCursed ?: false) }
                .function("conflictsWith", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.conflictsWith(it.getRef(0) as Enchantment) ?: false) }
                .function("canEnchantItem", returns(Type.Z).params(Type.OBJECT)) { it.setReturnBool(it.target?.canEnchantItem(it.getRef(0) as ItemStack) ?: false) }
                // static
                .function("getByKey", returnsObject().params(Type.OBJECT)) { it.setReturnRef(Enchantment.getByKey(it.getRef(0) as NamespacedKey)) }
                // static
                .function("getByName", returnsObject().params(Type.STRING)) { it.setReturnRef(Enchantment.getByName(it.getString(0))) }
                // static
                .function("values", returnsObject().noParams()) { it.setReturnRef(Enchantment.values()) }
        }
    }
}
