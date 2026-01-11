package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.AttributeModifier
import org.bukkit.inventory.EquipmentSlot
import org.bukkit.inventory.EquipmentSlotGroup

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import java.util.UUID

object FnAttributeModifier {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
//            registerFunction("attributeModifier", 3) {
//                AttributeModifier(
//                    it.getString(0)!!,
//                    it.getNumber(1).toDouble(),
//                    AttributeModifier.Operation.valueOf(it.getString(2)!!.uppercase())
//                )
//            }
//            registerFunction("attributeModifier", 4) {
//                AttributeModifier(
//                    UUID.fromString(it.getString(0)),
//                    it.getString(1)!!,
//                    it.getNumber(2).toDouble(),
//                    AttributeModifier.Operation.valueOf(it.getString(3)!!.uppercase())
//                )
//            }
//            registerFunction("attributeModifier", 5) {
//                when (val slot = it.getArgument(4)) {
//                    is EquipmentSlotGroup -> AttributeModifier(
//                        UUID.fromString(it.getString(0)),
//                        it.getString(1)!!,
//                        it.getNumber(2).toDouble(),
//                        AttributeModifier.Operation.valueOf(it.getString(3)!!.uppercase()),
//                        slot
//                    )
//                    is String -> AttributeModifier(
//                        UUID.fromString(it.getString(0)),
//                        it.getString(1)!!,
//                        it.getNumber(2).toDouble(),
//                        AttributeModifier.Operation.valueOf(it.getString(3)!!.uppercase()),
//                        EquipmentSlot.valueOf(slot)
//                    )
//                    else -> null
//                }
//            }

            registerExtension(AttributeModifier::class.java)
                .function("uniqueId", 0) { TODO() }
                .function("name", 0) { TODO() }
                .function("amount", 0) { TODO() }
                .function("operation", 0) { TODO() }
                .function("slot", 0) { TODO() }
                .function("slotGroup", 0) { TODO() }
                .function("equals", 1) { TODO() }
                .function("hashCode", 0) { TODO() }
                .function("toString", 0) { TODO() }
                .function("deserialize", 2) { TODO() }
        }
    }
}
