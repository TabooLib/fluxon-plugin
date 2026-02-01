package org.tabooproject.fluxon.platform.bukkit.function.bukkit

import org.bukkit.ChatColor
import org.tabooproject.fluxon.runtime.FluxonRuntime
import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.common.platform.Platform
import taboolib.common.platform.PlatformSide
import taboolib.common.Requires
import org.tabooproject.fluxon.runtime.FunctionSignature.returnsObject
import org.tabooproject.fluxon.runtime.Type
import org.tabooproject.fluxon.runtime.FunctionSignature.returns

@Requires(classes = ["org.bukkit.ChatColor"])
@PlatformSide(Platform.BUKKIT)
object FnChatColor {

    val TYPE = Type.fromClass(ChatColor::class.java)

    @Awake(LifeCycle.INIT)
    private fun init() {
        with(FluxonRuntime.getInstance()) {
            registerExtension(ChatColor::class.java)
                .function("char", returnsObject().noParams()) { it.setReturnRef(it.target?.char) }
                .function("toString", returns(Type.STRING).noParams()) { it.setReturnRef(it.target?.toString()) }
                .function("isFormat", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isFormat ?: false) }
                .function("isColor", returns(Type.Z).noParams()) { it.setReturnBool(it.target?.isColor ?: false) }
                // static
                .function("getByChar", returnsObject().params(Type.OBJECT)) {
                    it.setReturnRef(ChatColor.getByChar(it.getString(0)))
                }
                // static
                .function("stripColor", returnsObject().params(Type.STRING)) { it.setReturnRef(ChatColor.stripColor(it.getString(0))) }
                // static
                .function("translateAlternateColorCodes", returnsObject().params(Type.STRING, Type.STRING)) {
                    it.setReturnRef(ChatColor.translateAlternateColorCodes(
                        it.getString(0)?.firstOrNull()!!, it.getString(1)!!
                    ))
                }
                // static
                .function("getLastColors", returnsObject().params(Type.STRING)) { it.setReturnRef(ChatColor.getLastColors(it.getString(0)!!)) }
        }
    }
}
