package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementDisplay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.advancement.AdvancementDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnAdvancementDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementDisplay::class.java)
                .function("title", returnsObject().noParams()) { it.setReturnRef(it.target?.title) }
                .function("description", returnsObject().noParams()) { it.setReturnRef(it.target?.description) }
                .function("icon", returnsObject().noParams()) { it.setReturnRef(it.target?.icon) }
                .function("shouldShowToast", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.shouldShowToast()) }
                .function("shouldAnnounceChat", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.shouldAnnounceChat()) }
                .function("isHidden", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isHidden) }
                .function("x", returnsObject().noParams()) { it.setReturnRef(it.target?.x) }
                .function("y", returnsObject().noParams()) { it.setReturnRef(it.target?.y) }
                .function("type", returnsObject().noParams()) { it.setReturnRef(it.target?.type) }
        }
    }
}
