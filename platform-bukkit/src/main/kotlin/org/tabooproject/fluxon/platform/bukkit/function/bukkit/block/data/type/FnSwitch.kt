package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.Switch
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.Switch"])
@PlatformSide(Platform.BUKKIT)
object FnSwitch {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Switch::class.java)
                .function("face", returnsObject().noParams()) { it.setReturnRef(it.target?.face) }
                .function("setFace", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setFace(it.getRef(0) as Switch.Face)) }
        }
    }
}
