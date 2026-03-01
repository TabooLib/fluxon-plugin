package org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard

import org.bukkit.OfflinePlayer
import org.bukkit.scoreboard.DisplaySlot
import org.bukkit.scoreboard.Objective
import org.bukkit.scoreboard.RenderType
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.scoreboard.Objective"])
@PlatformSide(Platform.BUKKIT)
object FnObjective {

    val TYPE = Type.fromClass(Objective::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Objective::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("displayName", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsVoid().params(Type.STRING)) { it.target?.setDisplayName(it.getString(0)!!) }
                .function("criteria", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.criteria) }
                .function("trackedCriteria", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnCriteria.TYPE).noParams()) { it.setReturnRef(it.target?.trackedCriteria) }
                .function("isModifiable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isModifiable ?: false) }
                .function("scoreboard", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScoreboard.TYPE).noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("unregister", returnsVoid().noParams()) { it.target?.unregister() }
                .function("setDisplaySlot", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnDisplaySlot.TYPE)) { it.target?.setDisplaySlot(it.getRef(0) as DisplaySlot)  }
                .function("setDisplaySlot", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnDisplaySlot.enumValue(it.getString(0))?.let { p0 -> it.target?.setDisplaySlot(p0)  } }
                .function("displaySlot", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnDisplaySlot.TYPE).noParams()) { it.setReturnRef(it.target?.displaySlot) }
                .function("setRenderType", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.TYPE)) { it.target?.setRenderType(it.getRef(0) as RenderType)  }
                .function("setRenderType", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.enumValue(it.getString(0))?.let { p0 -> it.target?.setRenderType(p0)  } }
                .function("renderType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnRenderType.TYPE).noParams()) { it.setReturnRef(it.target?.renderType) }
                .function("getScore", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScore.TYPE).params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.FnOfflinePlayer.TYPE)) { it.setReturnRef(it.target?.getScore(it.getRef(0) as OfflinePlayer)) }
                .function("getScore", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.scoreboard.FnScore.TYPE).params(Type.STRING)) { it.setReturnRef(it.target?.getScore(it.getString(0)!!)) }
        }
    }
}
