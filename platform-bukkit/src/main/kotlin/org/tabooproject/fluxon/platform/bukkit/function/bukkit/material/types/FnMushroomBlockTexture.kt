package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.types

import org.bukkit.block.BlockFace
import org.bukkit.material.types.MushroomBlockTexture
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.material.types.MushroomBlockTexture"])
@PlatformSide(Platform.BUKKIT)
object FnMushroomBlockTexture : org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter<org.bukkit.material.types.MushroomBlockTexture>() {

    override val enumClass: Class<org.bukkit.material.types.MushroomBlockTexture> = org.bukkit.material.types.MushroomBlockTexture::class.java


    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(MushroomBlockTexture::class.java)
                .function("data", returns(Type.I).noParams()) { it.setReturnInt(it.target?.data?.toInt() ?: 0) }
                .function("capFace", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.capFace) }
                // static
                .function("getByData", returns(TYPE).params(Type.I)) { it.setReturnRef(MushroomBlockTexture.getByData(it.getInt(0).toByte())) }
                // static
                .function("getCapByFace", returns(TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE)) { it.setReturnRef(MushroomBlockTexture.getCapByFace(it.getRef(0) as BlockFace)) }
        }
    }
}
