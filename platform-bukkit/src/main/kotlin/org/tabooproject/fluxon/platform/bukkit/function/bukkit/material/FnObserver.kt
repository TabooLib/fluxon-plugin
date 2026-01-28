package org.tabooproject.fluxon.platform.bukkit.function.bukkit.material

import org.bukkit.block.BlockFace
import org.bukkit.material.Observer
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.material.Observer"])
@PlatformSide(Platform.BUKKIT)
object FnObserver {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Observer::class.java)
                .function("isPowered", returns(Type.Z).noParams()) { it.target?.isPowered }
                .function("setFacingDirection", returnsObject().params(Type.OBJECT)) { it.target?.setFacingDirection(it.getRef(0) as BlockFace) }
                .function("facing", returnsObject().noParams()) { it.target?.facing }
                .function("toString", returns(Type.STRING).noParams()) { it.target?.toString() }
                .function("clone", returnsObject().noParams()) { it.target?.clone() }
        }
    }
}
