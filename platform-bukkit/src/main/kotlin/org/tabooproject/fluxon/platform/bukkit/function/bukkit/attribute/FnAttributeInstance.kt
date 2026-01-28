package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.AttributeInstance
import org.bukkit.attribute.AttributeModifier
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type

@Requires(classes = ["org.bukkit.attribute.AttributeInstance"])
@PlatformSide(Platform.BUKKIT)
object FnAttributeInstance {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AttributeInstance::class.java)
                .function("attribute", returnsObject().noParams()) { it.setReturnRef(it.target?.attribute) }
                .function("baseValue", returnsObject().noParams()) { it.setReturnRef(it.target?.baseValue) }
                .function("setBaseValue", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.setBaseValue(it.getAsDouble(0))) }
                .function("modifiers", returnsObject().noParams()) { it.setReturnRef(it.target?.modifiers) }
                .function("addModifier", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.addModifier(it.getRef(0) as AttributeModifier)) }
                .function("removeModifier", returnsObject().params(Type.OBJECT)) { it.setReturnRef(it.target?.removeModifier(it.getRef(0) as AttributeModifier)) }
                .function("value", returnsObject().noParams()) { it.setReturnRef(it.target?.value) }
                .function("defaultValue", returnsObject().noParams()) { it.setReturnRef(it.target?.defaultValue) }
        }
    }
}
