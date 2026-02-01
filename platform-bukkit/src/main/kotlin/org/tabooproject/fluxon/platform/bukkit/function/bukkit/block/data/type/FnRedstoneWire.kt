package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.BlockFace
import org.bukkit.block.data.type.RedstoneWire
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.RedstoneWire"])
@PlatformSide(Platform.BUKKIT)
object FnRedstoneWire {

    val TYPE = Type.fromClass(RedstoneWire::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(RedstoneWire::class.java)
                .function("getFace", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getFace(it.getRef(0) as BlockFace)) }
                .function("setFace", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setFace(
                        it.getRef(0) as BlockFace,
                        it.getRef(1) as RedstoneWire.Connection
                    )
                }
                .function("allowedFaces", returnsObject().noParams()) { it.setReturnRef(it.target?.allowedFaces) }
        }
    }
}
