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
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type


@Requires(classes = ["org.bukkit.entity.Item"])
@PlatformSide(Platform.BUKKIT)
object FnItem {

    val TYPE = Type.fromClass(Item::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Item::class.java)
                .function("itemStack", returnsObject().noParams()) { it.setReturnRef(it.target?.itemStack) }
                .function("setItemStack", returnsVoid().params(Type.OBJECT)) { it.target?.setItemStack(it.getRef(0) as ItemStack) }
                .function("pickupDelay", returns(Type.I).noParams()) { it.setReturnInt(it.target?.pickupDelay ?: 0) }
                .function("setPickupDelay", returnsVoid().params(Type.I)) { it.target?.setPickupDelay(it.getInt(0).toInt()) }
                .function("setUnlimitedLifetime", returnsVoid().params(Type.Z)) { it.target?.setUnlimitedLifetime(it.getBool(0)) }
                .function("isUnlimitedLifetime", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUnlimitedLifetime ?: false) }
                .function("setOwner", returnsVoid().params(Type.STRING)) { it.target?.setOwner(UUID.fromString(it.getString(0))) }
                .function("owner", returnsObject().noParams()) { it.setReturnRef(it.target?.owner) }
                .function("setThrower", returnsVoid().params(Type.STRING)) { it.target?.setThrower(UUID.fromString(it.getString(0))) }
                .function("thrower", returnsObject().noParams()) { it.setReturnRef(it.target?.thrower) }
        }
    }
}
