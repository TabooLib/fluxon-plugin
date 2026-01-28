package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.OminousItemSpawner
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.OminousItemSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnOminousItemSpawner {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OminousItemSpawner::class.java)
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setItem(it.getRef(0) as ItemStack)) }
                .function("spawnItemAfterTicks", returnsObject().noParams()) { it.setReturnRef(it.target?.spawnItemAfterTicks) }
                .function("setSpawnItemAfterTicks", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSpawnItemAfterTicks(it.getInt(0).toLong())) }
        }
    }
}
