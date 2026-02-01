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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scoreboard.Team"])
@PlatformSide(Platform.BUKKIT)
object FnTeam {

    val TYPE = Type.fromClass(Team::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Team::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsVoid().params(Type.STRING)) { it.target?.setDisplayName(it.getString(0)!!) }
                .function("prefix", returnsObject().noParams()) { it.setReturnRef(it.target?.prefix) }
                .function("setPrefix", returnsVoid().params(Type.STRING)) { it.target?.setPrefix(it.getString(0)!!) }
                .function("suffix", returnsObject().noParams()) { it.setReturnRef(it.target?.suffix) }
                .function("setSuffix", returnsVoid().params(Type.STRING)) { it.target?.setSuffix(it.getString(0)!!) }
                .function("color", returnsObject().noParams()) { it.setReturnRef(it.target?.color) }
                .function("setColor", returnsVoid().params(Type.OBJECT)) { it.target?.setColor(it.getRef(0) as ChatColor) }
                .function("allowFriendlyFire", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.allowFriendlyFire() ?: false) }
                .function("setAllowFriendlyFire", returnsVoid().params(Type.Z)) { it.target?.setAllowFriendlyFire(it.getBool(0)) }
                .function("canSeeFriendlyInvisibles", returns(Type.Z).noParams()) {
                    it.setReturnBool(it.target?.canSeeFriendlyInvisibles() ?: false)
                }
                .function("setCanSeeFriendlyInvisibles", returnsVoid().params(Type.Z)) {
                    it.target?.setCanSeeFriendlyInvisibles(it.getBool(0))
                }
                .function("nameTagVisibility", returnsObject().noParams()) { it.setReturnRef(it.target?.nameTagVisibility) }
                .function("setNameTagVisibility", returnsVoid().params(Type.OBJECT)) {
                    it.target?.setNameTagVisibility(it.getRef(0) as NameTagVisibility)
                }
                .function("players", returnsObject().noParams()) { it.setReturnRef(it.target?.players) }
                .function("entries", returnsObject().noParams()) { it.setReturnRef(it.target?.entries) }
                .function("size", returns(Type.I).noParams()) { it.setReturnInt(it.target?.size ?: 0) }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("addPlayer", returnsVoid().params(Type.OBJECT)) {
                    it.target?.addPlayer(it.getRef(0) as OfflinePlayer)
                }
                .function("addEntry", returnsVoid().params(Type.STRING)) {
                    it.target?.addEntry(it.getString(0)!!)
                }
                .function("removePlayer", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.removePlayer(it.getRef(0) as OfflinePlayer) ?: false)
                }
                .function("removeEntry", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.removeEntry(it.getString(0)!!) ?: false)
                }
                .function("unregister", returnsVoid().noParams()) { it.target?.unregister() }
                .function("hasPlayer", returns(Type.Z).params(Type.OBJECT)) {
                    it.setReturnBool(it.target?.hasPlayer(it.getRef(0) as OfflinePlayer) ?: false)
                }
                .function("hasEntry", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.hasEntry(it.getString(0)!!) ?: false)
                }
                .function("getOption", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getOption(it.getRef(0) as Team.Option)) }
                .function("setOption", returnsVoid().params(Type.OBJECT, Type.OBJECT)) {
                    it.target?.setOption(
                        it.getRef(0) as Team.Option,
                        it.getRef(1) as Team.OptionStatus
                    )
                }
        }
    }
}
