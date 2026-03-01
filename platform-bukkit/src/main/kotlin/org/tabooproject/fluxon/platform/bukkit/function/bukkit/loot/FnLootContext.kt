package org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot

import org.bukkit.entity.Entity
import org.bukkit.entity.HumanEntity
import org.bukkit.loot.LootContext
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.loot.LootContext"])
@PlatformSide(Platform.BUKKIT)
object FnLootContext {

    val TYPE = Type.fromClass(LootContext::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootContext::class.java)
                .function("location",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnLocation.TYPE).noParams()) { it.setReturnRef(it.target?.location) }
                .function("luck",returns(Type.F).noParams()) { it.setReturnFloat(it.target?.luck ?: 0f) }
                .function("lootingModifier",returns(Type.I).noParams()) { it.setReturnInt(it.target?.lootingModifier ?: 0) }
                .function("lootedEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.lootedEntity) }
                .function("killer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity.TYPE).noParams()) { it.setReturnRef(it.target?.killer) }
        }
    }
}

@Requires(classes = ["org.bukkit.loot.LootContext\$Builder"])
@PlatformSide(Platform.BUKKIT)
object FnLootContextBuilder {

    val TYPE = Type.fromClass(LootContext.Builder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootContext.Builder::class.java)
                .function("luck", returns(TYPE).params(Type.F)) { it.setReturnRef(it.target?.luck(it.getFloat(0))) }
                .function("lootingModifier", returns(TYPE).params(Type.I)) {
                    it.setReturnRef(it.target?.lootingModifier(it.getInt(0).toInt()))
                }
                .function("lootedEntity", returns(TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) { it.setReturnRef(it.target?.lootedEntity(it.getRef(0) as Entity)) }
                .function("killer", returns(TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnHumanEntity.TYPE)) { it.setReturnRef(it.target?.killer(it.getRef(0) as HumanEntity)) }
                .function("build", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.loot.FnLootContext.TYPE).noParams()) { it.setReturnRef(it.target?.build()) }
        }
    }
}
