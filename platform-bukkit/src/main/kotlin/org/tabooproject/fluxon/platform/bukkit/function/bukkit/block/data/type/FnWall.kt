package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.Wall
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Wall"])
@PlatformSide(Platform.BUKKIT)
object FnWall {

    val TYPE = Type.fromClass(Wall::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wall::class.java)
                .function("isUp", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isUp ?: false) }
                .function("setUp", returnsVoid().params(Type.Z)) { it.target?.setUp(it.getBool(0)) }
                .function("getHeight", returns(FnWallHeight.TYPE).params(FnBlockFace.TYPE)) { it.setReturnRef(it.target?.getHeight(it.getRef(0) as BlockFace)) }
                .function("getHeight", returns(FnWallHeight.TYPE).params(Type.STRING)) {
                    FnBlockFace.enumValue(it.getString(0))?.let { p0 ->
                        it.setReturnRef(it.target?.getHeight(
                            p0))
                    }
                }
                .function("setHeight", returnsVoid().params(FnBlockFace.TYPE, FnWallHeight.TYPE)) {
                    it.target?.setHeight(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as Wall.Height
                    )
                }
                .function("setHeight", returnsVoid().params(FnBlockFace.TYPE, Type.STRING)) {
                    FnWallHeight.enumValue(it.getString(1))?.let { p1 ->
                        it.target?.setHeight(
                            it.getRef(0) as BlockFace,
                            p1
                        )
                    }
                }
                .function("setHeight", returnsVoid().params(Type.STRING, FnWallHeight.TYPE)) {
                    FnBlockFace.enumValue(it.getString(0))?.let { p0 ->
                        it.target?.setHeight(
                            p0,
                            it.getRef(1) as Wall.Height
                        )
                    }
                }
                .function("setHeight", returnsVoid().params(Type.STRING, Type.STRING)) {
                    val face = FnBlockFace.enumValue(it.getString(0)) ?: return@function
                    val height = FnWallHeight.enumValue(it.getString(1)) ?: return@function
                    it.target?.setHeight(face, height)
                }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.Wall.Height"])
@PlatformSide(Platform.BUKKIT)
object FnWallHeight : FnEnumGetter<Wall.Height>() {

    override val enumClass: Class<Wall.Height> = Wall.Height::class.java
}
