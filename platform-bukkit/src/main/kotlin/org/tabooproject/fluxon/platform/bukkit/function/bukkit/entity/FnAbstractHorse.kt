package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractHorse
import org.bukkit.entity.Horse
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.AbstractHorse"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractHorse {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractHorse::class.java)
                .function("setVariant", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setVariant(it.getRef(0) as Horse.Variant)) }
                .function("domestication", returnsObject().noParams()) { it.setReturnRef(it.target?.domestication) }
                .function("setDomestication", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setDomestication(it.getInt(0).toInt())) }
                .function("maxDomestication", returnsObject().noParams()) { it.setReturnRef(it.target?.maxDomestication) }
                .function("setMaxDomestication", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setMaxDomestication(it.getInt(0).toInt())) }
                .function("jumpStrength", returnsObject().noParams()) { it.setReturnRef(it.target?.jumpStrength) }
                .function("setJumpStrength", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setJumpStrength(it.getAsDouble(0))) }
                .function("isEatingHaystack", returns(Type.Z).noParams()) { it.setReturnRef(it.target?.isEatingHaystack) }
                .function("setEatingHaystack", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setEatingHaystack(it.getBool(0))) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
