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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns


@Requires(classes = ["org.bukkit.entity.Item"])
@PlatformSide(Platform.BUKKIT)
object FnItem {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Item::class.java)
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("setItemStack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItemStack(it.getRef(0) as ItemStack)) }
                .function("pickupDelay", returnsObject().noParams()) { it.setReturnRef(it.target?.pickupDelay) }
                .function("setPickupDelay", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPickupDelay(it.getInt(0).toInt())) }
                .function("setUnlimitedLifetime", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUnlimitedLifetime(it.getBool(0))) }
                .function("isUnlimitedLifetime", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isUnlimitedLifetime) }
                .function("setOwner", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setOwner(UUID.fromString(it.getString(0)))) }
                .function("owner", returnsObject().noParams()) { it.setReturnRef(it.target?.owner) }
                .function("setThrower", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setThrower(UUID.fromString(it.getString(0)))) }
                .function("thrower", returnsObject().noParams()) { it.setReturnRef(it.target?.thrower) }
        }
    }
}
