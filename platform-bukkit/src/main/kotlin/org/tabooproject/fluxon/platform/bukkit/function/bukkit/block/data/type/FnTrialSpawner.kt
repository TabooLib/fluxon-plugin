package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TrialSpawner
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.TrialSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnTrialSpawner {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TrialSpawner::class.java)
                .function("trialSpawnerState", returnsObject().noParams()) { it.target?.trialSpawnerState }
                .function("setTrialSpawnerState", returnsObject().params(Type.OBJECT)) { it.target?.setTrialSpawnerState(it.getRef(0) as TrialSpawner.State) }
                .function("isOminous", returns(Type.Z).noParams()) { it.target?.isOminous }
                .function("setOminous", returnsObject().params(Type.OBJECT)) { it.target?.setOminous(it.getBool(0)) }
        }
    }
}
