package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Material
import org.bukkit.entity.Piglin
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnPiglin {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Piglin::class.java)
                .function("isAbleToHunt", 0) { it.target?.isAbleToHunt }
                .function("setIsAbleToHunt", 1) { it.target?.setIsAbleToHunt(it.getBoolean(0)) }
                .function("addBarterMaterial", 1) { it.target?.addBarterMaterial(it.getArgument(0) as Material) }
                .function("removeBarterMaterial", 1) { it.target?.removeBarterMaterial(it.getArgument(0) as Material) }
                .function(
                    "addMaterialOfInterest",
                    1
                ) { it.target?.addMaterialOfInterest(it.getArgument(0) as Material) }
                .function(
                    "removeMaterialOfInterest",
                    1
                ) { it.target?.removeMaterialOfInterest(it.getArgument(0) as Material) }
                .function("interestList", 0) { it.target?.interestList }
                .function("barterList", 0) { it.target?.barterList }
        }
    }
}
