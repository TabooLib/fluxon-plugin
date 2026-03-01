package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block

import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.block.Vault"])
@PlatformSide(Platform.BUKKIT)
object FnVault {

    val TYPE = Type.fromClass(org.bukkit.block.Vault::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(org.bukkit.block.Vault::class.java)
                // .function("getActivationRange", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.getActivationRange() ?: 0.0) }
                // .function("setActivationRange", returnsVoid().params(Type.D)) { it.target?.setActivationRange(it.getDouble(0)) }
                // .function("getDeactivationRange", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.getDeactivationRange() ?: 0.0) }
                // .function("setDeactivationRange", returnsVoid().params(Type.D)) { it.target?.setDeactivationRange(it.getDouble(0)) }
                // .function("getKeyItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.getKeyItem()) }
                // .function("setKeyItem", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setKeyItem(it.getRef(0) as org.bukkit.inventory.ItemStack) }
                // .function("getLootTable", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable.TYPE).noParams()) { it.setReturnRef(it.target?.getLootTable()) }
                // .function("setLootTable", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable.TYPE)) { it.target?.setLootTable(it.getRef(0) as org.bukkit.loot.LootTable) }
                // .function("getDisplayedLootTable", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable.TYPE).noParams()) { it.setReturnRef(it.target?.getDisplayedLootTable()) }
                // .function("setDisplayedLootTable", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootTable.TYPE)) { it.target?.setDisplayedLootTable(it.getRef(0) as org.bukkit.loot.LootTable) }
                // .function("getNextStateUpdateTime", returns(Type.J).noParams()) { it.setReturnLong(it.target?.getNextStateUpdateTime() ?: 0L) }
                // .function("setNextStateUpdateTime", returnsVoid().params(Type.J)) { it.target?.setNextStateUpdateTime(it.getLong(0).toLong()) }
                // .function("getRewardedPlayers", returns(org.tabooproject.fluxon.util.StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.getRewardedPlayers()) }
                // .function("addRewardedPlayer", returns(Type.Z).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnBool(it.target?.addRewardedPlayer(it.getRef(0) as java.util.UUID) ?: false) }
                // .function("removeRewardedPlayer", returns(Type.Z).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnBool(it.target?.removeRewardedPlayer(it.getRef(0) as java.util.UUID) ?: false) }
                // .function("hasRewardedPlayer", returns(Type.Z).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnBool(it.target?.hasRewardedPlayer(it.getRef(0) as java.util.UUID) ?: false) }
                // .function("getConnectedPlayers", returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.getConnectedPlayers()) }
                // .function("hasConnectedPlayer", returns(Type.Z).params(org.tabooproject.fluxon.util.StandardTypes.UUID)) { it.setReturnBool(it.target?.hasConnectedPlayer(it.getRef(0) as java.util.UUID) ?: false) }
                // .function("getDisplayedItem", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE).noParams()) { it.setReturnRef(it.target?.getDisplayedItem()) }
                // .function("setDisplayedItem", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnItemStack.TYPE)) { it.target?.setDisplayedItem(it.getRef(0) as org.bukkit.inventory.ItemStack) }
        }
    }
}
