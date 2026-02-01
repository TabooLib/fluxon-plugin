package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.entity

import org.bukkit.event.entity.PlayerDeathEvent
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

@Requires(classes = ["org.bukkit.event.entity.PlayerDeathEvent"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerDeathEvent {

    val TYPE = Type.fromClass(PlayerDeathEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerDeathEvent::class.java)
                .function("entity", returnsObject().noParams()) { it.setReturnRef(it.target?.getEntity()) }
                .function("setDeathMessage", returnsVoid().params(Type.STRING)) { it.target?.setDeathMessage(it.getString(0)) }
                .function("deathMessage", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.deathMessage) }
                .function("newExp", returns(Type.I).noParams()) { it.setReturnInt(it.target?.newExp ?: 0) }
                .function("setNewExp", returnsVoid().params(Type.I)) { it.target?.setNewExp(it.getInt(0).toInt()) }
                .function("newLevel", returns(Type.I).noParams()) { it.setReturnInt(it.target?.newLevel ?: 0) }
                .function("setNewLevel", returnsVoid().params(Type.I)) { it.target?.setNewLevel(it.getInt(0).toInt()) }
                .function("newTotalExp", returns(Type.I).noParams()) { it.setReturnInt(it.target?.newTotalExp ?: 0) }
                .function("setNewTotalExp", returnsVoid().params(Type.I)) { it.target?.setNewTotalExp(it.getInt(0).toInt()) }
                .function("keepLevel", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.keepLevel ?: false) }
                .function("setKeepLevel", returnsVoid().params(Type.Z)) { it.target?.setKeepLevel(it.getBool(0)) }
                .function("setKeepInventory", returnsVoid().params(Type.Z)) { it.target?.setKeepInventory(it.getBool(0)) }
                .function("keepInventory", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.keepInventory ?: false) }
        }
    }
}
