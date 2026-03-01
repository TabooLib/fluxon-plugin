package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.world

import org.bukkit.event.world.LootGenerateEvent
import org.bukkit.inventory.ItemStack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.world.LootGenerateEvent"])
@PlatformSide(Platform.BUKKIT)
object FnLootGenerateEvent {

    val TYPE = Type.fromClass(LootGenerateEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootGenerateEvent::class.java)
                .function("entity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
                .function("inventoryHolder",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnInventoryHolder.TYPE).noParams()) { it.setReturnRef(it.target?.inventoryHolder) }
                .function("lootTable",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable.TYPE).noParams()) { it.setReturnRef(it.target?.lootTable) }
                .function("lootContext",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootContext.TYPE).noParams()) { it.setReturnRef(it.target?.lootContext) }
                .function("setLoot",returnsVoid().params(org.tabooproject.fluxon.util.StandardTypes.COLLECTION)) { it.target?.setLoot(it.getRef(0) as Collection<ItemStack>) }
                .function("loot",returns(Type.LIST).noParams()) { it.setReturnRef(it.target?.loot) }
                .function("isPlugin", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlugin ?: false) }
                .function("handlers",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.FnHandlerList.TYPE).noParams()) { it.setReturnRef(LootGenerateEvent.getHandlerList()) }
        }
    }
}
