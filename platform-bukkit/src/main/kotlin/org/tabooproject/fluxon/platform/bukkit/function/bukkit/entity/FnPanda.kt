package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Panda
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Panda"])
@PlatformSide(Platform.BUKKIT)
object FnPanda {

    val TYPE = Type.fromClass(Panda::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Panda::class.java)
                .function("mainGene", returnsObject().noParams()) { it.setReturnRef(it.target?.mainGene) }
                .function("setMainGene", returnsVoid().params(Type.OBJECT)) { it.target?.setMainGene(it.getRef(0) as Panda.Gene) }
                .function("hiddenGene", returnsObject().noParams()) { it.setReturnRef(it.target?.hiddenGene) }
                .function("setHiddenGene", returnsVoid().params(Type.OBJECT)) { it.target?.setHiddenGene(it.getRef(0) as Panda.Gene) }
                .function("isRolling", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRolling ?: false) }
                .function("setRolling", returnsVoid().params(Type.Z)) { it.target?.setRolling(it.getBool(0)) }
                .function("isSneezing", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSneezing ?: false) }
                .function("setSneezing", returnsVoid().params(Type.Z)) { it.target?.setSneezing(it.getBool(0)) }
                .function("isOnBack", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOnBack ?: false) }
                .function("setOnBack", returnsVoid().params(Type.Z)) { it.target?.setOnBack(it.getBool(0)) }
                .function("isEating", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEating ?: false) }
                .function("setEating", returnsVoid().params(Type.Z)) { it.target?.setEating(it.getBool(0)) }
                .function("isScared", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isScared ?: false) }
                .function("unhappyTicks", returns(Type.I).noParams()) { it.setReturnInt(it.target?.unhappyTicks ?: 0) }
        }
    }
}

@Requires(classes = ["org.bukkit.entity.Panda.Gene"])
@PlatformSide(Platform.BUKKIT)
object FnPandaGene {

    val TYPE = Type.fromClass(Panda.Gene::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Panda.Gene::class.java)
                .function("isRecessive", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRecessive ?: false) }
        }
    }
}
