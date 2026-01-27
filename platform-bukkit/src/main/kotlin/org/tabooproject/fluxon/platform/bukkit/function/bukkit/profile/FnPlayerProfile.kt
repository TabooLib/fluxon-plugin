package org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile

import org.bukkit.profile.PlayerProfile
import org.bukkit.profile.PlayerTextures
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.profile.PlayerProfile"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerProfile {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerProfile::class.java)
                .function("uniqueId", 0) { it.target?.uniqueId }
                .function("name", 0) { it.target?.name }
                .function("textures", 0) { it.target?.textures }
                .function("setTextures", 1) { it.target?.setTextures(it.getArgument(0) as PlayerTextures) }
                .function("isComplete", 0) { it.target?.isComplete }
                .function("update", 0) { it.target?.update() }
                .function("clone", 0) { it.target?.clone() }
        }
    }
}
