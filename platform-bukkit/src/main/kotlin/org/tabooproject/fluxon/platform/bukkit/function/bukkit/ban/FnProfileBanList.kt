package org.tabooproject.fluxon.platform.bukkit.function.bukkit.ban

import org.bukkit.ban.ProfileBanList
import org.bukkit.profile.PlayerProfile
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnBanEntry
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.profile.FnPlayerProfile
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.*
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.ban.ProfileBanList"])
@PlatformSide(Platform.BUKKIT)
object FnProfileBanList {

    val TYPE = Type.fromClass(ProfileBanList::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ProfileBanList::class.java)
                .function("addBan", returns(FnBanEntry.TYPE).params(FnPlayerProfile.TYPE, Type.STRING, StandardTypes.DATE, Type.STRING)) {
                    it.setReturnRef(it.target?.addBan(
                        it.getRef(0) as PlayerProfile,
                        it.getString(1),
                        it.getRef(2) as Date,
                        it.getString(3)
                    ))
                }
        }
    }
}
