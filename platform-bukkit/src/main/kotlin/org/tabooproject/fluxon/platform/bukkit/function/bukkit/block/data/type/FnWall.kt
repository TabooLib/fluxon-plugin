package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.Wall
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.type.Wall"])
@PlatformSide(Platform.BUKKIT)
object FnWall {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Wall::class.java)
                .function("isUp", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isUp) }
                .function("setUp", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setUp(it.getBool(0))) }
                .function("getHeight", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getHeight(it.getRef(0) as BlockFace)) }
                .function("setHeight", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setHeight(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as Wall.Height
                    ))
                }
        }
    }
}
