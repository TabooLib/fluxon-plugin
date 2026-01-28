package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.TrapDoor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.TrapDoor"])
@PlatformSide(Platform.BUKKIT)
object FnTrapDoor {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TrapDoor::class.java)
                .function("isOpen", returns(Type.Z).noParams()) { it.target?.isOpen }
                .function("setOpen", returnsObject().params(Type.OBJECT)) { it.target?.setOpen(it.getBool(0)) }
                .function("isInverted", returns(Type.Z).noParams()) { it.target?.isInverted }
                .function("setInverted", returnsObject().params(Type.OBJECT)) { it.target?.setInverted(it.getBool(0)) }
                .function("attachedFace", returnsObject().noParams()) { it.target?.attachedFace }
                .function("setFacingDirection", returnsObject().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
