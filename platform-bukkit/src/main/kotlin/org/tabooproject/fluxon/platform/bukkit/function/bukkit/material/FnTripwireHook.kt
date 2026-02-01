package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.TripwireHook
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

@Requires(classes = ["org.bukkit.material.TripwireHook"])
@PlatformSide(Platform.BUKKIT)
object FnTripwireHook {

    val TYPE = Type.fromClass(TripwireHook::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TripwireHook::class.java)
                .function("isConnected", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isConnected ?: false) }
                .function("setConnected", returnsVoid().params(Type.Z)) { it.target?.setConnected(it.getBool(0)) }
                .function("isActivated", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isActivated ?: false) }
                .function("setActivated", returnsVoid().params(Type.Z)) { it.target?.setActivated(it.getBool(0)) }
                .function("setFacingDirection", returnsVoid().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("attachedFace", returnsObject().noParams()) { it.setReturnRef(it.target?.attachedFace) }
                .function("isPowered", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isPowered ?: false) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
        }
    }
}
