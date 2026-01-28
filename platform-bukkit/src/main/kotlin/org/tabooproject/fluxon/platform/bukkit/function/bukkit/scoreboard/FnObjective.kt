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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.scoreboard.Objective"])
@PlatformSide(Platform.BUKKIT)
object FnObjective {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Objective::class.java)
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("displayName", returnsObject().noParams()) { it.setReturnRef(it.target?.displayName) }
                .function("setDisplayName", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplayName(it.getString(0)!!)) }
                .function("criteria", returnsObject().noParams()) { it.setReturnRef(it.target?.criteria) }
                .function("trackedCriteria", returnsObject().noParams()) { it.setReturnRef(it.target?.trackedCriteria) }
                .function("isModifiable", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isModifiable) }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("unregister", returnsObject().noParams()) { it.setReturnRef(it.target?.unregister()) }
                .function("setDisplaySlot", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDisplaySlot(it.getRef(0) as DisplaySlot)) }
                .function("displaySlot", returnsObject().noParams()) { it.setReturnRef(it.target?.displaySlot) }
                .function("setRenderType", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setRenderType(it.getRef(0) as RenderType)) }
                .function("renderType", returnsObject().noParams()) { it.setReturnRef(it.target?.renderType) }
                .function("getScore", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(when (val var1 = it.getRef(0)) {
                        is OfflinePlayer -> it.target?.getScore(var1)
                        is String -> it.target?.getScore(var1)
                        else -> throw IllegalArgumentException("参数必须是 OfflinePlayer 或 String 类型")
                    })
                }
        }
    }
}
