package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.AttributeModifier
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.attribute.AttributeModifier"])
@PlatformSide(Platform.BUKKIT)
object FnAttributeModifier {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AttributeModifier::class.java)
                .function("uniqueId", returnsObject().noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("amount", returnsObject().noParams()) { it.setReturnRef(it.target?.amount) }
                .function("operation", returnsObject().noParams()) { it.setReturnRef(it.target?.operation) }
                .function("slot", returnsObject().noParams()) { it.setReturnRef(it.target?.slot) }
                .function("slotGroup", returnsObject().noParams()) { it.setReturnRef(it.target?.slotGroup) }
                .function("equals", returns(Type.Z).params(Type.OBJECT)) { it.setReturnRef(it.target?.equals(it.getRef(0))) }
                .function("hashCode", returns(Type.I).noParams()) { it.setReturnRef(it.target?.hashCode()) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("deserialize", returnsObject().params(Type.OBJECT)) { it.setReturnRef(AttributeModifier.deserialize(it.getRef(0) as Map<String, Any>)) }
        }
    }
}
