package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PlayerDeathEvent
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.event.entity.PlayerDeathEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerDeathEvent {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerDeathEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.target?.getEntity() }
                .function("setDeathMessage", returnsObject().params(Type.OBJECT)) { it.target?.setDeathMessage(it.getString(0)) }
                .function("deathMessage", returnsObject().noParams()) { it.target?.deathMessage }
                .function("newExp", returnsObject().noParams()) { it.target?.newExp }
                .function("setNewExp", returnsObject().params(Type.OBJECT)) { it.target?.setNewExp(it.getInt(0).toInt()) }
                .function("newLevel", returnsObject().noParams()) { it.target?.newLevel }
                .function("setNewLevel", returnsObject().params(Type.OBJECT)) { it.target?.setNewLevel(it.getInt(0).toInt()) }
                .function("newTotalExp", returnsObject().noParams()) { it.target?.newTotalExp }
                .function("setNewTotalExp", returnsObject().params(Type.OBJECT)) { it.target?.setNewTotalExp(it.getInt(0).toInt()) }
                .function("keepLevel", returnsObject().noParams()) { it.target?.keepLevel }
                .function("setKeepLevel", returnsObject().params(Type.OBJECT)) { it.target?.setKeepLevel(it.getBool(0)) }
                .function("setKeepInventory", returnsObject().params(Type.OBJECT)) { it.target?.setKeepInventory(it.getBool(0)) }
                .function("keepInventory", returnsObject().noParams()) { it.target?.keepInventory }
        }
    }
}
