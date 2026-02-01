package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.OminousItemSpawner
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

@Requires(classes = ["org.bukkit.entity.OminousItemSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnOminousItemSpawner {

    val TYPE = Type.fromClass(OminousItemSpawner::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(OminousItemSpawner::class.java)
                .function("item", returnsObject().noParams()) { it.setReturnRef(it.target?.item) }
                .function("setItem", returnsVoid().params(Type.OBJECT)) { it.target?.setItem(it.getRef(0) as ItemStack) }
                .function("spawnItemAfterTicks", returns(Type.J).noParams()) { it.setReturnLong(it.target?.spawnItemAfterTicks ?: 0L) }
                .function("setSpawnItemAfterTicks", returnsVoid().params(Type.J)) { it.target?.setSpawnItemAfterTicks(it.getLong(0)) }
        }
    }
}
