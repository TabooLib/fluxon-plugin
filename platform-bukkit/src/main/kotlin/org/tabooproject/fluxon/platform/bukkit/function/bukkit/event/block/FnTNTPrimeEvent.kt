package org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block

import org.bukkit.event.block.TNTPrimeEvent
import org.tabooproject.fluxon.platform.bukkit.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import taboolib.common.LifeCycle
import taboolib.common.Requires
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.event.block.TNTPrimeEvent"])
@PlatformSide(Platform.BUKKIT)
object FnTNTPrimeEvent {

    val TYPE = Type.fromClass(TNTPrimeEvent::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TNTPrimeEvent::class.java)
                .function("cause",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.event.block.FnTNTPrimeEventPrimeCause.TYPE).noParams()) { it.setReturnRef(it.target?.cause) }
                .function("primingEntity",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnEntity.TYPE).noParams()) { it.setReturnRef(it.target?.primingEntity) }
                .function("primingBlock",returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.FnBlock.TYPE).noParams()) { it.setReturnRef(it.target?.primingBlock) }
        }
    }
}

@Requires(classes = ["org.bukkit.event.block.TNTPrimeEvent\$PrimeCause"])
@PlatformSide(Platform.BUKKIT)
object FnTNTPrimeEventPrimeCause : FnEnumGetter<TNTPrimeEvent.PrimeCause>() {

    override val enumClass: Class<TNTPrimeEvent.PrimeCause> = TNTPrimeEvent.PrimeCause::class.java
}