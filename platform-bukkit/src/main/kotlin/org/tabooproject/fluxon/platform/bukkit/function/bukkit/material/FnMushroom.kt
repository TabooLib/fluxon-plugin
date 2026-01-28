package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Mushroom
import org.bukkit.material.types.MushroomBlockTexture
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Mushroom"])
@PlatformSide(Platform.BUKKIT)
object FnMushroom {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mushroom::class.java)
                .function("isStem", returns(Type.Z).noParams()) { it.target?.isStem }
                .function("setStem", returnsObject().noParams()) { it.target?.setStem() }
                .function("blockTexture", returnsObject().noParams()) { it.target?.blockTexture }
                .function("setBlockTexture", returnsObject().params(Type.OBJECT)) { it.target?.setBlockTexture(it.getRef(0) as MushroomBlockTexture) }
                .function("isFacePainted", returns(Type.Z).params(Type.OBJECT)) { it.target?.isFacePainted(it.getRef(0) as BlockFace) }
                .function("setFacePainted", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setFacePainted(
                        it.getRef(0) as BlockFace,
                        it.getBool(1)
                    )
                }
                .function("paintedFaces", returnsObject().noParams()) { it.target?.paintedFaces }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
