package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.Rabbit
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.entity.Rabbit"])
@PlatformSide(Platform.BUKKIT)
object FnRabbit {

    val TYPE = Type.fromClass(Rabbit::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(Rabbit::class.java)
                .function("rabbitType", returns(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnRabbitType.TYPE).noParams()) { it.setReturnRef(it.target?.rabbitType) }
                .function("setRabbitType", returnsVoid().params(org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnRabbitType.TYPE)) { it.target?.setRabbitType(it.getRef(0) as Rabbit.Type)  }
                .function("setRabbitType", returnsVoid().params(Type.STRING)) { org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity.FnRabbitType.enumValue(it.getString(0))?.let { p0 -> it.target?.setRabbitType(p0)  } }
        }
    }
}
