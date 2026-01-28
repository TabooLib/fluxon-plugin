package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data

import org.bukkit.block.data.Attachable
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.block.data.Attachable"])
@PlatformSide(Platform.BUKKIT)
object FnAttachable {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Attachable::class.java)
                .function("isAttached", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isAttached) }
                .function("setAttached", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAttached(it.getBool(0))) }
        }
    }
}
