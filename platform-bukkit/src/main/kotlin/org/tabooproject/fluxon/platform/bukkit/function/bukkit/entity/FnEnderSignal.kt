package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.EnderSignal
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.EnderSignal"])
@PlatformSide(Platform.BUKKIT)
object FnEnderSignal {

    val TYPE = Type.fromClass(EnderSignal::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderSignal::class.java)
                .function("targetLocation", returnsObject().noParams()) { it.setReturnRef(it.target?.targetLocation) }
                .function("setTargetLocation", returnsVoid().params(Type.OBJECT)) { it.target?.setTargetLocation(it.getRef(0) as Location) }
                .function("dropItem", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.dropItem ?: false) }
                .function("setDropItem", returnsVoid().params(Type.Z)) { it.target?.setDropItem(it.getBool(0)) }
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsVoid().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("despawnTimer", returns(Type.I).noParams()) { it.setReturnInt(it.target?.despawnTimer ?: 0) }
                .function("setDespawnTimer", returnsVoid().params(Type.I)) { it.target?.setDespawnTimer(it.getInt(0).toInt()) }
        }
    }
}
