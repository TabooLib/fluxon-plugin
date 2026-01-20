package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Vault
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnVault {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Vault::class.java)
                .function("trialSpawnerState", 0) { it.target?.trialSpawnerState }
                .function(
                    "setTrialSpawnerState",
                    1
                ) { it.target?.setTrialSpawnerState(it.getArgument(0) as Vault.State) }
                .function("isOminous", 0) { it.target?.isOminous }
                .function("setOminous", 1) { it.target?.setOminous(it.getBoolean(0)) }
        }
    }
}
