package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.ChatColor
import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.NameTagVisibility
import org.bukkit.scoreboard.Team
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scoreboard.Team"])
@PlatformSide(Platform.BUKKIT)
object FnTeam {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Team::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplayName(it.getString(0)!!)) }
                .function("prefix", returnsObject().noParams()) { it.setReturnRef(it.target?.prefix) }
                .function("setPrefix", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setPrefix(it.getString(0)!!)) }
                .function("suffix", returnsObject().noParams()) { it.setReturnRef(it.target?.suffix) }
                .function("setSuffix", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setSuffix(it.getString(0)!!)) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setColor(it.getRef(0) as ChatColor)) }
                .function("allowFriendlyFire", returnsObject().noParams()) { it.setReturnRef(it.target?.allowFriendlyFire()) }
                .function("setAllowFriendlyFire", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setAllowFriendlyFire(it.getBool(0))) }
                .function("canSeeFriendlyInvisibles", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.canSeeFriendlyInvisibles()) }
                .function("setCanSeeFriendlyInvisibles", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setCanSeeFriendlyInvisibles(it.getBool(0))) }
                .function("nameTagVisibility", returnsObject().noParams()) { it.setReturnRef(it.target?.nameTagVisibility) }
                .function("setNameTagVisibility", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setNameTagVisibility(it.getRef(0) as NameTagVisibility)) }
                .function("players", returnsObject().noParams()) { it.setReturnRef(it.target?.players) }
                .function("entries", returnsObject().noParams()) { it.setReturnRef(it.target?.entries) }
                .function("size", returns(Type.I).noParams()) { it.setReturnRef(it.target?.size) }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("addPlayer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addPlayer(it.getRef(0) as OfflinePlayer)) }
                .function("addEntry", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addEntry(it.getString(0)!!)) }
                .function("removePlayer", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removePlayer(it.getRef(0) as OfflinePlayer)) }
                .function("removeEntry", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeEntry(it.getString(0)!!)) }
                .function("unregister", returnsObject().noParams()) { it.setReturnRef(it.target?.unregister()) }
                .function("hasPlayer", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasPlayer(it.getRef(0) as OfflinePlayer)) }
                .function("hasEntry", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.hasEntry(it.getString(0)!!)) }
                .function("getOption", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getOption(it.getRef(0) as Team.Option)) }
                .function("setOption", returnsObject().params(Type.OBJECT, Type.OBJECT)) {
                    it.setReturnRef(it.target?.setOption(
                        it.getRef(0) as Team.Option,
                        it.getRef(1) as Team.OptionStatus
                    ))
                }
        }
    }
}
