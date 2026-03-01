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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.loot.LootTable"])
@PlatformSide(Platform.BUKKIT)
object FnLootTable {

    val TYPE = Type.fromClass(LootTable::class.java)
    private val RANDOM = Type.fromClass(Random::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootTable::class.java)
                .function("populateLoot",returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).params(RANDOM, org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootContext.TYPE)) {
                    it.setReturnRef(it.target?.populateLoot(
                        it.getRef(0) as Random,
                        it.getRef(1) as LootContext
                    ))
                }
                .function("fillInventory", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventory.TYPE, RANDOM, org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootContext.TYPE)) {
                    it.target?.fillInventory(
                        it.getRef(0) as Inventory,
                        it.getRef(1) as Random,
                        it.getRef(2) as LootContext
                    )
                }
        }
    }
}
