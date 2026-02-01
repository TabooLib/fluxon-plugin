package org.tabooproject.fluxon.platform.bukkit.function.bukkit.block.data.type

import org.bukkit.block.data.type.TechnicalPiston
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.runtime.FluxonRuntime
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.block.data.type.TechnicalPiston"])
@PlatformSide(Platform.BUKKIT)
object FnTechnicalPiston {

    val TYPE = Type.fromClass(TechnicalPiston::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TechnicalPiston::class.java)
                .function("type", returns(FnTechnicalPistonType.TYPE).noParams()) { it.setReturnRef(it.target?.type) }
                .function("setType", returnsVoid().params(FnTechnicalPistonType.TYPE)) { it.target?.setType(it.getRef(0) as TechnicalPiston.Type) }
                .function("setType", returnsVoid().params(Type.STRING)) { FnTechnicalPistonType.enumValue(it.getString(0))?.let { p0 -> it.target?.setType(p0) } }
        }
    }
}

@Requires(classes = ["org.bukkit.block.data.type.TechnicalPiston.Type"])
@PlatformSide(Platform.BUKKIT)
object FnTechnicalPistonType : FnEnumGetter<TechnicalPiston.Type>() {

    override val enumClass: Class<TechnicalPiston.Type> = TechnicalPiston.Type::class.java
}