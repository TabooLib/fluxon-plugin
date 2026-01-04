package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Item
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*

object FnItem {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Item::class.java)
                // 只读属性
                .function("owner", 0) { it.target?.owner }
                .function("thrower", 0) { it.target?.thrower }

                // 可读写属性
                .function("itemStack", 0) { it.target?.itemStack }
                .syncFunction("setItemStack", 1) { it.target?.apply { itemStack = it.getArgument(0) as ItemStack } }
                .function("pickupDelay", 0) { it.target?.pickupDelay }
                .syncFunction("setPickupDelay", 1) { it.target?.apply { pickupDelay = it.getNumber(0).toInt() } }
                .syncFunction("setOwner", 1) { it.target?.apply { owner = it.getArgument(0) as? UUID } }
                .syncFunction("setThrower", 1) { it.target?.apply { thrower = it.getArgument(0) as? UUID } }
                .function("isUnlimitedLifetime", 0) { it.target?.isUnlimitedLifetime }
                .syncFunction("setUnlimitedLifetime", 1) { it.target?.apply { isUnlimitedLifetime = it.getBoolean(0) } }
        }
    }
}
