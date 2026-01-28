package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Material
import org.bukkit.entity.Piglin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.Piglin"])
@PlatformSide(Platform.BUKKIT)
object FnPiglin {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Piglin::class.java)
                .function("isAbleToHunt", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAbleToHunt) }
                .function("setIsAbleToHunt", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setIsAbleToHunt(it.getBool(0))) }
                .function("addBarterMaterial", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addBarterMaterial(it.getRef(0) as Material)) }
                .function("removeBarterMaterial", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeBarterMaterial(it.getRef(0) as Material)) }
                .function("addMaterialOfInterest", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addMaterialOfInterest(it.getRef(0) as Material)) }
                .function("removeMaterialOfInterest", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeMaterialOfInterest(it.getRef(0) as Material)) }
                .function("interestList", returnsObject().noParams()) { it.setReturnRef(it.target?.interestList) }
                .function("barterList", returnsObject().noParams()) { it.setReturnRef(it.target?.barterList) }
        }
    }
}
