package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.CauldronLevelChangeEvent
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlockState
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide

@Requires(classes = ["org.bukkit.event.block.CauldronLevelChangeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnCauldronLevelChangeEvent {

    val TYPE = Type.fromClass(CauldronLevelChangeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(CauldronLevelChangeEvent::class.java)
                .function("entity", returns(FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.entity) }
                .function("reason", returns(FnCauldronLevelChangeEventChangeReason.TYPE).noParams()) { it.setReturnRef(it.target?.reason) }
                .function("newState", returns(FnBlockState.TYPE).noParams()) { it.setReturnRef(it.target?.newState) }
                .function("oldLevel", returns(Type.I).noParams()) { it.setReturnRef(it.target?.oldLevel) }
                .function("newLevel", returns(Type.I).noParams()) { it.setReturnRef(it.target?.newLevel) }
                .function("setNewLevel", returnsVoid().params(Type.I)) { it.target?.setNewLevel(it.getInt(0)) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.block.CauldronLevelChangeEvent.ChangeReason"])
@PlatformSide(Platform.BUKKIT)
object FnCauldronLevelChangeEventChangeReason : FnEnumGetter<CauldronLevelChangeEvent.ChangeReason>() {

    override val enumClass: Class<CauldronLevelChangeEvent.ChangeReason> = CauldronLevelChangeEvent.ChangeReason::class.java
}
