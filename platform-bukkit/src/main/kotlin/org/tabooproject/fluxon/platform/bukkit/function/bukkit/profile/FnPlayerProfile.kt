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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.profile.PlayerProfile"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerProfile {

    val TYPE = Type.fromClass(PlayerProfile::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerProfile::class.java)
                .function("uniqueId",returns(org.tabooproject.fluxon.util.StandardTypes.UUID).noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("textures",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerTextures.TYPE).noParams()) { it.setReturnRef(it.target?.textures) }
                .function("setTextures",returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerTextures.TYPE)) {
                    it.target?.setTextures(it.getRef(0) as PlayerTextures)
                }
                .function("isComplete", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isComplete ?: false) }
                .function("update", returns(Type.fromClass(java.util.concurrent.CompletableFuture::class.java)).noParams()) { it.setReturnRef(it.target?.update()) }
                .function("clone",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile.TYPE).noParams()) { it.setReturnRef(it.target?.clone()) }
        }
    }
}
