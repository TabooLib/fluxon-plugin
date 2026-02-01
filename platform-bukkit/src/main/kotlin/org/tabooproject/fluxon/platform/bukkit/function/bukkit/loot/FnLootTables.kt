package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.loot.LootTables
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.loot.LootTables"])
@PlatformSide(Platform.BUKKIT)
object FnLootTables {

    val TYPE = Type.fromClass(LootTables::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootTables::class.java)
                .function("key", returnsObject().noParams()) { it.setReturnRef(it.target?.key) }
                .function("lootTable", returnsObject().noParams()) { it.setReturnRef(it.target?.lootTable) }
        }
    }
}
