package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import com.google.common.base.Enums
import org.bukkit.attribute.AttributeModifier
import org.tabooproject.fluxon.function.FnEnumGetter
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlot
import org.tabooproject.fluxon.platform.bukkit.function.bukkit.inventory.FnEquipmentSlotGroup
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.attribute.AttributeModifier"])
@PlatformSide(Platform.BUKKIT)
object FnAttributeModifier {

    val TYPE = Type.fromClass(AttributeModifier::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AttributeModifier::class.java)
                .function("uniqueId", returns(StandardTypes.UUID).noParams()) { it.setReturnRef(it.target?.uniqueId) }
                .function("name", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.name) }
                .function("amount", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.amount ?: 0.0) }
                .function("operation", returns(FnAttributeModifierOperation.TYPE).noParams()) { it.setReturnRef(it.target?.operation) }
                .function("slot", returns(FnEquipmentSlot.TYPE).noParams()) { it.setReturnRef(it.target?.slot) }
                .function("slotGroup", returns(FnEquipmentSlotGroup.TYPE).noParams()) { it.setReturnRef(it.target?.slotGroup) }
                .function("deserialize", returns(TYPE).params(Type.MAP)) { it.setReturnRef(AttributeModifier.deserialize(it.getRef(0) as Map<String, Any>)) }
        }
    }
}

@Requires(classes = ["org.bukkit.attribute.AttributeModifier.Operation"])
@PlatformSide(Platform.BUKKIT)
object FnAttributeModifierOperation : FnEnumGetter<AttributeModifier.Operation>() {

    override val enumClass: Class<AttributeModifier.Operation> = AttributeModifier.Operation::class.java
}