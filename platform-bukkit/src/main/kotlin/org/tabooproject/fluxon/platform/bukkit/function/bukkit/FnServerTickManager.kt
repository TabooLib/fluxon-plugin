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

@Requires(classes = ["org.bukkit.ServerTickManager"])
@PlatformSide(Platform.BUKKIT)
object FnServerTickManager {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ServerTickManager::class.java)
                .function("isRunningNormally", returns(Type.Z).noParams()) { it.target?.isRunningNormally }
                .function("isStepping", returns(Type.Z).noParams()) { it.target?.isStepping }
                .function("isSprinting", returns(Type.Z).noParams()) { it.target?.isSprinting }
                .function("isFrozen", returns(Type.Z).noParams()) {
                    if ((it.argumentCount == 0)) {
                        it.target?.isFrozen
                    } else {
                        it.target?.isFrozen(it.getRef(0) as Entity)
                    }
                }
                .function("isFrozen", returns(Type.Z).params(Type.OBJECT)) {
                    if ((it.argumentCount == 0)) {
                        it.target?.isFrozen
                    } else {
                        it.target?.isFrozen(it.getRef(0) as Entity)
                    }
                }
                .function("tickRate", returnsObject().noParams()) { it.target?.tickRate }
                .function("setTickRate", returnsObject().params(Type.OBJECT)) { it.target?.setTickRate(it.getFloat(0)) }
                .function("setFrozen", returnsObject().params(Type.OBJECT)) { it.target?.setFrozen(it.getBool(0)) }
                .function("stepGameIfFrozen", returnsObject().params(Type.OBJECT)) { it.target?.stepGameIfFrozen(it.getInt(0).toInt()) }
                .function("stopStepping", returnsObject().noParams()) { it.target?.stopStepping() }
                .function("requestGameToSprint", returnsObject().params(Type.OBJECT)) { it.target?.requestGameToSprint(it.getInt(0).toInt()) }
                .function("stopSprinting", returnsObject().noParams()) { it.target?.stopSprinting() }
                .function("frozenTicksToRun", returnsObject().noParams()) { it.target?.frozenTicksToRun }
        }
    }
}
