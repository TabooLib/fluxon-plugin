package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.inventory.Inventory
import org.bukkit.loot.LootContext
import org.bukkit.loot.LootTable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.loot.LootTable"])
@PlatformSide(Platform.BUKKIT)
object FnLootTable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootTable::class.java)
                .function("populateLoot", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.populateLoot(
                        it.getRef(0) as Random,
                        it.getRef(1) as LootContext
                    ))
                }
                .function("fillInventory", returnsObject().params(Type.OBJECT, Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.fillInventory(
                        it.getRef(0) as Inventory,
                        it.getRef(1) as Random,
                        it.getRef(2) as LootContext
                    ))
                }
        }
    }
}
