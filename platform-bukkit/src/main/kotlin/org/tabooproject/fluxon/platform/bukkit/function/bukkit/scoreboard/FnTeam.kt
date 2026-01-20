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

@PlatformSide(Platform.BUKKIT)
object FnTeam {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Team::class.java)
                .function("name", 0) { it.target?.name }
                .function("displayName", 0) { it.target?.displayName }
                .function("setDisplayName", 1) { it.target?.setDisplayName(it.getString(0)!!) }
                .function("prefix", 0) { it.target?.prefix }
                .function("setPrefix", 1) { it.target?.setPrefix(it.getString(0)!!) }
                .function("suffix", 0) { it.target?.suffix }
                .function("setSuffix", 1) { it.target?.setSuffix(it.getString(0)!!) }
                .function("color", 0) { it.target?.color }
                .function("setColor", 1) { it.target?.setColor(it.getArgument(0) as ChatColor) }
                .function("allowFriendlyFire", 0) { it.target?.allowFriendlyFire() }
                .function("setAllowFriendlyFire", 1) { it.target?.setAllowFriendlyFire(it.getBoolean(0)) }
                .function("canSeeFriendlyInvisibles", 0) { it.target?.canSeeFriendlyInvisibles() }
                .function("setCanSeeFriendlyInvisibles", 1) { it.target?.setCanSeeFriendlyInvisibles(it.getBoolean(0)) }
                .function("nameTagVisibility", 0) { it.target?.nameTagVisibility }
                .function(
                    "setNameTagVisibility",
                    1
                ) { it.target?.setNameTagVisibility(it.getArgument(0) as NameTagVisibility) }
                .function("players", 0) { it.target?.players }
                .function("entries", 0) { it.target?.entries }
                .function("size", 0) { it.target?.size }
                .function("scoreboard", 0) { it.target?.scoreboard }
                .function("addPlayer", 1) { it.target?.addPlayer(it.getArgument(0) as OfflinePlayer) }
                .function("addEntry", 1) { it.target?.addEntry(it.getString(0)!!) }
                .function("removePlayer", 1) { it.target?.removePlayer(it.getArgument(0) as OfflinePlayer) }
                .function("removeEntry", 1) { it.target?.removeEntry(it.getString(0)!!) }
                .function("unregister", 0) { it.target?.unregister() }
                .function("hasPlayer", 1) { it.target?.hasPlayer(it.getArgument(0) as OfflinePlayer) }
                .function("hasEntry", 1) { it.target?.hasEntry(it.getString(0)!!) }
                .function("option", 1) { it.target?.getOption(it.getArgument(0) as Team.Option) }
                .function("setOption", 2) {
                    it.target?.setOption(
                        it.getArgument(0) as Team.Option,
                        it.getArgument(1) as Team.OptionStatus
                    )
                }
        }
    }
}
