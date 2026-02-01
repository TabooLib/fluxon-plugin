package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Material
import org.bukkit.entity.Piglin
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

@Requires(classes = ["org.bukkit.entity.Piglin"])
@PlatformSide(Platform.BUKKIT)
object FnPiglin {

    val TYPE = Type.fromClass(Piglin::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Piglin::class.java)
                .function("isAbleToHunt", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isAbleToHunt ?: false) }
                .function("setIsAbleToHunt", returnsVoid().params(Type.Z)) { it.target?.setIsAbleToHunt(it.getBool(0)) }
                .function("addBarterMaterial", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.addBarterMaterial(it.getRef(0) as Material) == true)
                }
                .function("removeBarterMaterial", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeBarterMaterial(it.getRef(0) as Material) == true)
                }
                .function("addMaterialOfInterest", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.addMaterialOfInterest(it.getRef(0) as Material) == true)
                }
                .function("removeMaterialOfInterest", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removeMaterialOfInterest(it.getRef(0) as Material) == true)
                }
                .function("interestList", returnsObject().noParams()) { it.setReturnRef(it.target?.interestList) }
                .function("barterList", returnsObject().noParams()) { it.setReturnRef(it.target?.barterList) }
        }
    }
}
