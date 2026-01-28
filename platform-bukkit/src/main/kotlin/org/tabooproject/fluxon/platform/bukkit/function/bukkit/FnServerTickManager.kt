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
                .function("isRunningNormally", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isRunningNormally) }
                .function("isStepping", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isStepping) }
                .function("isSprinting", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isSprinting) }
                .function("isFrozen", returns(Type.Z).noParams()) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.isFrozen
                    } else {
                        it.target?.isFrozen(it.getRef(0) as Entity)
                    })
                }
                .function("isFrozen", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnRef(if ((it.argumentCount == 0)) {
                        it.target?.isFrozen
                    } else {
                        it.target?.isFrozen(it.getRef(0) as Entity)
                    })
                }
                .function("tickRate", returnsObject().noParams()) { it.setReturnRef(it.target?.tickRate) }
                .function("setTickRate", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTickRate(it.getFloat(0))) }
                .function("setFrozen", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFrozen(it.getBool(0))) }
                .function("stepGameIfFrozen", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.stepGameIfFrozen(it.getInt(0).toInt())) }
                .function("stopStepping", returnsObject().noParams()) { it.setReturnRef(it.target?.stopStepping()) }
                .function("requestGameToSprint", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.requestGameToSprint(it.getInt(0).toInt())) }
                .function("stopSprinting", returnsObject().noParams()) { it.setReturnRef(it.target?.stopSprinting()) }
                .function("frozenTicksToRun", returnsObject().noParams()) { it.setReturnRef(it.target?.frozenTicksToRun) }
        }
    }
}
