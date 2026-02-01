package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.loot.LootTable
import org.bukkit.loot.Lootable
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

@Requires(classes = ["org.bukkit.loot.Lootable"])
@PlatformSide(Platform.BUKKIT)
object FnLootable {

    val TYPE = Type.fromClass(Lootable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Lootable::class.java)
                .function("setLootTable", returnsVoid().params(Type.OBJECT)) { it.target?.setLootTable(it.getRef(0) as LootTable) }
                .function("lootTable", returnsObject().noParams()) { it.setReturnRef(it.target?.lootTable) }
                .function("setSeed", returnsVoid().params(Type.J)) { it.target?.setSeed(it.getLong(0)) }
                .function("seed", returns(Type.J).noParams()) { it.setReturnLong(it.target?.seed ?: 0L) }
        }
    }
}
