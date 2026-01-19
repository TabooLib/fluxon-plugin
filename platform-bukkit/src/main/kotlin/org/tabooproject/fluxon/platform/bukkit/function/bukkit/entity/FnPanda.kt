package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Panda
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPanda {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Panda::class.java)
                .function("mainGene", 0) { it.target?.mainGene }
                .function("setMainGene", 1) { it.target?.setMainGene(it.getArgument(0) as Panda.Gene) }
                .function("hiddenGene", 0) { it.target?.hiddenGene }
                .function("setHiddenGene", 1) { it.target?.setHiddenGene(it.getArgument(0) as Panda.Gene) }
                .function("isRolling", 0) { it.target?.isRolling }
                .function("setRolling", 1) { it.target?.setRolling(it.getBoolean(0)) }
                .function("isSneezing", 0) { it.target?.isSneezing }
                .function("setSneezing", 1) { it.target?.setSneezing(it.getBoolean(0)) }
                .function("isOnBack", 0) { it.target?.isOnBack }
                .function("setOnBack", 1) { it.target?.setOnBack(it.getBoolean(0)) }
                .function("isEating", 0) { it.target?.isEating }
                .function("setEating", 1) { it.target?.setEating(it.getBoolean(0)) }
                .function("isScared", 0) { it.target?.isScared }
                .function("unhappyTicks", 0) { it.target?.unhappyTicks }

            registerExtension(Panda.Gene::class.java)
                .function("isRecessive", 0) { it.target?.isRecessive }
        }
    }
}
