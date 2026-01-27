package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Item
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires


@Requires(classes = ["org.bukkit.entity.Item"])
@PlatformSide(Platform.BUKKIT)
object FnItem {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Item::class.java)
                .function("itemStack", 0) { it.target?.itemStack }
                .function("setItemStack", 1) { it.target?.setItemStack(it.getArgument(0) as ItemStack) }
                .function("pickupDelay", 0) { it.target?.pickupDelay }
                .function("setPickupDelay", 1) { it.target?.setPickupDelay(it.getNumber(0).toInt()) }
                .function("setUnlimitedLifetime", 1) { it.target?.setUnlimitedLifetime(it.getBoolean(0)) }
                .function("isUnlimitedLifetime", 0) { it.target?.isUnlimitedLifetime }
                .function("setOwner", 1) { it.target?.setOwner(UUID.fromString(it.getString(0))) }
                .function("owner", 0) { it.target?.owner }
                .function("setThrower", 1) { it.target?.setThrower(UUID.fromString(it.getString(0))) }
                .function("thrower", 0) { it.target?.thrower }
        }
    }
}
