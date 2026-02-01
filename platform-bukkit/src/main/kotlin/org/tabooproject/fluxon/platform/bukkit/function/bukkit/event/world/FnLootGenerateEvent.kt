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
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.entity) }
                .function("inventoryHolder", returnsObject().noParams()) { it.setReturnRef(it.target?.inventoryHolder) }
                .function("lootTable", returnsObject().noParams()) { it.setReturnRef(it.target?.lootTable) }
                .function("lootContext", returnsObject().noParams()) { it.setReturnRef(it.target?.lootContext) }
                .function("setLoot", returnsVoid().params(Type.OBJECT)) { it.target?.setLoot(it.getRef(0) as Collection<ItemStack>) }
                .function("loot", returnsObject().noParams()) { it.setReturnRef(it.target?.loot) }
                .function("isPlugin", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPlugin ?: false) }
                .function("setCancelled", returnsVoid().params(Type.Z)) { it.target?.setCancelled(it.getBool(0)) }
                .function("isCancelled", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCancelled ?: false) }
                .function("handlers", returnsObject().noParams()) { it.setReturnRef(it.target?.handlers) }
                // static
                .function("handlerList", returnsObject().noParams()) { it.setReturnRef(LootGenerateEvent.getHandlerList()) }
        }
    }
}
