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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Mushroom"])
@PlatformSide(Platform.BUKKIT)
object FnMushroom {

    val TYPE = Type.fromClass(Mushroom::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Mushroom::class.java)
                .function("isStem", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isStem ?: false) }
                .function("setStem", returnsVoid().noParams()) { it.target?.setStem() }
                .function("blockTexture",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.types.FnMushroomBlockTexture.TYPE).noParams()) { it.setReturnRef(it.target?.blockTexture) }
                .function("setBlockTexture",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.material.types.FnMushroomBlockTexture.TYPE)) { it.target?.setBlockTexture(it.getRef(0) as MushroomBlockTexture) }
                .function("isFacePainted",returns(Type.Z).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE)) {
                    it.setReturnBool(it.target?.isFacePainted(it.getRef(0) as BlockFace) ?: false)
                }
                .function("setFacePainted",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE, Type.Z)) {
                    it.target?.setFacePainted(
                        it.getRef(0) as BlockFace,
                        it.getBool(1)
                    )
                }
                .function("paintedFaces",returns(org.tabooproject.fluxon.util.StandardTypes.SET).noParams()) { it.setReturnRef(it.target?.paintedFaces) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
