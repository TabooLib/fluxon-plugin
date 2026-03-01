package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.block.data.BlockData
import org.bukkit.entity.Enderman
import org.bukkit.entity.Entity
import org.bukkit.material.MaterialData
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

@Requires(classes = ["org.bukkit.entity.Enderman"])
@PlatformSide(Platform.BUKKIT)
object FnEnderman {

    val TYPE = Type.fromClass(Enderman::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Enderman::class.java)
                .function("carriedMaterial",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE).noParams()) { it.setReturnRef(it.target?.carriedMaterial) }
                .function("setCarriedMaterial",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.FnMaterialData.TYPE)) { it.target?.setCarriedMaterial(it.getRef(0) as MaterialData) }
                .function("carriedBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE).noParams()) { it.setReturnRef(it.target?.carriedBlock) }
                .function("setCarriedBlock",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.FnBlockData.TYPE)) { it.target?.setCarriedBlock(it.getRef(0) as BlockData) }
                .function("teleport", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.teleport() == true) }
                .function("teleportTowards",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE)) {
                    it.setReturnBool(it.target?.teleportTowards(it.getRef(0) as Entity) == true)
                }
        }
    }
}
