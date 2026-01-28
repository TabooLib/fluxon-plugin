package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Location
import org.bukkit.entity.EnderCrystal
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.EnderCrystal"])
@PlatformSide(Platform.BUKKIT)
object FnEnderCrystal {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(EnderCrystal::class.java)
                .function("isShowingBottom", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isShowingBottom) }
                .function("setShowingBottom", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setShowingBottom(it.getBool(0))) }
                .function("beamTarget", returnsObject().noParams()) { it.setReturnRef(it.target?.beamTarget) }
                .function("setBeamTarget", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBeamTarget(it.getRef(0) as Location)) }
        }
    }
}
