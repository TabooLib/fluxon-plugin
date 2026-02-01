package org.tabooproject.fluxon.platform.bukkit.function.bukkit.packs

import org.bukkit.packs.ResourcePack
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.packs.ResourcePack"])
@PlatformSide(Platform.BUKKIT)
object FnResourcePack {

    val TYPE = Type.fromClass(ResourcePack::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ResourcePack::class.java)
                .function("id", returnsObject().noParams()) { it.setReturnRef(it.target?.id) }
                .function("url", returnsObject().noParams()) { it.setReturnRef(it.target?.url) }
                .function("hash", returnsObject().noParams()) { it.setReturnRef(it.target?.hash) }
                .function("prompt", returnsObject().noParams()) { it.setReturnRef(it.target?.prompt) }
                .function("isRequired", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isRequired ?: false) }
        }
    }
}
