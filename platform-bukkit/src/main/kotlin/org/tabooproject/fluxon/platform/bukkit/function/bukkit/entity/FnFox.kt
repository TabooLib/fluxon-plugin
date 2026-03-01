package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Fox
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

@Requires(classes = ["org.bukkit.entity.Fox"])
@PlatformSide(Platform.BUKKIT)
object FnFox {

    val TYPE = Type.fromClass(Fox::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fox::class.java)
                .function("foxType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFoxType.TYPE).noParams()) { it.setReturnRef(it.target?.foxType) }
                .function("setFoxType", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFoxType.TYPE)) { it.target?.setFoxType(it.getRef(0) as Fox.Type)  }
                .function("setFoxType", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnFoxType.enumValue(it.getString(0))?.let { p0 -> it.target?.setFoxType(p0)  } }
                .function("isCrouching", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isCrouching ?: false) }
                .function("setCrouching", returnsVoid().params(Type.Z)) { it.target?.setCrouching(it.getBool(0)) }
                .function("setSleeping", returnsVoid().params(Type.Z)) { it.target?.setSleeping(it.getBool(0)) }
                .function("firstTrustedPlayer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAnimalTamer.TYPE).noParams()) { it.setReturnRef(it.target?.firstTrustedPlayer) }
                .function("setFirstTrustedPlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAnimalTamer.TYPE)) { it.target?.setFirstTrustedPlayer(it.getRef(0) as AnimalTamer) }
                .function("secondTrustedPlayer",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAnimalTamer.TYPE).noParams()) { it.setReturnRef(it.target?.secondTrustedPlayer) }
                .function("setSecondTrustedPlayer",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnAnimalTamer.TYPE)) { it.target?.setSecondTrustedPlayer(it.getRef(0) as AnimalTamer) }
                .function("isFaceplanted", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFaceplanted ?: false) }
        }
    }
}
