package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.AttributeInstance
import org.bukkit.attribute.AttributeModifier

import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake

object FnAttributeInstance {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AttributeInstance::class.java)
                .function("attribute", 0) { it.target?.attribute?.name }
                .function("baseValue", 0) { it.target?.baseValue }
                .function("setBaseValue", 1) { it.target?.baseValue = it.getNumber(0).toDouble() }
                .function("modifiers", 0) { it.target?.modifiers }
                .function("addModifier", 1) { it.target?.addModifier(it.getArgument(0) as AttributeModifier) }
                .function("removeModifier", 1) { it.target?.removeModifier(it.getArgument(0) as AttributeModifier) }
                .function("value", 0) { it.target?.value }
                .function("defaultValue", 0) { it.target?.defaultValue }
        }
    }
}
