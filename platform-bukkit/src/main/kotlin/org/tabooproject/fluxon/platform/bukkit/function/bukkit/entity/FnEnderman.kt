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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Enderman"])
@PlatformSide(Platform.BUKKIT)
object FnEnderman {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Enderman::class.java)
                .function("carriedMaterial", returnsObject().noParams()) { it.target?.carriedMaterial }
                .function("setCarriedMaterial", returnsObject().params(Type.OBJECT)) { it.target?.setCarriedMaterial(it.getRef(0) as MaterialData) }
                .function("carriedBlock", returnsObject().noParams()) { it.target?.carriedBlock }
                .function("setCarriedBlock", returnsObject().params(Type.OBJECT)) { it.target?.setCarriedBlock(it.getRef(0) as BlockData) }
                .function("teleport", returnsObject().noParams()) { it.target?.teleport() }
                .function("teleportTowards", returnsObject().params(Type.OBJECT)) { it.target?.teleportTowards(it.getRef(0) as Entity) }
        }
    }
}
