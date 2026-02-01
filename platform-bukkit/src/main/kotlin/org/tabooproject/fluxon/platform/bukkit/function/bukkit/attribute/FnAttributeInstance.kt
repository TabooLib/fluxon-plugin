package org.tabooproject.fluxon.platform.bukkit.function.bukkit.attribute

import org.bukkit.attribute.AttributeInstance
import org.bukkit.attribute.AttributeModifier
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returns
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsVoid
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.util.StandardTypes

@Requires(classes = ["org.bukkit.attribute.AttributeInstance"])
@PlatformSide(Platform.BUKKIT)
object FnAttributeInstance {

    val TYPE = Type.fromClass(AttributeInstance::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(AttributeInstance::class.java)
                .function("attribute", returns(FnAttribute.TYPE).noParams()) { it.setReturnRef(it.target?.attribute) }
                .function("baseValue", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.baseValue ?: 0.0) }
                .function("setBaseValue", returnsVoid().params(Type.D)) { it.target?.setBaseValue(it.getDouble(0)) }
                .function("modifiers", returns(StandardTypes.COLLECTION).noParams()) { it.setReturnRef(it.target?.modifiers) }
                .function("addModifier", returnsVoid().params(FnAttributeModifier.TYPE)) { it.target?.addModifier(it.getRef(0) as AttributeModifier) }
                .function("removeModifier", returnsVoid().params(FnAttributeModifier.TYPE)) { it.target?.removeModifier(it.getRef(0) as AttributeModifier) }
                .function("value", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.value ?: 0.0) }
                .function("defaultValue", returns(Type.D).noParams()) { it.setReturnDouble(it.target?.defaultValue ?: 0.0) }
        }
    }
}
