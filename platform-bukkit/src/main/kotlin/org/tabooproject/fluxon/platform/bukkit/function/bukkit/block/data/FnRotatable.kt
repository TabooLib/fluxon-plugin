package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.BlockFace
import org.bukkit.block.data.Rotatable
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.Rotatable"])
@PlatformSide(Platform.BUKKIT)
object FnRotatable {

    val TYPE = Type.fromClass(Rotatable::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rotatable::class.java)
                .function("rotation", returns(FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.rotation) }
                .function("setRotation", returnsVoid().params(FnBlockFace.TYPE)) { it.target?.setRotation(it.getRef(0) as BlockFace) }
                .function("setRotation", returnsVoid().params(Type.STRING)) { FnBlockFace.enumValue(it.getString(0))?.let { p0 -> it.target?.setRotation(p0) } }
        }
    }
}
