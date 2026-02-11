package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TrialSpawner
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.TrialSpawner"])
@PlatformSide(Platform.BUKKIT)
object FnTrialSpawner {

    val TYPE = Type.fromClass(TrialSpawner::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TrialSpawner::class.java)
                .function("trialSpawnerState", returns(FnTrialSpawnerState.TYPE).noParams()) { it.setReturnRef(it.target?.trialSpawnerState) }
                .function("setTrialSpawnerState", returnsVoid().params(FnTrialSpawnerState.TYPE)) {
                    it.target?.setTrialSpawnerState(it.getRef(0) as TrialSpawner.State)
                }
                .function("setTrialSpawnerState", returnsVoid().params(Type.STRING)) {
                    FnTrialSpawnerState.enumValue(it.getString(0))?.let { p0 -> it.target?.setTrialSpawnerState(p0) }
                }
                .function("isOminous", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOminous ?: false) }
                .function("setOminous", returnsVoid().params(Type.Z)) { it.target?.setOminous(it.getBool(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.TrialSpawner.State"])
@PlatformSide(Platform.BUKKIT)
object FnTrialSpawnerState : FnEnumGetter<TrialSpawner.State>() {

    override val enumClass: Class<TrialSpawner.State> = TrialSpawner.State::class.java
}