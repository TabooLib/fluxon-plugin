package org.tabooproject.fluxon.platform.bukkit.function.bukkit.ban

import org.bukkit.ban.ProfileBanList
import org.bukkit.profile.PlayerProfile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@PlatformSide(Platform.BUKKIT)
object FnProfileBanList {
    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ProfileBanList::class.java)
                .function("addBan", 4) {
                    it.target?.addBan(
                        it.getArgument(0) as PlayerProfile,
                        it.getString(1),
                        Date(it.getNumber(2).toLong()),
                        it.getString(3)
                    )
                }
        }
    }
}
