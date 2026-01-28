package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AnimalTamer
import org.bukkit.entity.Fox
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Fox"])
@PlatformSide(Platform.BUKKIT)
object FnFox {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Fox::class.java)
                .function("foxType", returnsObject().noParams()) { it.target?.foxType }
                .function("setFoxType", returnsObject().params(Type.OBJECT)) { it.target?.setFoxType(it.getRef(0) as Fox.Type) }
                .function("isCrouching", returns(Type.Z).noParams()) { it.target?.isCrouching }
                .function("setCrouching", returnsObject().params(Type.OBJECT)) { it.target?.setCrouching(it.getBool(0)) }
                .function("setSleeping", returnsObject().params(Type.OBJECT)) { it.target?.setSleeping(it.getBool(0)) }
                .function("firstTrustedPlayer", returnsObject().noParams()) { it.target?.firstTrustedPlayer }
                .function("setFirstTrustedPlayer", returnsObject().params(Type.OBJECT)) { it.target?.setFirstTrustedPlayer(it.getRef(0) as AnimalTamer) }
                .function("secondTrustedPlayer", returnsObject().noParams()) { it.target?.secondTrustedPlayer }
                .function("setSecondTrustedPlayer", returnsObject().params(Type.OBJECT)) { it.target?.setSecondTrustedPlayer(it.getRef(0) as AnimalTamer) }
                .function("isFaceplanted", returns(Type.Z).noParams()) { it.target?.isFaceplanted }
        }
    }
}
