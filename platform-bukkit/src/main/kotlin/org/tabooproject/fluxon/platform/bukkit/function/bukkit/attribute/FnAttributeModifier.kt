package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.AttributeModifier
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires

@Requires(classes = ["org.bukkit.attribute.AttributeModifier"])
@PlatformSide(Platform.BUKKIT)
object FnAttributeModifier {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AttributeModifier::class.java)
                .function("uniqueId", 0) { it.target?.uniqueId }
                .function("name", 0) { it.target?.name }
                .function("amount", 0) { it.target?.amount }
                .function("operation", 0) { it.target?.operation }
                .function("slot", 0) { it.target?.slot }
                .function("slotGroup", 0) { it.target?.slotGroup }
                .function("equals", 1) { it.target?.equals(it.getArgument(0)) }
                .function("hashCode", 0) { it.target?.hashCode() }
                .function("toString", 0) { it.target?.toString() }
                .function("deserialize", 1) { AttributeModifier.deserialize(it.getArgument(0) as Map<String, Any>) }
        }
    }
}
