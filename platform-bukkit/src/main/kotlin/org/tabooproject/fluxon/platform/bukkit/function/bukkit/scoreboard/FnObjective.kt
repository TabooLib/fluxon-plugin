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
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
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
                .function("trackedCriteria", returnsObject().noParams()) { it.setReturnRef(it.target?.trackedCriteria) }
                .function("isModifiable", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isModifiable ?: false) }
                .function("scoreboard", returnsObject().noParams()) { it.setReturnRef(it.target?.scoreboard) }
                .function("unregister", returnsVoid().noParams()) { it.target?.unregister() }
                .function("setDisplaySlot", returnsVoid().params(Type.OBJECT)) { it.target?.setDisplaySlot(it.getRef(0) as DisplaySlot) }
                .function("displaySlot", returnsObject().noParams()) { it.setReturnRef(it.target?.displaySlot) }
                .function("setRenderType", returnsVoid().params(Type.OBJECT)) { it.target?.setRenderType(it.getRef(0) as RenderType) }
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
