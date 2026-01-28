package org.tabooproject.fluxon.platform.bukkit.function.bukkit.advancement

import org.bukkit.advancement.AdvancementProgress
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.advancement.AdvancementProgress"])
@PlatformSide(Platform.BUKKIT)
object FnAdvancementProgress {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AdvancementProgress::class.java)
                .function("advancement", returnsObject().noParams()) { it.setReturnRef(it.target?.advancement) }
                .function("isDone", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isDone) }
                .function("awardCriteria", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.awardCriteria(it.getString(0)!!)) }
                .function("revokeCriteria", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.revokeCriteria(it.getString(0)!!)) }
                .function("getDateAwarded", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.getDateAwarded(it.getString(0)!!)) }
                .function("remainingCriteria", returnsObject().noParams()) { it.setReturnRef(it.target?.remainingCriteria) }
                .function("awardedCriteria", returnsObject().noParams()) { it.setReturnRef(it.target?.awardedCriteria) }
        }
    }
}
