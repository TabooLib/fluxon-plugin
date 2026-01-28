package org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile

import org.bukkit.profile.PlayerProfile
import org.bukkit.profile.PlayerTextures
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.profile.PlayerProfile"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerProfile {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerProfile::class.java)
                .function("uniqueId", returnsObject().noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("textures", returnsObject().noParams()) { it.setReturnRef(it.target?.textures) }
                .function("setTextures", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setTextures(it.getRef(0) as PlayerTextures)) }
                .function("isComplete", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isComplete) }
                .function("update", returnsObject().noParams()) { it.setReturnRef(it.target?.update()) }
                .function("clone", returnsObject().noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
