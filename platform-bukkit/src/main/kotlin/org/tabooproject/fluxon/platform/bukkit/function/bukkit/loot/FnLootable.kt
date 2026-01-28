package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.loot.LootTable
import org.bukkit.loot.Lootable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.loot.Lootable"])
@PlatformSide(Platform.BUKKIT)
object FnLootable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lootable::class.java)
                .function("setLootTable", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setLootTable(it.getRef(0) as LootTable)) }
                .function("lootTable", returnsObject().noParams()) { it.setReturnRef(it.target?.lootTable) }
                .function("setSeed", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSeed(it.getInt(0).toLong())) }
                .function("seed", returnsObject().noParams()) { it.setReturnRef(it.target?.seed) }
        }
    }
}
