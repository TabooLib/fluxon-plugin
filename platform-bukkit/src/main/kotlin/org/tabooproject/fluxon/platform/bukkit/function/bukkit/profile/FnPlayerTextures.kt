package org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile

import org.bukkit.profile.PlayerTextures
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.net.URL
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.profile.PlayerTextures"])
@PlatformSide(Platform.BUKKIT)
object FnPlayerTextures {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(PlayerTextures::class.java)
                .function("isEmpty", 0) { it.target?.isEmpty }
                .function("clear", 0) { it.target?.clear() }
                .function("skin", 0) { it.target?.skin }
                .function("setSkin", listOf(1, 2)) {
                    if (it.arguments.size == 1) {
                        it.target?.setSkin(URL(it.getString(0)))
                    } else {
                        it.target?.setSkin(
                            URL(it.getString(0)),
                            it.getArgument(1) as PlayerTextures.SkinModel
                        )
                    }
                }
                .function("skinModel", 0) { it.target?.skinModel }
                .function("cape", 0) { it.target?.cape }
                .function("setCape", 1) { it.target?.setCape(URL(it.getString(0))) }
                .function("timestamp", 0) { it.target?.timestamp }
                .function("isSigned", 0) { it.target?.isSigned }
        }
    }
}
