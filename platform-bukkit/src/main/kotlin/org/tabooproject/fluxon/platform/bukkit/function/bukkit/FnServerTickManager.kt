package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ServerTickManager
import org.bukkit.entity.Entity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.ServerTickManager"])
@PlatformSide(Platform.BUKKIT)
object FnServerTickManager {

    val TYPE = Type.fromClass(ServerTickManager::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerTickManager::class.java)
                .function("isRunningNormally", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRunningNormally ?: false) }
                .function("isStepping", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isStepping ?: false) }
                .function("isSprinting", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSprinting ?: false) }
                .function("isFrozen", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFrozen ?: false) }
                .function("isFrozen",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) {
                    it.setReturnBool(it.target?.isFrozen(it.getRef(0) as Entity) ?: false)
                }
                .function("tickRate", returns(Type.F).noParams()) { it.setReturnFloat(it.target?.tickRate ?: 0.0f) }
                .function("setTickRate", returnsVoid().params(Type.F)) { it.target?.setTickRate(it.getFloat(0)) }
                .function("setFrozen", returnsVoid().params(Type.Z)) { it.target?.setFrozen(it.getBool(0)) }
                .function("stepGameIfFrozen", returnsVoid().params(Type.I)) { it.target?.stepGameIfFrozen(it.getInt(0).toInt()) }
                .function("stopStepping", returnsVoid().noParams()) { it.target?.stopStepping() }
                .function("requestGameToSprint", returnsVoid().params(Type.I)) { it.target?.requestGameToSprint(it.getInt(0).toInt()) }
                .function("stopSprinting", returnsVoid().noParams()) { it.target?.stopSprinting() }
                .function("frozenTicksToRun", returns(Type.I).noParams()) { it.setReturnInt(it.target?.frozenTicksToRun ?: 0) }
        }
    }
}
