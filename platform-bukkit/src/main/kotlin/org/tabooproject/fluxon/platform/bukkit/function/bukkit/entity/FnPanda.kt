package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Panda
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Panda"])
@PlatformSide(Platform.BUKKIT)
object FnPanda {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Panda::class.java)
                .function("mainGene", returnsObject().noParams()) { it.target?.mainGene }
                .function("setMainGene", returnsObject().params(Type.OBJECT)) { it.target?.setMainGene(it.getRef(0) as Panda.Gene) }
                .function("hiddenGene", returnsObject().noParams()) { it.target?.hiddenGene }
                .function("setHiddenGene", returnsObject().params(Type.OBJECT)) { it.target?.setHiddenGene(it.getRef(0) as Panda.Gene) }
                .function("isRolling", returns(Type.Z).noParams()) { it.target?.isRolling }
                .function("setRolling", returnsObject().params(Type.OBJECT)) { it.target?.setRolling(it.getBool(0)) }
                .function("isSneezing", returns(Type.Z).noParams()) { it.target?.isSneezing }
                .function("setSneezing", returnsObject().params(Type.OBJECT)) { it.target?.setSneezing(it.getBool(0)) }
                .function("isOnBack", returns(Type.Z).noParams()) { it.target?.isOnBack }
                .function("setOnBack", returnsObject().params(Type.OBJECT)) { it.target?.setOnBack(it.getBool(0)) }
                .function("isEating", returns(Type.Z).noParams()) { it.target?.isEating }
                .function("setEating", returnsObject().params(Type.OBJECT)) { it.target?.setEating(it.getBool(0)) }
                .function("isScared", returns(Type.Z).noParams()) { it.target?.isScared }
                .function("unhappyTicks", returnsObject().noParams()) { it.target?.unhappyTicks }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Panda.Gene"])
@PlatformSide(Platform.BUKKIT)
object FnPandaGene {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Panda.Gene::class.java)
                .function("isRecessive", returns(Type.Z).noParams()) { it.target?.isRecessive }
        }
    }
}
