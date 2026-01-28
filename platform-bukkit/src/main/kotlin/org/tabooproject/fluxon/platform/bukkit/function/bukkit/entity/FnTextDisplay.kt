package org.tabooproject.fluxon.platform.bukkit.function.bukkit.entity

import org.bukkit.Color
import org.bukkit.entity.TextDisplay
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.entity.TextDisplay"])
@PlatformSide(Platform.BUKKIT)
object FnTextDisplay {

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(TextDisplay::class.java)
                .function("text", returnsObject().noParams()) { it.target?.text }
                .function("setText", returnsObject().params(Type.OBJECT)) { it.target?.setText(it.getString(0)) }
                .function("lineWidth", returnsObject().noParams()) { it.target?.lineWidth }
                .function("setLineWidth", returnsObject().params(Type.OBJECT)) { it.target?.setLineWidth(it.getInt(0).toInt()) }
                .function("backgroundColor", returnsObject().noParams()) { it.target?.backgroundColor }
                .function("setBackgroundColor", returnsObject().params(Type.OBJECT)) { it.target?.setBackgroundColor(it.getRef(0) as Color) }
                .function("textOpacity", returnsObject().noParams()) { it.target?.textOpacity }
                .function("setTextOpacity", returnsObject().params(Type.OBJECT)) { it.target?.setTextOpacity(it.getInt(0).toByte()) }
                .function("isShadowed", returns(Type.Z).noParams()) { it.target?.isShadowed }
                .function("setShadowed", returnsObject().params(Type.OBJECT)) { it.target?.setShadowed(it.getBool(0)) }
                .function("isSeeThrough", returns(Type.Z).noParams()) { it.target?.isSeeThrough }
                .function("setSeeThrough", returnsObject().params(Type.OBJECT)) { it.target?.setSeeThrough(it.getBool(0)) }
                .function("isDefaultBackground", returns(Type.Z).noParams()) { it.target?.isDefaultBackground }
                .function("setDefaultBackground", returnsObject().params(Type.OBJECT)) { it.target?.setDefaultBackground(it.getBool(0)) }
                .function("alignment", returnsObject().noParams()) { it.target?.alignment }
                .function("setAlignment", returnsObject().params(Type.OBJECT)) { it.target?.setAlignment(it.getRef(0) as TextDisplay.TextAlignment) }
        }
    }
}
