package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.entity.AbstractHorse
import org.bukkit.entity.Horse
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

@Requires(classes = ["org.bukkit.entity.AbstractHorse"])
@PlatformSide(Platform.BUKKIT)
object FnAbstractHorse {

    val TYPE = Type.fromClass(AbstractHorse::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AbstractHorse::class.java)
                .function("setVariant", returnsVoid().params(Type.OBJECT)) { it.target?.setVariant(it.getRef(0) as Horse.Variant) }
                .function("domestication", returns(Type.I).noParams()) { it.setReturnInt(it.target?.domestication ?: 0) }
                .function("setDomestication", returnsVoid().params(Type.I)) { it.target?.setDomestication(it.getInt(0).toInt()) }
                .function("maxDomestication", returns(Type.I).noParams()) { it.setReturnInt(it.target?.maxDomestication ?: 0) }
                .function("setMaxDomestication", returnsVoid().params(Type.I)) { it.target?.setMaxDomestication(it.getInt(0).toInt()) }
                .function("jumpStrength", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.jumpStrength ?: 0.0) }
                .function("setJumpStrength", returnsVoid().params(Type.D)) { it.target?.setJumpStrength(it.getDouble(0)) }
                .function("isEatingHaystack", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isEatingHaystack ?: false) }
                .function("setEatingHaystack", returnsVoid().params(Type.Z)) { it.target?.setEatingHaystack(it.getBool(0)) }
                .function("inventory", returnsObject().noParams()) { it.setReturnRef(it.target?.inventory) }
        }
    }
}
