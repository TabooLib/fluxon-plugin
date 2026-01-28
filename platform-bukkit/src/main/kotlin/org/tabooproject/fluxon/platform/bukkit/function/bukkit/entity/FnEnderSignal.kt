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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.EnderSignal"])
@PlatformSide(Platform.BUKKIT)
object FnEnderSignal {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderSignal::class.java)
                .function("targetLocation", returnsObject().noParams()) { it.target?.targetLocation }
                .function("setTargetLocation", returnsObject().params(Type.OBJECT)) { it.target?.setTargetLocation(it.getRef(0) as Location) }
                .function("dropItem", returnsObject().noParams()) { it.target?.dropItem }
                .function("setDropItem", returnsObject().params(Type.OBJECT)) { it.target?.setDropItem(it.getBool(0)) }
                .function("item", returnsObject().noParams()) { it.target?.item }
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("despawnTimer", returnsObject().noParams()) { it.target?.despawnTimer }
                .function("setDespawnTimer", returnsObject().params(Type.OBJECT)) { it.target?.setDespawnTimer(it.getInt(0).toInt()) }
        }
    }
}
