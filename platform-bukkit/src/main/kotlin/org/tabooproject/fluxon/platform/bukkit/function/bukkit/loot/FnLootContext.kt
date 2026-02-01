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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.loot.LootContext"])
@PlatformSide(Platform.BUKKIT)
object FnLootContext {

    val TYPE = Type.fromClass(LootContext::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootContext::class.java)
                .function("location", returnsObject().noParams()) { it.setReturnRef(it.target?.location) }
                .function("luck", returnsObject().noParams()) { it.setReturnRef(it.target?.luck) }
                .function("lootingModifier", returnsObject().noParams()) { it.setReturnRef(it.target?.lootingModifier) }
                .function("lootedEntity", returnsObject().noParams()) { it.setReturnRef(it.target?.lootedEntity) }
                .function("killer", returnsObject().noParams()) { it.setReturnRef(it.target?.killer) }
        }
    }
}

@Requires(classes = ["org.bukkit.loot.LootContext.Builder"])
@PlatformSide(Platform.BUKKIT)
object FnLootContextBuilder {

    val TYPE = Type.fromClass(LootContext.Builder::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(LootContext.Builder::class.java)
                .function("luck", returnsObject().params(Type.F)) { it.setReturnRef(it.target?.luck(it.getFloat(0))) }
                .function("lootingModifier", returnsObject().params(Type.I)) {
                    it.setReturnRef(it.target?.lootingModifier(it.getInt(0).toInt()))
                }
                .function("lootedEntity", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.lootedEntity(it.getRef(0) as Entity)) }
                .function("killer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.killer(it.getRef(0) as HumanEntity)) }
                .function("build", returnsObject().noParams()) { it.setReturnRef(it.target?.build()) }
        }
    }
}
