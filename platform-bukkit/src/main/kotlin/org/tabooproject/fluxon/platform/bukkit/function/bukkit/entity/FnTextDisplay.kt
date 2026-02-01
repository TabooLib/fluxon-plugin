package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.entity.TextDisplay
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

@Requires(classes = ["org.bukkit.entity.TextDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnTextDisplay {

    val TYPE = Type.fromClass(TextDisplay::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TextDisplay::class.java)
                .function("text", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.text) }
                .function("setText", returnsVoid().params(Type.STRING)) { it.target?.setText(it.getString(0)) }
                .function("lineWidth", returns(Type.I).noParams()) { it.setReturnInt(it.target?.lineWidth ?: 0) }
                .function("setLineWidth", returnsVoid().params(Type.I)) { it.target?.setLineWidth(it.getInt(0).toInt()) }
                .function("backgroundColor", returnsObject().noParams()) { it.setReturnRef(it.target?.backgroundColor) }
                .function("setBackgroundColor", returnsVoid().params(Type.OBJECT)) { it.target?.setBackgroundColor(it.getRef(0) as Color) }
                .function("textOpacity", returns(Type.I).noParams()) { it.setReturnInt(it.target?.textOpacity?.toInt() ?: 0) }
                .function("setTextOpacity", returnsVoid().params(Type.I)) { it.target?.setTextOpacity(it.getInt(0).toByte()) }
                .function("isShadowed", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isShadowed ?: false) }
                .function("setShadowed", returnsVoid().params(Type.Z)) { it.target?.setShadowed(it.getBool(0)) }
                .function("isSeeThrough", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isSeeThrough ?: false) }
                .function("setSeeThrough", returnsVoid().params(Type.Z)) { it.target?.setSeeThrough(it.getBool(0)) }
                .function("isDefaultBackground", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isDefaultBackground ?: false) }
                .function("setDefaultBackground", returnsVoid().params(Type.Z)) { it.target?.setDefaultBackground(it.getBool(0)) }
                .function("alignment", returnsObject().noParams()) { it.setReturnRef(it.target?.alignment) }
                .function("setAlignment", returnsVoid().params(Type.OBJECT)) { it.target?.setAlignment(it.getRef(0) as TextDisplay.TextAlignment) }
        }
    }
}
