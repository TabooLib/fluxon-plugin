package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.TripwireHook
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.TripwireHook"])
@PlatformSide(Platform.BUKKIT)
object FnTripwireHook {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TripwireHook::class.java)
                .function("isConnected", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isConnected) }
                .function("setConnected", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setConnected(it.getBool(0))) }
                .function("isActivated", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isActivated) }
                .function("setActivated", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setActivated(it.getBool(0))) }
                .function("setFacingDirection", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFacingDirection(it.getRef(0) as BlockFace)) }
                .function("attachedFace", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isPowered) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
