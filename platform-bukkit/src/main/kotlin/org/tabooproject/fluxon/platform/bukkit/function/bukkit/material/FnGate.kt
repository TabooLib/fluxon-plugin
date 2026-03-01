package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Gate
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid

@Requires(classes = ["org.bukkit.material.Gate"])
@PlatformSide(Platform.BUKKIT)
object FnGate {

    val TYPE = Type.fromClass(Gate::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Gate::class.java)
                .function("setFacingDirection",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockFace.TYPE).noParams()) { it.setReturnRef(it.target?.facing) }
                .function("isOpen", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isOpen ?: false) }
                .function("setOpen", returnsVoid().params(Type.Z)) { it.target?.setOpen(it.getBool(0)) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("clone", returns(TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
