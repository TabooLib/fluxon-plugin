package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementProgress
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.advancement.AdvancementProgress"])
@PlatformSide(Platform.BUKKIT)
object FnAdvancementProgress {

    val TYPE = Type.fromClass(AdvancementProgress::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementProgress::class.java)
                .function("advancement", returns(FnAdvancement.TYPE).noParams()) { it.setReturnRef(it.target?.advancement) }
                .function("isDone", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDone ?: false) }
                .function("awardCriteria", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.awardCriteria(it.getString(0)!!) ?: false)
                }
                .function("revokeCriteria", returns(Type.Z).params(Type.STRING)) {
                    it.setReturnBool(it.target?.revokeCriteria(it.getString(0)!!) ?: false)
                }
                .function("getDateAwarded", returns(StandardTypes.DATE).params(Type.STRING)) { it.setReturnRef(it.target?.getDateAwarded(it.getString(0)!!)) }
                .function("remainingCriteria", returns(StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.remainingCriteria) }
                .function("awardedCriteria", returns(StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.awardedCriteria) }
        }
    }
}
